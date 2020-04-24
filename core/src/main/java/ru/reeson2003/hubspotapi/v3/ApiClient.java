package ru.reeson2003.hubspotapi.v3;

public interface ApiClient {

    <T> T exchange(String url, String method, Object body, Class<T> responseType);
}
