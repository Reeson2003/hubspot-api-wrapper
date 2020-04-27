package ru.reeson2003.hubspotapi.v3.client.workflows.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Action {

    private String type;

    private Integer delayMillis;

    private Integer appId;

    private String newValue;

    private String propertyName;

    private String url;

    private String method;

    private AuthCreds authCreds;

}