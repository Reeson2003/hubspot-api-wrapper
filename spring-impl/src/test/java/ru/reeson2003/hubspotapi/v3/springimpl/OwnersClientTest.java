package ru.reeson2003.hubspotapi.v3.springimpl;

import org.junit.jupiter.api.BeforeAll;
import ru.reeson2003.hubspotapi.v3.client.owners.OwnersClient;
import ru.reeson2003.hubspotapi.v3.model.owners.Owner;

class OwnersClientTest {

    private static OwnersClient client;

    @BeforeAll
    public static void setup() {
        client = new OwnersClient(new HapiKeyApiClient(""));
    }

    // @Test
    public void readAllTest() {
        client.stream()
              .map(Owner::getEmail)
              .forEach(System.out::println);
    }

}