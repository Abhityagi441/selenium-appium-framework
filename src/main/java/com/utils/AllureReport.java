package com.utils;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

public class AllureReport {

    private static Configuration LENIENT_JSON_PATH_CONFIG = Configuration.builder()
            .jsonProvider(new JacksonJsonNodeJsonProvider())
            .mappingProvider(new JacksonMappingProvider())
            .options(Option.SUPPRESS_EXCEPTIONS)
            .build();

    public static void removeUnknownTestCases() {
        InputStream in = ClassLoader.getSystemResourceAsStream("allure.properties");
        if(in == null) {
            String propFilePath = System.getProperty("user.dir") + "/" + "target/test-classes/allure.properties";
            try {
                in = new FileInputStream(propFilePath);
            } catch (FileNotFoundException e) {
                throw new RuntimeException("No such file found :: " + propFilePath, e);
            }
        }
        Properties props = new Properties();
        try {
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Unable to Load property file [allure.properties]", e);
        }
        String allureJsonDirPath = System.getProperty("user.dir") + "/" + props.getProperty("allure.results.directory");
        File allureJsonDir = new File(allureJsonDirPath);
        if(allureJsonDir.isDirectory()) {
            Iterator<File> fileIterator = FileUtils.iterateFiles(allureJsonDir, new String[]{"json"}, false);
            while(fileIterator.hasNext()) {
                File file = fileIterator.next();
                if(file.isFile()) {
                    try {
                        DocumentContext jsonDoc = JsonPath.using(LENIENT_JSON_PATH_CONFIG).parse(file);
                        if(jsonDoc.read("status") == null)
                            if(!file.delete())
                                System.out.println("Unable to delete allure json file :: " + file.getAbsolutePath());
                    } catch (IOException e) {
                        throw new RuntimeException("Unable to read file :: " + file.getAbsolutePath(), e);
                    }
                } else {
                    System.out.println("Not a valid file :: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No such directory found :: " + allureJsonDirPath);
        }
    }
}
