package ru.reeson2003.hubspotapi.v3.client.objects.model.objects;

import ru.reeson2003.hubspotapi.v3.client.Results;
import ru.reeson2003.hubspotapi.v3.client.objects.HubSpotObjectType;

public class ContactObjectType
        implements HubSpotObjectType<Contact> {

    @Override
    public String getApiName() {
        return "contacts";
    }

    @Override
    public Class<Contact> getType() {
        return Contact.class;
    }

    @Override
    public Class<? extends Results<Contact>> getResultsType() {
        return ContactResults.class;
    }

    public static class ContactResults
            extends Results<Contact> {}

}
