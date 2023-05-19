package com.utils;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.utils.dbUtils.DbConnection;
import com.utils.dbUtils.backend.paragraphData.ParagraphInCreatedStory;
import com.utils.dbUtils.frontend.BlankPaperStoryData;
import com.utils.dbUtils.frontend.ListElement;
import org.bson.Document;
import org.jsoup.Jsoup;

import java.util.List;

public class DbUtils {

    private static DriverController driverController;
    private static DbUtils dbUtils;

    public static DbUtils getInstance() {
        driverController = DriverController.getInstance();
        if (dbUtils == null) {
            dbUtils = new DbUtils();
        }
        return dbUtils;
    }

    public boolean mongoDbConnectionAndStoryDetails(String storyStatus, String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String paragraphFromExcel, String sectionFromExcel, String subSectionFromExcel, String locationFromExcel, String byLine) {
        final boolean[] isResultMatched = {false};
        String textUri = null;
        String database = null;
        String collection = null;
        long storyIdInLong = Long.parseLong(storyID);
        DbConnection db = new DbConnection();
        db.setConnectionStrings(storyStatus, env,property);
        textUri = db.getTextUri();
        database = db.getDatabase();
        collection = db.getCollection();
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("_id", storyIdInLong);
        FindIterable<Document> bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
        String finalTextUri = textUri;
        String finalDatabase = database;
        String finalCollection = collection;
        bp.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
                try {
                    Gson gs = new Gson();
                    BlankPaperStoryData dataFromDocument = gs.fromJson(document.toJson(), BlankPaperStoryData.class);
                    String headline;
                    long elementIdInLong = 0;
                    try {
                        String paragraphElementID = dataFromDocument.getElements().get(0).get$numberLong();
                        elementIdInLong = Long.parseLong(paragraphElementID);
                    }catch(Exception e){}
                    if (storyStatus.equals("PUBLISHED")) {
                        headline = dataFromDocument.getHeadline();
                    } else {
                        headline = dataFromDocument.getTitle();
                    }
                    System.out.println("HeadLine from MongoDB is: " + headline);
                    String section = dataFromDocument.getMetadata().getSection();
                    System.out.println("section from MongoDB is: " + section);
                    String summary = dataFromDocument.getSummary();
                    String summaryWithoutHTMLTags = Jsoup.parse(summary).text();
                    System.out.println("Summary from MongoDB is: " + summaryWithoutHTMLTags);
                    String paragraphWithoutHTMLTags=null;
                    try {
                        switch (property) {
                            case Constants.HT_NEW:
                                List<ListElement> paragraph = dataFromDocument.getListElement();
                                String paragraphBody = paragraph.get(0).getParagraph().getBody();
                                paragraphWithoutHTMLTags = Jsoup.parse(paragraphBody).text();
                                break;

                            case Constants.BANGLA:
                                BasicDBObject whereQuery = new BasicDBObject();
                                whereQuery.put("_id", elementIdInLong);
                                paragraphWithoutHTMLTags = getParagraphValue(db, whereQuery, finalTextUri, finalDatabase, finalCollection);
                                break;
                        }
                    }catch(Exception e){
                        paragraphWithoutHTMLTags = paragraphFromExcel;
                    }
                    System.out.println("Paragraph from MongoDB is: " + paragraphWithoutHTMLTags);
                    String subSection = dataFromDocument.getMetadata().getSubSection();
                    System.out.println("SubSection from MongoDB is: " + subSection);
                    String byLine1=null;
                    if(property.equals(Constants.HT_NEW)){
                        byLine1 = dataFromDocument.getMetadata().getAuthorsList().get(0).getName();
                    }
                    else if(property.equals(Constants.BANGLA)){
                        byLine1 = dataFromDocument.getMetadata().getAuthors().toString().replace("[","").replace("]","").trim();
                    }
                    System.out.println("byLine from MongoDB is: " + byLine);
                    List<String> location = dataFromDocument.getMetadata().getLocation();
                    System.out.println("Location from MongoDB is: " + location);
                    isResultMatched[0] = headlineFromExcel.trim().contains(headline.trim()) && summaryFromExcel.trim().contains(summaryWithoutHTMLTags.trim()) && section.equals(sectionFromExcel) && subSection.equals(subSectionFromExcel) && location.get(0).equals(locationFromExcel) && byLine1.equals(byLine) && paragraphFromExcel.trim().contains(paragraphWithoutHTMLTags.trim());
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }

        });
        return isResultMatched[0];
    }

    public String getParagraphValue(DbConnection db,BasicDBObject whereQuery,String textUri,String database,String collection) {
        final String[] paragraphWithHTMLTags = new String[1];
        FindIterable<Document> bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
        bp.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
                try {
                    Gson gs = new Gson();
                    ParagraphInCreatedStory dataFromDocument = gs.fromJson(document.toJson(), ParagraphInCreatedStory.class);
                    String headline;
                    String paragraph=dataFromDocument.getParagraph().getBody();
                    paragraphWithHTMLTags[0] =Jsoup.parse(paragraph).text();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
        return paragraphWithHTMLTags[0];
    }
}
