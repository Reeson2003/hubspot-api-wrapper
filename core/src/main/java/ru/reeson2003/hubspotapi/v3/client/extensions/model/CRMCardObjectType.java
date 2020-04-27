package ru.reeson2003.hubspotapi.v3.client.extensions.model;

import ru.reeson2003.hubspotapi.v3.client.ObjectType;
import ru.reeson2003.hubspotapi.v3.client.Results;

public class CRMCardObjectType
        implements ObjectType<CRMCard> {

    @Override
    public Class<CRMCard> getType() {
        return CRMCard.class;
    }

    @Override
    public Class<? extends Results<CRMCard>> getResultsType() {
        return CRMCardResults.class;
    }

    public static class CRMCardResults
            extends Results<CRMCard> {}

}
