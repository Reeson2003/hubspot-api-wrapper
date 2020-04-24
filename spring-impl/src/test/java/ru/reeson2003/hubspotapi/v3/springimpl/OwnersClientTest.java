package ru.reeson2003.hubspotapi.v3.springimpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.reeson2003.hubspotapi.v3.client.owners.OwnersClient;
import ru.reeson2003.hubspotapi.v3.model.owners.Owner;

import static org.junit.jupiter.api.Assertions.*;

class OwnersClientTest {

    private static OwnersClient client;

    @BeforeAll
    public static void setup() {
        client = new OwnersClient(new HapiKeyApiClient("4c85e852-d352-40d1-88d2-27c93960857a"));
    }

    @Test
    public void readAllTest() {
        client.stream()
              .map(Owner::getEmail)
              .forEach(System.out::println);
    }
}