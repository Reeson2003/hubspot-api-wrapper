package ru.reeson2003.hubspotapi.v3.client.workflows.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import ru.reeson2003.hubspotapi.v3.client.Results;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Workflows
        extends Results<Workflow> {

    private List<Workflow> workflows;

    @Override
    public List<Workflow> getResults() {
        return workflows;
    }

}
