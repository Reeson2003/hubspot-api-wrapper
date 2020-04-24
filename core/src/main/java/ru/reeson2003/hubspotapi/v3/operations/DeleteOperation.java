package ru.reeson2003.hubspotapi.v3.operations;

public interface DeleteOperation<T>
        extends Operation<T> {

    default void delete(String id) {
        String method = "DELETE";
        String url = getBaseUrl() + "/" + id;
        getApiClient().exchange(url, method, null, Object.class);
    }

}
