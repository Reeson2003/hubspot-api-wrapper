package ru.reeson2003.hubspotapi.v3.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.reeson2003.hubspotapi.v3.client.owners.OwnersClient;
import ru.reeson2003.hubspotapi.v3.model.owners.Owner;
import ru.reeson2003.hubspotapi.v3.springimpl.HapiKeyApiClient;

class OwnersClientTest {

    private static OwnersClient client;

    @BeforeAll
    public static void setup() {
        client = new OwnersClient(new HapiKeyApiClient("16d25c18-ee21-4c3a-bbcd-0a88536aa04c"));
    }

    @Test
    public void readAll() {
        client.readAll().stream()
              .map(Owner::getEmail)
              .forEach(System.out::println);
    }

    @Test
    public void readByEmail() {
        client.readByEmail("pavel.gavrilov@binomo.com").stream()
              .map(Owner::getEmail)
              .forEach(System.out::println);
    }

}