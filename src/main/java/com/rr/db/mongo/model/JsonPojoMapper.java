package com.rr.db.mongo.model;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Limaoran on 2016/9/27.
 */
public class JsonPojoMapper {
    private static ObjectMapper mapper = new ObjectMapper();
    private static JsonFactory jsonFactory = new JsonFactory();

    public static <T> Object fromJson(String jsonAsString,Class<T> pojoClass) throws JsonMappingException,JsonParseException,IOException{
        return mapper.readValue(jsonAsString,pojoClass);
    }
    public static <T> Object fromJson(FileReader reader,Class<T>pojoClass) throws IOException {
        return mapper.readValue(reader,pojoClass);
    }
    public static String toJson(Object pojo,boolean prettyPrint) throws IOException {
        StringWriter writer = new StringWriter();
        JsonGenerator generator = jsonFactory.createGenerator(writer);
        if(prettyPrint){
            generator.useDefaultPrettyPrinter();
        }
        mapper.writeValue(generator,pojo);
        return writer.toString();
    }
    public static void toJson(Object pojo, FileWriter fileWriter,boolean prettyPrint) throws IOException {
        JsonGenerator generator = jsonFactory.createGenerator(fileWriter);
        if(prettyPrint){
            generator.useDefaultPrettyPrinter();
        }
        mapper.writeValue(generator,pojo);
    }
}
