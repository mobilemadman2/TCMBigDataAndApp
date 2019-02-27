package org.iscas.elastic.query;

import java.util.ArrayList;
import java.util.List;

public class ESResult {

  public Long totalHits = 0L;

  public Integer pageSize = 0;

  public List<ESRow> rows = new ArrayList<>();

}
