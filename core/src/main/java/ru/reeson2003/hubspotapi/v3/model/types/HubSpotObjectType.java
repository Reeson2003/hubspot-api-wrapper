package ru.reeson2003.hubspotapi.v3.model.types;

import lombok.Value;
import ru.reeson2003.hubspotapi.v3.model.Results;
import ru.reeson2003.hubspotapi.v3.model.objects.Contact;
import ru.reeson2003.hubspotapi.v3.model.objects.Product;
import ru.reeson2003.hubspotapi.v3.model.owners.Owner;
import ru.reeson2003.hubspotapi.v3.model.properties.Property;
import ru.reeson2003.hubspotapi.v3.model.properties.PropertyGroup;

import java.util.HashMap;
import java.util.Map;

@Value
public class HubSpotObjectType<T> {

    private static Map<Class<?>, HubSpotObjectType<?>> OBJECT_TYPES =
            new HashMap<>();

    static {
        OBJECT_TYPES.put(PropertyGroup.class, new HubSpotObjectType<>("groups", PropertyGroup.class, PropertyGroups.class));
        OBJECT_TYPES.put(Property.class, new HubSpotObjectType<>("properties", Property.class, Properties.class));
        OBJECT_TYPES.put(Contact.class, new HubSpotObjectType<>("contacts", Contact.class, Contacts.class));
        OBJECT_TYPES.put(Product.class, new HubSpotObjectType<>("products", Product.class, Products.class));
        OBJECT_TYPES.put(Owner.class, new HubSpotObjectType<>("owners", Owner.class, Owners.class));
    }

    @SuppressWarnings("unchecked")
    public static <T> HubSpotObjectType<T> of(Class<T> tClass) {
        return (HubSpotObjectType<T>) OBJECT_TYPES.get(tClass);
    }

    String apiName;

    Class<T> type;

    Class<? extends Results<T>> resultsType;

    public static class PropertyGroups
            extends Results<PropertyGroup> {}

    public static class Properties
            extends Results<Property> {}

    public static class Contacts
            extends Results<Contact> {}

    public static class Products
            extends Results<Product> {}

    public static class Owners
            extends Results<Owner> {}

}
