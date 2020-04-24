package ru.reeson2003.hubspotapi.v3.operations;

import ru.reeson2003.hubspotapi.v3.model.types.HubSpotObjectType;

public interface CreateOperation<T>
        extends Operation<T> {

    default T create(T object) {
        String method = "POST";
        String url = getBaseUrl();
        HubSpotObjectType<T> objectType = getObjectType();
        return getApiClient().exchange(url, method, object, objectType.getType());
    }

}
