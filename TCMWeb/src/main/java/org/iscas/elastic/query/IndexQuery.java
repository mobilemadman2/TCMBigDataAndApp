package org.iscas.elastic.query;

import org.elasticsearch.action.search.SearchRequestBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public abstract class IndexQuery {

  public Set<String> indices = new HashSet<>();

  public Set<String> fields;

  public Integer start;

  public Integer limit;

  public abstract void  accept(SearchRequestBuilder req);

  public IndexQuery indice(String... indexNames) {
    indices.addAll(Arrays.asList(indexNames));
    return this;
  }

  public IndexQuery select(String... field) {
	if (fields==null) {
		fields = new HashSet<>();
	}
    fields.addAll(Arrays.asList(field));
    return this;
  }

  public IndexQuery from(int start) {
    this.start = start < 0 ? 0 : start;
    return this;
  }

  public IndexQuery limit(int size) {
    this.limit = size;
    return this;
  }
}
