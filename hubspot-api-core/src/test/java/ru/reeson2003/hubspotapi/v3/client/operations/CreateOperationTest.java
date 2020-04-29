package ru.reeson2003.hubspotapi.v3.client.operations;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

class CreateOperationTest
        extends BaseOperationsTest
        implements CreateOperation<String> {

    public static final String OBJECT = "test";

    @Test
    void createTestOk() {
        create(OBJECT);
        Mockito.verify(getApiClient()).exchange(getBaseUrl(), "POST", OBJECT, getObjectType().getType());
    }

    @Test
    void createTestError() {
        doThrow(new RuntimeException()).when(getApiClient()).exchange(getBaseUrl(), "POST", OBJECT, getObjectType().getType());
        assertThrows(RuntimeException.class, () -> create(OBJECT));
    }

}