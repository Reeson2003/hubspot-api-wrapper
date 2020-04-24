package ru.reeson2003.hubspotapi.v3.client;

import ru.reeson2003.hubspotapi.v3.model.properties.Property;
import ru.reeson2003.hubspotapi.v3.model.properties.PropertyGroup;
import ru.reeson2003.hubspotapi.v3.operations.CrudOperations;

public interface PropertyContainer {

    CrudOperations<Property> getPropertyClient();

    CrudOperations<PropertyGroup> getPropertyGroupClient();

}
