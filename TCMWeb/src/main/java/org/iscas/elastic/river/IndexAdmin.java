package org.iscas.elastic.river;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.iscas.elastic.ESClientFactory;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;

public class IndexAdmin {

  private Client client;

  public IndexAdmin(Client client) {
    this.client = client;
  }

  private XContentBuilder fieldMapping(XContentBuilder xcb , RiverRule.IndexedField f) throws IOException {
    xcb.startObject(f.field).field("store",true);
    if(f.type != null) xcb = xcb.field("type", f.type);
    return xcb.endObject();
  }

  public void createIndex(RiverRule rule) throws IOException {
    if(rule == null || rule.targetIndex == null) return;
    if(existIndex(rule.targetIndex)) throw new IOException("Index " + rule.targetIndex +" already exists!");
    CreateIndexRequestBuilder builder = client.admin().indices().prepareCreate(rule.targetIndex);
    XContentBuilder xcb = jsonBuilder().startObject().startObject("properties");

    for(RiverRule.IndexedField f : rule.fields) {
      xcb = fieldMapping(xcb,f);
    }

    xcb = xcb.endObject().endObject();
    builder.addMapping(rule.targetType,xcb);
    CreateIndexResponse resp = builder.get();
    if(!resp.isAcknowledged()) throw new IOException("Fail to create Index : " + rule.targetIndex);
  }

  public void updateIndex(RiverRule rule) throws IOException {
    deleteIndex(rule);
    createIndex(rule);
  }

  public void deleteIndex(RiverRule rule) throws IOException {
    deleteIndex(rule.targetIndex);
  }

  public void deleteIndex(String indexName) throws IOException {
    DeleteIndexResponse resp = client.admin().indices().prepareDelete(indexName).get();
    if(!resp.isAcknowledged())
      throw new IOException("fail to delete elastic index : " + indexName);
  }

  public boolean existIndex(String indexName) throws IOException {
    return client.admin().indices()
            .exists(new IndicesExistsRequest(indexName)).actionGet().isExists();
  }



  public static void main(String[] args) throws ClassNotFoundException, IOException {
    String className = null;
    String cmd = "create";


    if(args.length == 1) {
      className = args[0];
    } else if(args.length == 2) {
      cmd = args[0];
      className = args[1];
    } else {
      System.out.println("Usage: <Command> <Name>");
    }

    IndexAdmin admin = new IndexAdmin(ESClientFactory.getClient());
    switch (cmd) {
      case "create":
        Class<?> clazz = Class.forName(className);
        RiverRule rule = RiverRule.extractRule(clazz,"doc");
        admin.createIndex(rule);
        return;
      case "delete":
        admin.deleteIndex(className);
        return;
        default:
          System.out.println("Unknown Command : " + cmd);
    }
  }
}
