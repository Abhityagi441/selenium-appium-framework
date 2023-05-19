package com.utils;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.*;

public class GoogleSheetUtils {

    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();//JacksonFactory.getDefaultInstance();
    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "credentials.json";
    private static GoogleSheetUtils googleSheetUtils;

    public static GoogleSheetUtils getInstance() {
        if (googleSheetUtils == null) {
            googleSheetUtils = new GoogleSheetUtils();
        }
        return googleSheetUtils;
    }

    /**
     * Creates an authorized Credential object.
     *
     * @return An authorized Credential object.
     * @throws IOException If the credentials_1.json file cannot be found.
     */
    private static HttpCredentialsAdapter getCredentials() throws IOException {
        InputStream in = GoogleSheetUtils.class.getClassLoader().getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null)
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        GoogleCredentials googleCredentials = GoogleCredentials.fromStream(in).createScoped(SCOPES);
        return new HttpCredentialsAdapter(googleCredentials);
    }

    /**
     * Prints the names and majors of students in a sample spreadsheet:
     */
    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "13_9YT5YEXU69WhOzL4ON7VWRn_todbBwCgs8jmFXovU";
        final String range = "LiveMint!A1:R";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials())
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            System.out.println("Name, Major");
            for (List<Object> row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
                System.out.printf("%s, %s\n", row.get(0), row.get(4));
            }
        }
    }

    public static boolean parseStringToBoolean(String value) {
        boolean boolResult;
        if (value.equalsIgnoreCase(Constants.YES) || value.equalsIgnoreCase("y")) {
            boolResult = true;
        } else if (value.equalsIgnoreCase(Constants.NO) || value.equalsIgnoreCase("n")) {
            boolResult = false;
        } else {
            System.out.println("********** Please specify correct value (i.e. yes, no, y or n) in TestConfig Sheet !!! *********");
            boolResult = false;
        }
        return boolResult;
    }

    public void setupDataSheet() throws IOException, GeneralSecurityException {
        GlobalVars globalVars = GlobalVars.getInstance();
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = globalVars.getSpreadsheetId();
        String testConfigSheetRange;
        String platform = globalVars.getPlatformName();
        if (platform.equalsIgnoreCase(Constants.DESKTOP_WEB) || platform.equalsIgnoreCase(Constants.ANDROID_WEB) || platform.equalsIgnoreCase(Constants.IOS_WEB) || platform.equalsIgnoreCase(Constants.IOS_AMP) || platform.equalsIgnoreCase(Constants.ANDROID_AMP)) {
            testConfigSheetRange = Constants.TEST_CONFIG_WEB + "!A1:N";
        } else {
            testConfigSheetRange = Constants.TEST_CONFIG_NATIVE + "!A1:N";

        }
        final String testDataSheetRange = globalVars.getEnvironment() + "!A1:Z";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials())
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange responseTestConfig = service.spreadsheets().values()
                .get(spreadsheetId, testConfigSheetRange)
                .execute();
        List<List<Object>> valuesTestConfig = responseTestConfig.getValues();

        ValueRange responseTestData = service.spreadsheets().values()
                .get(spreadsheetId, testDataSheetRange)
                .execute();
        List<List<Object>> valuesTestData = responseTestData.getValues();

        if (valuesTestConfig == null || valuesTestConfig.isEmpty()) {
            System.out.println("********* No Test Config data found !!! ********");
        } else {

            globalVars.setTestConfigMapping(getTestConfigData(valuesTestConfig));
        }

        if (valuesTestData == null || valuesTestData.isEmpty()) {
            System.out.println("********* No Test data found !!! ********");
        } else {
            globalVars.setTestDataElementsMap(getTestData(valuesTestData));
        }

    }

    /**
     * @param valuesTestConfig takes the Sheet object returned from the workbook
     */
    private Map<String, TestConfigElements> getTestConfigData(List<List<Object>> valuesTestConfig) {
        Map<String, TestConfigElements> dataElementsMap = new LinkedHashMap<>();
        String module = "";
        String testCaseId = "";
        String testCaseTitle = "";
        boolean isRunTrue = false;
        boolean isSanityTrue = false;
        boolean isProductionTrue = false;
        boolean isRegressionTrue = false;
        boolean isWebDesktopTrue = false;
        boolean isWebAndroidTrue = false;
        boolean isWebIOSTrue = false;
        boolean isAndroidAMPTrue = false;
        boolean isIOSAMPTrue = false;
        boolean isAndroidNativeTrue = false;
        boolean isIOSNativeTrue = false;


        for (int rowNum = 1; rowNum < valuesTestConfig.size(); rowNum++) {
            try {
                List<Object> row = valuesTestConfig.get(rowNum);
                if (row != null) {
                    testCaseId = String.valueOf(row.get(0));
                    module = String.valueOf(row.get(1));
                    testCaseTitle = String.valueOf(row.get(2));
                    isRunTrue = parseStringToBoolean(String.valueOf(row.get(3)));
                    isProductionTrue = parseStringToBoolean(String.valueOf(row.get(4)));
                    isSanityTrue = parseStringToBoolean(String.valueOf(row.get(5)));
                    isRegressionTrue = parseStringToBoolean(String.valueOf(row.get(6)));
                    isWebDesktopTrue = parseStringToBoolean(String.valueOf(row.get(7)));
                    isWebAndroidTrue = parseStringToBoolean(String.valueOf(row.get(8)));
                    isWebIOSTrue = parseStringToBoolean(String.valueOf(row.get(9)));
                    isAndroidAMPTrue = parseStringToBoolean(String.valueOf(row.get(10)));
                    isIOSAMPTrue = parseStringToBoolean(String.valueOf(row.get(11)));
                    isAndroidNativeTrue = parseStringToBoolean(String.valueOf(row.get(12)));
                    isIOSNativeTrue = parseStringToBoolean(String.valueOf(row.get(13)));
                } else {
                    break;
                }

            } catch (IndexOutOfBoundsException ie) {
                System.out.println("****** test configuration missing for: " + testCaseTitle);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dataElementsMap.put(testCaseTitle, new TestConfigElements(testCaseId, module, testCaseTitle, isRunTrue, isSanityTrue, isProductionTrue, isRegressionTrue, isWebDesktopTrue, isWebAndroidTrue, isWebIOSTrue, isAndroidAMPTrue, isIOSAMPTrue, isAndroidNativeTrue, isIOSNativeTrue));
        }
        return dataElementsMap;
    }

    private Map<String, Map<String, String>> getTestData(List<List<Object>> valuesTestData) {
        Map<String, Map<String, String>> dataElementsMap = new LinkedHashMap<>();
        String testCaseTitle = "";

        List<Object> propertyRow = valuesTestData.get(0);
        for (int rowNum = 1; rowNum < valuesTestData.size(); rowNum++) {
            Map<String, String> propertyWiseDataMap = new HashMap<>();
            List<Object> dataRow = valuesTestData.get(rowNum);
            try {
                if (dataRow != null) {
                    testCaseTitle = String.valueOf(dataRow.get(1));
                    int propertyCount = propertyRow.size();
                    for (int j = 2; j < propertyCount; j++) {
                        String property = String.valueOf(propertyRow.get(j));
                        propertyWiseDataMap.put(property, String.valueOf(dataRow.get(j)));
                    }
                } else {
                    System.out.println("****** No test data found !!! *********");
                    break;
                }

            } catch (IndexOutOfBoundsException ie) {
                System.out.println("****** test data does not exist for: " + testCaseTitle);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dataElementsMap.put(testCaseTitle, propertyWiseDataMap);
        }
        return dataElementsMap;
    }
}
