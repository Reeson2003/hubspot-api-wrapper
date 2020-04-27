package ru.reeson2003.hubspotapi.v3.client.objects.model.properties;

import ru.reeson2003.hubspotapi.v3.client.ObjectType;
import ru.reeson2003.hubspotapi.v3.client.Results;

public class PropertyObjectType
        implements ObjectType<Property> {

    @Override
    public Class<Property> getType() {
        return Property.class;
    }

    @Override
    public Class<? extends Results<Property>> getResultsType() {
        return PropertyResults.class;
    }

    public static class PropertyResults
            extends Results<Property> {}

}
