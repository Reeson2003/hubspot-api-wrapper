package ru.reeson2003.hubspotapi.v3.client.workflows.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Workflow {

    private String id;

    private String name;

    private String type;

    private String description;

    private Boolean allowContactToTriggerMultipleTimes;

    private Boolean onlyExecOnBizDays;

    private Boolean listening;

    private Boolean isSegmentBased;

    private Boolean enrollOnCriteriaUpdate;

    private Boolean allowEnrollmentFromMerge;

    private Boolean enabled;

    private Boolean onlyEnrollsManually;

    private List<List<ReEnrollmentTriggerSet>> reEnrollmentTriggerSets;

    private List<List<SegmentCriterium>> segmentCriteria;

    private List<List<SegmentCriterium>> goalCriteria;

    private List<Action> actions;

}