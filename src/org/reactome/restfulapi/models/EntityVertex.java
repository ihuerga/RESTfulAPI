package org.reactome.restfulapi.models;

// Generated Jul 8, 2011 1:48:55 PM by Hibernate Tools 3.4.0.CR1

import javax.xml.bind.annotation.XmlRootElement;

/**
 * EntityVertex generated by hbm2java
 */
@XmlRootElement
public class EntityVertex extends Vertex {

    private Integer containedInEntityVertex;
    private String containedInEntityVertexClass;

    public EntityVertex() {
    }

    public Integer getContainedInEntityVertex() {
        return this.containedInEntityVertex;
    }

    public void setContainedInEntityVertex(Integer containedInEntityVertex) {
        this.containedInEntityVertex = containedInEntityVertex;
    }

    public String getContainedInEntityVertexClass() {
        return this.containedInEntityVertexClass;
    }

    public void setContainedInEntityVertexClass(
            String containedInEntityVertexClass) {
        this.containedInEntityVertexClass = containedInEntityVertexClass;
    }

}
