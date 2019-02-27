package org.tcmfile.hbase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;

public class HBaseClientFactory {
	
	private static final String HBASE_ZOOKEEPER_QUORUM = "192.168.31.86";
	private static final String HBASE_ZOOKEEPER_PROPERTY_CLIENTPORT = "2181";
	private static final String HBASE_MASTER_ADDRESS = "192.168.31.86";
	
//	private static final String HBASE_ZOOKEEPER_QUORUM = "192.168.15.147";
//	private static final String HBASE_ZOOKEEPER_PROPERTY_CLIENTPORT = "2181";
//	private static final String HBASE_MASTER_ADDRESS = "192.168.15.147";
	
	private static Connection connection=null;
	
	
	public static Connection getConnection() {
		if(connection!=null) return connection;
		
		System.out.println("Hbase Connection initializing ...");
    	Configuration conf = HBaseConfiguration.create();

//    	conf.set("zookeeper.session.timeout", Integer.toString(1000));
    	conf.set("hbase.zookeeper.quorum", HBASE_ZOOKEEPER_QUORUM);
    	conf.set("hbase.zookeeper.property.clientPort", HBASE_ZOOKEEPER_PROPERTY_CLIENTPORT);
    	conf.set("hbase.master", HBASE_MASTER_ADDRESS);
    	conf.set("hbase.client.keyvalue.maxsize","30971520");
    	
    	try {
			connection = ConnectionFactory.createConnection(conf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	return connection;
	}
	
}
