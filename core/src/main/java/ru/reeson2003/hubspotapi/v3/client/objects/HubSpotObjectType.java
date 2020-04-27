package ru.reeson2003.hubspotapi.v3.client.objects;

import ru.reeson2003.hubspotapi.v3.client.ObjectType;

public interface HubSpotObjectType<T>
        extends ObjectType<T> {

    String getApiName();

}
