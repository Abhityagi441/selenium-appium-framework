package com.utils.dbUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.utils.Constants;
import com.utils.Utils;
import org.bson.Document;

public class DbConnection {

    String textUri;
    String database;
    String collection;

    public String getTextUri() {
        return textUri;
    }

    public void setTextUri(String textUri) {
        this.textUri = textUri;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public boolean setConnectionStrings(String storyStatus, String env,String property) {
        boolean flag = true;
        switch (property) {
            case Constants.HT_NEW:
                if (storyStatus.equals("PUBLISHED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_HT_QA);
                        setDatabase(Constants.QA_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.STAGING_MONGO_DB_COLLECTION_HT);
                    }
                } else if (storyStatus.equals("CREATED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_QA_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.BACKEND_STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_STAGING_MONGO_DB_COLLECTION_HT);
                    }
                }
                break;
            case Constants.SMART_24:
                if (storyStatus.equals("PUBLISHED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_SMART24_QA);
                        setDatabase(Constants.QA_MONGO_DB_DATABASE_SMART24);
                        setCollection(Constants.QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.STAGING_MONGO_DB_COLLECTION_HT);
                    }
                } else if (storyStatus.equals("CREATED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_QA_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.BACKEND_STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_STAGING_MONGO_DB_COLLECTION_HT);
                    }
                }
                break;
            case Constants.BANGLA:
                if (storyStatus.equals("PUBLISHED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_BANGLA_QA);
                        setDatabase(Constants.QA_MONGO_DB_DATABASE_BANGLA);
                        setCollection(Constants.QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.STAGING_MONGO_DB_COLLECTION_HT);
                    }
                } else if (storyStatus.equals("CREATED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_QA_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.BACKEND_STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_STAGING_MONGO_DB_COLLECTION_HT);
                    }
                }
                break;
            case Constants.LIVEMINT:
                if (storyStatus.equals("PUBLISHED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_LM_QA);
                        setDatabase(Constants.QA_MONGO_DB_DATABASE_LM);
                        setCollection(Constants.QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.STAGING_MONGO_DB_COLLECTION_HT);
                    }
                } else if (storyStatus.equals("CREATED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_QA_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.BACKEND_STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_STAGING_MONGO_DB_COLLECTION_HT);
                    }
                }
                break;

            case Constants.AUTO:
                if (storyStatus.equals("PUBLISHED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_AUTO_QA);
                        setDatabase(Constants.QA_MONGO_DB_DATABASE_AUTO);
                        setCollection(Constants.QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.STAGING_MONGO_DB_COLLECTION_HT);
                    }
                } else if (storyStatus.equals("CREATED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_QA_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.BACKEND_STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_STAGING_MONGO_DB_COLLECTION_HT);
                    }
                }
                break;
            case Constants.TECH:
                if (storyStatus.equals("PUBLISHED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_TECH_QA);
                        setDatabase(Constants.QA_MONGO_DB_DATABASE_TECH);
                        setCollection(Constants.QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.STAGING_MONGO_DB_COLLECTION_HT);
                    }
                } else if (storyStatus.equals("CREATED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_QA_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.BACKEND_STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_STAGING_MONGO_DB_COLLECTION_HT);
                    }
                }
                break;
            case Constants.MINT_LOUNGE:
                if (storyStatus.equals("PUBLISHED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_ML_QA);
                        setDatabase(Constants.QA_MONGO_DB_DATABASE_MINT_LOUNGE);
                        setCollection(Constants.QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.STAGING_MONGO_DB_COLLECTION_HT);
                    }
                } else if (storyStatus.equals("CREATED")) {
                    if (env.equals("qa")) {
                        setTextUri(Constants.QA_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_QA_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_QA_MONGO_DB_COLLECTION_HT);
                    } else if (env.equals("stg")) {
                        setTextUri(Constants.BACKEND_STAGING_MONGO_DB_URI_HT);
                        setDatabase(Constants.BACKEND_STAGING_MONGO_DB_DATABASE_HT);
                        setCollection(Constants.BACKEND_STAGING_MONGO_DB_COLLECTION_HT);
                    }
                }
                break;
            default :
                flag = false;
                Utils.logStepInfo("Property is not configured yet");
            }

            return flag;
    }

    public FindIterable<Document> makeMongoDBConnection(BasicDBObject query, String textUri, String database, String collection) {
        MongoClientURI uri = new MongoClientURI(textUri);
        MongoClient m = new MongoClient(uri);
        MongoDatabase databaseConstant = m.getDatabase(database);

        FindIterable<Document> cur = databaseConstant.getCollection(collection).find(query);
        return cur;
    }

}