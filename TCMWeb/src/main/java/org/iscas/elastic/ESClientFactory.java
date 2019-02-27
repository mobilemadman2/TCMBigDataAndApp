package org.iscas.elastic;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ESClientFactory {

  private static final String clusterName = "my-application";
  private static final List<String> peers = new ArrayList<String>(){{
//	  	add("127.0.0.1");
//	  	add("192.168.31.170");
//	  	add("192.168.31.121");
//	  	add("192.168.254.106");
	  	add("192.168.15.147");

  }};

  private static Client client;

  public static Client getClient() {
    if(client != null) return client;
    Settings settings = Settings.builder().put("cluster.name",ESClientFactory.clusterName).build();
    
    TransportClient es = new PreBuiltTransportClient(settings);
    try {
      for(String peer : peers) {
        String host = null;
        Integer port = 9300;

        if(peer.contains(":")) {
          String[] tmp = peer.split(":");
          host = tmp[0];
          port = Integer.valueOf(tmp[1]);
        } else host = peer;

        es.addTransportAddress(new TransportAddress(InetAddress.getByName(host),port));
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
      return null;
    }

    client = es;
    return client;
  }
}
