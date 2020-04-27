package ru.reeson2003.hubspotapi.v3.client.owners.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Owner {

    private String firstName;

    private String lastName;

    private String createdAt;

    private Boolean archived;

    @Singular
    private List<Team> teams;

    private String id;

    private Integer userId;

    private String email;

    private String updatedAt;

}