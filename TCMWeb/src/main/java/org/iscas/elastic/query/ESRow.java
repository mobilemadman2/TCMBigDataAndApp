package org.iscas.elastic.query;

import com.alibaba.fastjson.JSONObject;

public class ESRow {

  public JSONObject source;

  public ESRow(JSONObject source) {
    this.source = source;
  }
}
