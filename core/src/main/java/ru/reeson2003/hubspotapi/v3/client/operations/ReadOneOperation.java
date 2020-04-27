package ru.reeson2003.hubspotapi.v3.client.operations;

import ru.reeson2003.hubspotapi.v3.client.ObjectType;

public interface ReadOneOperation<T>
        extends Operation<T> {

    default T readOne(String id) {
        String method = "GET";
        String url = getBaseUrl() + "/" + id;
        ObjectType<T> objectType = getObjectType();
        return getApiClient().exchange(url, method, null, objectType.getType());
    }

}
