package br.com.fullstack.postit.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonUtility {

    private JsonUtility() {}

    public static String toJson(Object object) {
        try {
            ObjectMapper om = new ObjectMapper();
            om.findAndRegisterModules();

            ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
            return ow.writeValueAsString(object);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }
}
