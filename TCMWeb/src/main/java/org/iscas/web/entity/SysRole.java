package org.iscas.web.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wch on 2018-9-13.
 */
@Entity
public class SysRole extends IdEntity{
/*    @Id
    @GeneratedValue
    private Long id;*/
    private String name;

/*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
