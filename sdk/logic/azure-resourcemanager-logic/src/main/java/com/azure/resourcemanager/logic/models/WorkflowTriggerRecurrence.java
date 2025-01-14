// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logic.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The workflow trigger recurrence.
 */
@Fluent
public final class WorkflowTriggerRecurrence implements JsonSerializable<WorkflowTriggerRecurrence> {
    /*
     * The frequency.
     */
    private RecurrenceFrequency frequency;

    /*
     * The interval.
     */
    private Integer interval;

    /*
     * The start time.
     */
    private String startTime;

    /*
     * The end time.
     */
    private String endTime;

    /*
     * The time zone.
     */
    private String timeZone;

    /*
     * The recurrence schedule.
     */
    private RecurrenceSchedule schedule;

    /**
     * Creates an instance of WorkflowTriggerRecurrence class.
     */
    public WorkflowTriggerRecurrence() {
    }

    /**
     * Get the frequency property: The frequency.
     * 
     * @return the frequency value.
     */
    public RecurrenceFrequency frequency() {
        return this.frequency;
    }

    /**
     * Set the frequency property: The frequency.
     * 
     * @param frequency the frequency value to set.
     * @return the WorkflowTriggerRecurrence object itself.
     */
    public WorkflowTriggerRecurrence withFrequency(RecurrenceFrequency frequency) {
        this.frequency = frequency;
        return this;
    }

    /**
     * Get the interval property: The interval.
     * 
     * @return the interval value.
     */
    public Integer interval() {
        return this.interval;
    }

    /**
     * Set the interval property: The interval.
     * 
     * @param interval the interval value to set.
     * @return the WorkflowTriggerRecurrence object itself.
     */
    public WorkflowTriggerRecurrence withInterval(Integer interval) {
        this.interval = interval;
        return this;
    }

    /**
     * Get the startTime property: The start time.
     * 
     * @return the startTime value.
     */
    public String startTime() {
        return this.startTime;
    }

    /**
     * Set the startTime property: The start time.
     * 
     * @param startTime the startTime value to set.
     * @return the WorkflowTriggerRecurrence object itself.
     */
    public WorkflowTriggerRecurrence withStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get the endTime property: The end time.
     * 
     * @return the endTime value.
     */
    public String endTime() {
        return this.endTime;
    }

    /**
     * Set the endTime property: The end time.
     * 
     * @param endTime the endTime value to set.
     * @return the WorkflowTriggerRecurrence object itself.
     */
    public WorkflowTriggerRecurrence withEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * Get the timeZone property: The time zone.
     * 
     * @return the timeZone value.
     */
    public String timeZone() {
        return this.timeZone;
    }

    /**
     * Set the timeZone property: The time zone.
     * 
     * @param timeZone the timeZone value to set.
     * @return the WorkflowTriggerRecurrence object itself.
     */
    public WorkflowTriggerRecurrence withTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    /**
     * Get the schedule property: The recurrence schedule.
     * 
     * @return the schedule value.
     */
    public RecurrenceSchedule schedule() {
        return this.schedule;
    }

    /**
     * Set the schedule property: The recurrence schedule.
     * 
     * @param schedule the schedule value to set.
     * @return the WorkflowTriggerRecurrence object itself.
     */
    public WorkflowTriggerRecurrence withSchedule(RecurrenceSchedule schedule) {
        this.schedule = schedule;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (schedule() != null) {
            schedule().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("frequency", this.frequency == null ? null : this.frequency.toString());
        jsonWriter.writeNumberField("interval", this.interval);
        jsonWriter.writeStringField("startTime", this.startTime);
        jsonWriter.writeStringField("endTime", this.endTime);
        jsonWriter.writeStringField("timeZone", this.timeZone);
        jsonWriter.writeJsonField("schedule", this.schedule);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of WorkflowTriggerRecurrence from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of WorkflowTriggerRecurrence if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the WorkflowTriggerRecurrence.
     */
    public static WorkflowTriggerRecurrence fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            WorkflowTriggerRecurrence deserializedWorkflowTriggerRecurrence = new WorkflowTriggerRecurrence();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("frequency".equals(fieldName)) {
                    deserializedWorkflowTriggerRecurrence.frequency
                        = RecurrenceFrequency.fromString(reader.getString());
                } else if ("interval".equals(fieldName)) {
                    deserializedWorkflowTriggerRecurrence.interval = reader.getNullable(JsonReader::getInt);
                } else if ("startTime".equals(fieldName)) {
                    deserializedWorkflowTriggerRecurrence.startTime = reader.getString();
                } else if ("endTime".equals(fieldName)) {
                    deserializedWorkflowTriggerRecurrence.endTime = reader.getString();
                } else if ("timeZone".equals(fieldName)) {
                    deserializedWorkflowTriggerRecurrence.timeZone = reader.getString();
                } else if ("schedule".equals(fieldName)) {
                    deserializedWorkflowTriggerRecurrence.schedule = RecurrenceSchedule.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedWorkflowTriggerRecurrence;
        });
    }
}
