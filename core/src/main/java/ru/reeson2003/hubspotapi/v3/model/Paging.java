package ru.reeson2003.hubspotapi.v3.model;

import lombok.Data;

@Data
public class Paging {

    private Next next;

    @Data
    public static class Next {

        String after;

        String link;

    }

}
