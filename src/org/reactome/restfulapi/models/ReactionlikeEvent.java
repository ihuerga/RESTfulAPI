package org.reactome.restfulapi.models;

// Generated Jul 8, 2011 1:48:55 PM by Hibernate Tools 3.4.0.CR1

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * ReactionlikeEvent generated by hbm2java
 */
@XmlRootElement
public class ReactionlikeEvent extends Event {

    private Boolean isChimeric;
    private List<PhysicalEntity> input;
    private List<PhysicalEntity> output;
    private List<PhysicalEntity> entityOnOtherCell;
    private List<PhysicalEntity> requiredInputComponent;
    private ReactionlikeEvent hasMember;
    private List<CatalystActivity> catalystActivity;

    public List<PhysicalEntity> getInput() {
        return input;
    }

    public void setInput(List<PhysicalEntity> input) {
        this.input = input;
    }

    public List<PhysicalEntity> getOutput() {
        return output;
    }

    public void setOutput(List<PhysicalEntity> output) {
        this.output = output;
    }


    public List<PhysicalEntity> getEntityOnOtherCell() {
        return entityOnOtherCell;
    }

    public void setEntityOnOtherCell(List<PhysicalEntity> entityOnOtherCell) {
        this.entityOnOtherCell = entityOnOtherCell;
    }

    public List<PhysicalEntity> getRequiredInputComponent() {
        return requiredInputComponent;
    }

    public void setRequiredInputComponent(List<PhysicalEntity> requiredInputComponent) {
        this.requiredInputComponent = requiredInputComponent;
    }

    public ReactionlikeEvent getHasMember() {
        return hasMember;
    }

    public void setHasMember(ReactionlikeEvent hasMember) {
        this.hasMember = hasMember;
    }

    public List<CatalystActivity> getCatalystActivity() {
        return catalystActivity;
    }

    public void setCatalystActivity(List<CatalystActivity> catalystActivity) {
        this.catalystActivity = catalystActivity;
    }

    public ReactionlikeEvent() {
    }

    public Boolean getIsChimeric() {
        return this.isChimeric;
    }

    public void setIsChimeric(Boolean isChimeric) {
        this.isChimeric = isChimeric;
    }

}