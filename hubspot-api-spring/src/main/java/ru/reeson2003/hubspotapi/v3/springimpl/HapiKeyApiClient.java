package ru.reeson2003.hubspotapi.v3.springimpl;

public class HapiKeyApiClient
        extends RestOperationsApiClient {

    public HapiKeyApiClient(String hapiKey) {
        super(new HapiKeyRestTemplate(hapiKey));
    }

}
