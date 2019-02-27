package org.iscas.web.utils.model;

/**
 * Created by suemi on 17-7-7.
 */
public class Context {

  public Long userId;

  public Long seq;

  public String query;


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }


  public Long getSeq() {
    return seq;
  }

  public void setSeq(Long seq) {
    this.seq = seq;
  }

}
