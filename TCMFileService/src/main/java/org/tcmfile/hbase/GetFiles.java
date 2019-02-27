package org.tcmfile.hbase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;


public class GetFiles {
	public byte [] get(String h_tablename, String ROW_KEYS, String COLUMN_FAMILY, String QUALIFIER) throws IOException {
        Connection conn = HBaseClientFactory.getConnection();
    	TableName tablename = TableName.valueOf(h_tablename);
    	
    	Table table = conn.getTable(tablename);
    	Get get = new Get(ROW_KEYS.getBytes());
    	Result result = table.get(get);
//    	byte [] bs = result.value();
    	byte [] bs = result.getValue(COLUMN_FAMILY.getBytes(), QUALIFIER.getBytes());

    	table.close();
    	
    	return bs;
	}
	
	public static void main(String args[]) throws IOException {
		byte [] bs = new GetFiles().get("tbl", "00003", "cf_1", "pic");
    	File file = new File("fromHbase"+(new Random()).nextInt(10000)+".png");
    	FileOutputStream  fileOutputStream = new FileOutputStream(file);
    	fileOutputStream.write(bs);
    	fileOutputStream.close();
	}
}
