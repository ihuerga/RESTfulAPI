package org.reactome.restfulapi.models;

// Generated Jul 8, 2011 1:48:55 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * InstanceEdit generated by hbm2java
 */
@XmlRootElement
public class InstanceEdit extends DatabaseObject {

    private String applyToAllEditedInstances;
    private String dateTime;
    private String note;
    private List<Person> author;

    public InstanceEdit() {
    }

    public String getApplyToAllEditedInstances() {
        return this.applyToAllEditedInstances;
    }

    public void setApplyToAllEditedInstances(String applyToAllEditedInstances) {
        this.applyToAllEditedInstances = applyToAllEditedInstances;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Person> getAuthor() {
        return author;
    }

    public void setAuthor(List<Person> author) {
        this.author = author;
    }

}
