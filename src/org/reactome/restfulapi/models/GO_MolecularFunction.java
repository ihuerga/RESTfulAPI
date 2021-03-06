package org.reactome.restfulapi.models;

// Generated Jul 8, 2011 1:48:55 PM by Hibernate Tools 3.4.0.CR1

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Go_MolecularFunction generated by hbm2java
 */
@XmlRootElement
public class GO_MolecularFunction extends DatabaseObject {

    private String accession;
    private String definition;
    private ReferenceDatabase referenceDatabase;
    private GO_MolecularFunction componentOf;
    private String ecNumber;
    private String name;
    private GO_MolecularFunction negativelyRegulate;
    private GO_MolecularFunction positivelyRegulate;
    private GO_MolecularFunction regulate;

    public GO_MolecularFunction getComponentOf() {
        return componentOf;
    }

    public void setComponentOf(GO_MolecularFunction componentOf) {
        this.componentOf = componentOf;
    }

    public String getEcNumber() {
        return ecNumber;
    }

    public void setEcNumber(String ecNumber) {
        this.ecNumber = ecNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GO_MolecularFunction getNegativelyRegulate() {
        return negativelyRegulate;
    }

    public void setNegativelyRegulate(GO_MolecularFunction negativelyRegulate) {
        this.negativelyRegulate = negativelyRegulate;
    }

    public GO_MolecularFunction getPositivelyRegulate() {
        return positivelyRegulate;
    }

    public void setPositivelyRegulate(GO_MolecularFunction positivelyRegulate) {
        this.positivelyRegulate = positivelyRegulate;
    }

    public GO_MolecularFunction getRegulate() {
        return regulate;
    }

    public void setRegulate(GO_MolecularFunction regulate) {
        this.regulate = regulate;
    }

    public GO_MolecularFunction() {
    }

    public String getAccession() {
        return this.accession;
    }

    public void setAccession(String accession) {
        this.accession = accession;
    }

    public String getDefinition() {
        return this.definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public ReferenceDatabase getReferenceDatabase() {
        return this.referenceDatabase;
    }

    public void setReferenceDatabase(ReferenceDatabase referenceDatabase) {
        this.referenceDatabase = referenceDatabase;
    }

}
