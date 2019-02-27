package org.tcmfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.tcmfile.hbase.HBaseClientFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {


        Connection conn = HBaseClientFactory.getConnection();
        

        
    	HBaseAdmin admin = (HBaseAdmin) conn.getAdmin();
    	
    	
    	
    	TableName tablename = TableName.valueOf("book");
    	
    	Table table = conn.getTable(tablename);
//    	String ROW_KEYS = "00003";
//    	Put put = new Put(ROW_KEYS.getBytes());
//    	put.addColumn("cf_1".getBytes(), "a".getBytes(), "auto value".getBytes());
//    	
//    	table.put(put);
//    	table.close();
    	
//    	Scan scan = new Scan();
////    	scan.setMaxVersions();
//    	scan.setBatch(1000);
//    	ResultScanner rScanner = null;
//    	
//    	System.out.println("start here");
//    	rScanner = table.getScanner("cf_1".getBytes());
//    	for(Result r: rScanner) {
//    		for(Cell cell: r.listCells()) {
////    			System.out.println(cell.get);
//    			System.out.println(Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength()));
//    			System.out.println(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
//    			
//    		}
//    	}
//    	
//    	String imgPath = "caslogo.png";
//    	FileInputStream fis = new  FileInputStream(imgPath);
//    	byte [] fb = new byte[fis.available()];
//    	fis.read(fb);
//    	fis.close();
//    	
//    	Put put= new Put(ROW_KEYS.getBytes());
//    	put.addColumn("cf_1".getBytes(), "pic".getBytes(), fb);
//    	table.put(put);
//    	table.close();
    	
    	
//    	Get get = new Get(ROW_KEYS.getBytes());
//    	Result result = table.get(get);
////    	byte [] bs = result.value();
//    	byte [] bs = result.getValue("cf_1".getBytes(), "pic".getBytes());
//    	table.close();
//    	File file = new File("fromHbase.png");
//    	FileOutputStream  fileOutputStream = new FileOutputStream(file);
//    	fileOutputStream.write(bs);
//    	fileOutputStream.close();
    	
    	if(admin.tableExists(tablename)) {
    		System.out.println(tablename + " exist!");
    	}
    	else {
    		System.out.println(tablename + " not exists!");
    	}
        System.out.println( "Hello World!" );
    }
}
