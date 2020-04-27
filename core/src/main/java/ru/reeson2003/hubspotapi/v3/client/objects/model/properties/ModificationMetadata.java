package ru.reeson2003.hubspotapi.v3.client.objects.model.properties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModificationMetadata {

    public Boolean readOnlyOptions;

    public Boolean readOnlyValue;

    public Boolean readOnlyDefinition;

    public Boolean archivable;

}