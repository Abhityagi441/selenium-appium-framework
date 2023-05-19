package com.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HTMLParser {


    public static void main(String[] args){
        getParagraphList("<p>The Central Vista will be ready to host the next Republic Day parade in 2022, Union minister Hardeep Singh Puri said on Thursday.</p><p>He said the redevelopment work of Central Vista Avenue, stretching from Rashtrapati Bhavan to India Gate, will be completed within two-and-a-half months.</p><p>“We have ongoing work on Central Vista Avenue. The next Republic Day parade on January 26 will be held on the new Central Vista. We will ensure that the winter session of Parliament during the 75th year of Independence will be held in new Parliament,” news agency ANI quoted the minister as saying to media.</p><p>The minister was speaking at the inauguration ceremony of two new multi-storey office complexes at Kasturba Gandhi Marg and Africa Avenue for over 7,000 employees of the Defence ministry and the armed forces.</p><p><b>Also Read | <a href=\"https://www.hindustantimes.com/india-news/agenda-of-spreading-lies-pm-modi-hits-out-at-critics-of-central-vista-revamp-101631817010156.html\">‘Agenda of spreading lies’: PM Modi hits out at critics of Central Vista revamp</a></b></p><p>Earlier in the day, Prime Minister Narendra Modi inaugurated these two buildings where he slammed the critics of the Central Vista project for spreading “misinformation” and “lies”. “Those people who were after the Central Vista project were very conveniently silent on this aspect that construction of a place for 7,000 employees of the Defence ministry and armed forces is part of the project because they knew that their idea of spreading misinformation and lies would be exposed when this comes to the fore,” he said.</p><p>“But the country is seeing today what we are doing under Central Vista. These modern offices constructed at KG Marg and Africa Avenue will help in getting the work related to defence done effectively,” he said.</p><p>The redevelopment project of the Central Vista envisages a new triangular Parliament building, a common central secretariat, revamping of the three-km-long Rajpath, from Rashtrapati Bhavan to India Gate, a new prime minister’s residence and PMO, and a new Vice President’s Enclave.</p>");
    }

    public static List<String> getParagraphList(String rawStoryText){
        List<String> paragraphList=new ArrayList<>();
        Document doc = Jsoup.parse(rawStoryText);
        List<Element> elementList=doc.getElementsByTag("p");
        if(elementList.size()==0){
            elementList=doc.getElementsByTag("div");
        }
        for(int i=0; i<elementList.size(); i++){
            Element element=elementList.get(i);
            Elements firstLevelElementsInsideParagraph=element.children();
            boolean isMainParagraph=element.parent().tagName().equalsIgnoreCase("body");
            if(firstLevelElementsInsideParagraph.isEmpty()){
                String paraText=element.text().trim();
                if(!paraText.isEmpty() && isMainParagraph){
                    paragraphList.add(paraText);
                }
            }
            else{
                String paragraphText=element.text().trim();
                if(!paragraphText.isEmpty() && isMainParagraph) {
                    paragraphList.add(paragraphText);
                }
            }
        }
        return paragraphList;
    }

    public static String getParagraphText(Elements elementList){
        List<String> paragraphList=new ArrayList<>();
        String allParagraphText="";

        for(int i=0; i<elementList.size(); i++){
            Element element=elementList.get(i);
            String paraText=element.text().trim();

            if(!paraText.isEmpty()){
                paragraphList.add(paraText);
            }
        }

        for(int i=0; i<paragraphList.size(); i++){
            if(i==0){
                allParagraphText=paragraphList.get(i);
            }
            else{
                allParagraphText=allParagraphText+"<p>"+paragraphList.get(i);
            }
        }
        return allParagraphText;
    }

    public static String getMassagedText(String rawText){
        String massagedData=rawText.replaceAll("“","\"").replaceAll("”","\"").replaceAll("’","'");
        massagedData=massagedData.replaceAll("–","-").replaceAll("‘","'").replaceAll(" "," ")
                .replaceAll("\u00AD","");
        //massagedData=massagedData.replaceAll("Rs ","₹");
        //massagedData=massagedData.replaceAll("Rs","₹");
        return massagedData.replaceAll(" +"," ").trim();
    }

    public static String getMassagedTextOld(String rawText){
        String massagedData=rawText;
        char c='"';
        try{
            if(!rawText.isEmpty()){
                if(rawText.charAt(0)=='"'){
                    massagedData=rawText.substring(1).trim();
                }
                if(rawText.charAt(rawText.length()-1)=='"'){
                    massagedData=massagedData.substring(0, rawText.length()-1);
                }
                massagedData=massagedData.replaceAll("'","");
                massagedData=massagedData.replaceAll("\"","");
                massagedData=massagedData.replaceAll("’","");
                massagedData=massagedData.replaceAll("‘","");
                massagedData=massagedData.replaceAll("“","");
                massagedData=massagedData.replaceAll("”","");
                massagedData=massagedData.replaceAll("₹","");
                massagedData=massagedData.replaceAll("-","");
                massagedData=massagedData.replaceAll("–","");
                if(massagedData.contains("Rs")){
                    massagedData=massagedData.replaceAll("Rs ","");
                    massagedData=massagedData.replaceAll("Rs.","");
                    massagedData=massagedData.replaceAll("Rs  ","");
                }
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return massagedData.trim();
    }

    public static String getMassagedCaptionText(String rawCaption){
        String massagedData=getMassagedText(rawCaption);
        massagedData=massagedData.replaceAll("( )","");
        massagedData=massagedData.replaceAll("()","");
        String imageCredit="";
        int posOpeningBracket=massagedData.lastIndexOf("(");
        int posClosingBracket=massagedData.lastIndexOf(")");
        if(posOpeningBracket>1 && posClosingBracket>1){
            try{
                imageCredit=massagedData.substring(posOpeningBracket+1, posClosingBracket).trim();
                massagedData=massagedData.substring(0,posOpeningBracket).trim();
                if(!imageCredit.isEmpty()){
                    massagedData=massagedData+"("+imageCredit+")";
                }
            }
            catch (StringIndexOutOfBoundsException ex){
                ex.printStackTrace();
            }
        }
        return massagedData;
    }

    public static String getMassagedCaptionOnlyText(String rawCaption){
        String massagedCaption=rawCaption.trim();
        massagedCaption=massagedCaption.replace("( )","").replace("()","");
        int posOpeningBracket=massagedCaption.lastIndexOf("(");
        try{
            if(getCharOccurrence(massagedCaption, '(')==1){
                if(posOpeningBracket==0){
                    massagedCaption="";
                }
                else{
                    massagedCaption = massagedCaption.substring(0, posOpeningBracket).trim();
                }
            }
            else if(posOpeningBracket>1){
                if(massagedCaption.charAt(posOpeningBracket-1)=='('){
                    massagedCaption = massagedCaption.substring(0, posOpeningBracket-1).trim();
                }
                else {
                    massagedCaption = massagedCaption.substring(0, posOpeningBracket).trim();
                }

            }
        }
        catch (StringIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }

        return massagedCaption;
    }

    public static int getCharOccurrence(String str, char c){
        int count=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==c)
                count++;
        }
        return count;
    }

    public static String getMassagedCaptionCreditText(String rawCaption){
        String captionWithCredit=rawCaption.trim();
        String imageCredit="";
        int posOpeningBracket=captionWithCredit.lastIndexOf("(");
        int posClosingBracket=captionWithCredit.lastIndexOf(")");
        if(posOpeningBracket>=0 && posClosingBracket>1){
            try{
                if(captionWithCredit.charAt(posOpeningBracket-1)=='(') {
                    imageCredit = captionWithCredit.substring(posOpeningBracket+1, posClosingBracket-1).trim();
                }
                else{
                    imageCredit = captionWithCredit.substring(posOpeningBracket + 1, posClosingBracket).trim();
                }
            }
            catch (StringIndexOutOfBoundsException ex){
                System.out.println("StringIndexOutOfBoundsException at getMassagedCaptionCreditText() method");
            }
        }
        return imageCredit;
    }


    public static Date getMassagedSourceDateTime(String sourceDateTime){
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy hh:mm");
        Date date=null;
        try {
            date = formatter.parse(sourceDateTime.replace("UPDATED ON","").replace("PUBLISHED ON",""));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getMassagedSourceDateTimeLiveBLog(String sourceDateTime){
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy HH:mm z");
        Date date=null;
        try {
            date = formatter.parse(sourceDateTime.replace("UPDATED ON","").replace("PUBLISHED ON","").trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getMassagedSourceDateTimeStandardStories(String sourceDateTime){
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy, HH:mm z");
        Date date=null;
        try {
            date = formatter.parse(sourceDateTime.replace("UPDATED ON","").replace("PUBLISHED ON","").trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getParsedDate(String destinationDateTime){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        Date date=null;
        try {
            date = formatter.parse(destinationDateTime.trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getMassagedDestinationDateTimeLiveBLog(String destinationDateTime){
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm aa", Locale.ENGLISH);
        Date date=null;
        try {
            destinationDateTime = destinationDateTime.replace("UPDATED ON ","").replace("PUBLISHED ON ","").trim();
            date = formatter.parse(destinationDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getMassagedDestinationDateTime(String destinationDateTime){
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm a z", Locale.ENGLISH);
        Date date=null;
        try {
            date = formatter.parse(destinationDateTime.replace("UPDATED ON","").replace("PUBLISHED ON","").trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getMassagedDestinationDateTimeGalleryNew(String destinationDateTime){
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy HH:mm z", Locale.ENGLISH);
        Date date=null;
        try {
            date = formatter.parse(destinationDateTime.replace("UPDATED ON","").replace("PUBLISHED ON","").trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getMassagedDestinationDateTimeVideoNew(String destinationDateTime){
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy HH:mm z", Locale.ENGLISH);
        Date date=null;
        try {
            date = formatter.parse(destinationDateTime.replace("UPDATED ON","").replace("PUBLISHED ON","").trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getDestinationDateTimeVideo(String destinationDateTime){
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMMMMMM, yyyy hh:mm aa");
        Date date=null;
        try {
            date = formatter.parse(destinationDateTime.replace("UPDATED ON","").replace("PUBLISHED ON","").trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getDestinationDateTimeStdStory(String destinationDateTime){
        SimpleDateFormat formatter = new SimpleDateFormat("MMMMMMMMM dd, yyyy hh:mm aa");
        Date date=null;
        try {
            date = formatter.parse(destinationDateTime.replace("PUBLISHED ON","").trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
