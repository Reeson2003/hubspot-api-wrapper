package ru.reeson2003.hubspotapi.v3.client.operations;

import lombok.Value;
import ru.reeson2003.hubspotapi.v3.client.ObjectType;
import ru.reeson2003.hubspotapi.v3.client.Results;

@Value
public class StringObjectType
        implements ObjectType<String> {

    Class<String> type = String.class;

    Class<? extends Results<String>> resultsType = StringResults.class;

    public static class StringResults
            extends Results<String> {}

}
