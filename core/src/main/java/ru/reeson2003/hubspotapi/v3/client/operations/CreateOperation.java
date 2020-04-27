package ru.reeson2003.hubspotapi.v3.client.operations;

import ru.reeson2003.hubspotapi.v3.client.ObjectType;

public interface CreateOperation<T>
        extends Operation<T> {

    default T create(T object) {
        String method = "POST";
        String url = getBaseUrl();
        ObjectType<T> objectType = getObjectType();
        return getApiClient().exchange(url, method, object, objectType.getType());
    }

}
