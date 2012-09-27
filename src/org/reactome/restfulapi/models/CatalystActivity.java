package org.reactome.restfulapi.models;

// Generated Jul 8, 2011 1:48:55 PM by Hibernate Tools 3.4.0.CR1

import javax.xml.bind.annotation.XmlRootElement;

/**
 * CatalystActivity generated by hbm2java
 */
@XmlRootElement
public class CatalystActivity extends DatabaseObject implements Regulator {

    private GO_MolecularFunction activity;
    private PhysicalEntity physicalEntity;
    private String physicalEntityClass;

    public CatalystActivity() {
    }

    public GO_MolecularFunction getActivity() {
        return this.activity;
    }

    public void setActivity(GO_MolecularFunction activity) {
        this.activity = activity;
    }

    public PhysicalEntity getPhysicalEntity() {
        return this.physicalEntity;
    }

    public void setPhysicalEntity(PhysicalEntity physicalEntity) {
        this.physicalEntity = physicalEntity;
    }

    public String getPhysicalEntityClass() {
        return this.physicalEntityClass;
    }

    public void setPhysicalEntityClass(String physicalEntityClass) {
        this.physicalEntityClass = physicalEntityClass;
    }

}