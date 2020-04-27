package ru.reeson2003.hubspotapi.v3.client.operations;

import ru.reeson2003.hubspotapi.v3.client.ObjectType;

public interface UpdateOperation<T>
        extends Operation<T> {

    default T update(String id, T object) {
        String method = "PATCH";
        String url = getBaseUrl() + "/" + id;
        ObjectType<T> objectType = getObjectType();
        return getApiClient().exchange(url, method, object, objectType.getType());
    }

}
