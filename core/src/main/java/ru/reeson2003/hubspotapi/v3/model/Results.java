package ru.reeson2003.hubspotapi.v3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results<T> {

    private List<T> results;

    private Paging paging;

    public Optional<Paging> getPaging() {
        return Optional.ofNullable(paging);
    }

}
