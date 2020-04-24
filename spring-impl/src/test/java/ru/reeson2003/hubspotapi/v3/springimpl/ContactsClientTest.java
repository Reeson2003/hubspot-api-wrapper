package ru.reeson2003.hubspotapi.v3.springimpl;

import org.junit.jupiter.api.BeforeAll;
import ru.reeson2003.hubspotapi.v3.client.objects.ObjectsClient;
import ru.reeson2003.hubspotapi.v3.model.objects.Contact;
import ru.reeson2003.hubspotapi.v3.model.types.HubSpotObjectType;

class ContactsClientTest {

    private static ObjectsClient<Contact> client;

    @BeforeAll
    public static void setup() {
        client = new ObjectsClient<>(new HapiKeyApiClient(""), HubSpotObjectType.of(Contact.class));
    }

    // @Test
    public void readAllTest() {
        client.stream()
              .map(Contact::getId)
              .forEach(System.out::println);
    }

}