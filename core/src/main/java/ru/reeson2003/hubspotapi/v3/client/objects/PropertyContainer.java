package ru.reeson2003.hubspotapi.v3.client.objects;

import ru.reeson2003.hubspotapi.v3.client.objects.model.properties.Property;
import ru.reeson2003.hubspotapi.v3.client.objects.model.properties.PropertyGroup;
import ru.reeson2003.hubspotapi.v3.client.operations.CrudOperations;

public interface PropertyContainer {

    CrudOperations<Property> getPropertyClient();

    CrudOperations<PropertyGroup> getPropertyGroupClient();

}
