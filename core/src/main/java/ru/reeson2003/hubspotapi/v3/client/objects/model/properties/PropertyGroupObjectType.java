package ru.reeson2003.hubspotapi.v3.client.objects.model.properties;

import ru.reeson2003.hubspotapi.v3.client.ObjectType;
import ru.reeson2003.hubspotapi.v3.client.Results;

public class PropertyGroupObjectType
        implements ObjectType<PropertyGroup> {

    @Override
    public Class<PropertyGroup> getType() {
        return PropertyGroup.class;
    }

    @Override
    public Class<? extends Results<PropertyGroup>> getResultsType() {
        return PropertyGroupResults.class;
    }

    public static class PropertyGroupResults
            extends Results<PropertyGroup> {}

}
