package org.tcmfile.hbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;


public class SaveFiles {
	public static Put getPut(String COLUMN_FAMILY, String QUALIFIER, File file) throws IOException {
		Put put = new Put(file.getName().getBytes());
     	FileInputStream fis = new  FileInputStream(file);
    	byte [] fb = new byte[fis.available()];
    	fis.read(fb);
    	fis.close();
    	put.addColumn(COLUMN_FAMILY.getBytes(), QUALIFIER.getBytes(), fb);
    	
    	return put;
	}
	public void saveFolderFiles(String h_tablename, String FolderName, String COLUMN_FAMILY, String QUALIFIER) throws IOException {
        Connection conn = HBaseClientFactory.getConnection();
    	TableName tablename = TableName.valueOf(h_tablename);
    	
    	Table table = conn.getTable(tablename);
    	
    	List<Put> puts = new ArrayList<>();
    	
    	File file = new File(FolderName);
    	if (file.exists()) {
            File[] files = file.listFiles();
            LinkedList<File> list = new LinkedList<File>();
            for (File file2 : files) {
                if (file2.isDirectory()) {
//                    System.out.println("文件夹:" + file2.getAbsolutePath());
                    list.add(file2);
                } else {
//                    System.out.println("文件:" + file2.getAbsolutePath());
                	System.out.println("name: " + file2.getName());
                	puts.add(getPut(COLUMN_FAMILY, QUALIFIER, file2));
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
//                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        list.add(file2);
                    } else {
//                        System.out.println("文件:" + file2.getAbsolutePath());
                    	System.out.println("name: " + file2.getName());
                    	puts.add(getPut(COLUMN_FAMILY, QUALIFIER, file2));
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    	
    	
    	int group_size = 5;
    	for(int i=0;i<puts.size()/group_size;i++) {
    		int last = (i+1)*group_size > puts.size()?puts.size():(i+1)*group_size;
    		table.put(puts.subList(i*group_size, last));
    	}
    	table.close();
    	
    	
	}
	
	public static void main(String args[]) throws IOException {
		new SaveFiles().saveFolderFiles("book", "book-holder", "content", "json");
	}
}
