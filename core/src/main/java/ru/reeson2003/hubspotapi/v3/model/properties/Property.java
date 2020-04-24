package ru.reeson2003.hubspotapi.v3.model.properties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Property {

    public String groupName;

    public Boolean hidden;

    public ModificationMetadata modificationMetadata;

    public String name;

    public Integer displayOrder;

    @Singular
    public List<Option> options;

    public String label;

    public Boolean hasUniqueValue;

    public String type;

    public String fieldType;

}