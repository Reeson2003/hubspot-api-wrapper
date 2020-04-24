package ru.reeson2003.hubspotapi.v3.model.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HubSpotObject {

    public String id;

    public String createdAt;

    public String updatedAt;

    public Boolean archived;

    @JsonProperty("properties")
    @Singular
    public Map<String, String> properties;

}
