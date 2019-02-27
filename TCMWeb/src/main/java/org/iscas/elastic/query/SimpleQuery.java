package org.iscas.elastic.query;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;

public class SimpleQuery extends IndexQuery {

  public String keyword;

  public SimpleQuery(String keyword) {
    this.keyword = keyword;
  }

  @Override
  public void accept(SearchRequestBuilder req) {
    MatchQueryBuilder q = new MatchQueryBuilder("_all", keyword);
    req.setQuery(q);
  }
}
