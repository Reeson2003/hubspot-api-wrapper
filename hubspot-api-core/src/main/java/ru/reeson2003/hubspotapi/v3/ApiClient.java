package ru.reeson2003.hubspotapi.v3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface ApiClient {

    ObjectMapper MAPPER = getObjectMapper();

    static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    default <T> T exchange(String url, String method, Object body, Class<T> responseType) {
        try {
            String rawBody = MAPPER.writeValueAsString(body);
            String response = exchange(url, method, rawBody);
            return MAPPER.readValue(response, responseType);
        } catch (Exception e) {
            throw new ApiCallException(e);
        }
    }

    String exchange(String url, String method, String body);
}
