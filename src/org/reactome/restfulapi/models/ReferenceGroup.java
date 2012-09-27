package org.reactome.restfulapi.models;

import javax.xml.bind.annotation.XmlRootElement;

// Generated Jul 8, 2011 1:48:55 PM by Hibernate Tools 3.4.0.CR1

/**
 * ReferenceGroup generated by hbm2java
 */
@XmlRootElement
public class ReferenceGroup extends ReferenceEntity {

    private String atomicConnectivity;
    private String formula;

    public ReferenceGroup() {
    }

    public String getAtomicConnectivity() {
        return atomicConnectivity;
    }

    public void setAtomicConnectivity(String atomicConnectivity) {
        this.atomicConnectivity = atomicConnectivity;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

}