package org.iscas.web.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 所有实体的父类,自动携带更改时间戳
 */
@MappedSuperclass
public class BaseEntity {

  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  protected Date createAt;

  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  protected Date updateAt;

  @Temporal(TemporalType.TIMESTAMP)
  protected Date deleteAt;

  @PrePersist
  public void onCreate() {
    createAt = updateAt = new Date();
  }
  
  @PreUpdate
  public void onUpdate() {
    updateAt = new Date();
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public Date getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(Date updateAt) {
    this.updateAt = updateAt;
  }

  public Date getDeleteAt() {
    return deleteAt;
  }

  public void setDeleteAt(Date deleteAt) {
    this.deleteAt = deleteAt;
  }

  @Transient
  public boolean isDeleted(){
    return deleteAt != null;
  }
}
