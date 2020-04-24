package ru.reeson2003.hubspotapi.v3.operations;

import ru.reeson2003.hubspotapi.v3.model.types.HubSpotObjectType;

public interface UpdateOperation<T>
        extends Operation<T> {

    default T update(String id, T object) {
        String method = "PATCH";
        String url = getBaseUrl() + "/" + id;
        HubSpotObjectType<T> objectType = getObjectType();
        return getApiClient().exchange(url, method, object, objectType.getType());
    }

}
