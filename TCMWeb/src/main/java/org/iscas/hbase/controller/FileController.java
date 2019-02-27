package org.iscas.hbase.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iscas.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tcmfile.hbase.GetFiles;

import com.alibaba.fastjson.JSONObject;


@Controller
public class FileController  extends BaseController {
	
	@RequestMapping(value = "/himage/get", method = RequestMethod.GET)
	public void getImage(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("image/get");
	    response.setContentType("image/png");
	    InputStream is = null;
	    try {
	        OutputStream out = response.getOutputStream();
//	        is = this.getClass().getResourceAsStream("/caslogo.png");

			byte [] bs = new GetFiles().get("tbl", "00003", "cf_1", "pic");
//	        byte[] bs = new byte[is.available()];
//	        is.read(bs);
	        out.write(bs);
	        out.flush();
	    } catch (Exception e) {
	         e.printStackTrace();
	    } finally {
	        if (is != null) {
	            try {
	               is.close();
	            } catch (IOException e) {
	            e.printStackTrace();
	        }
	          }
	    }
	}
	
	@RequestMapping(value = "/tcm-book/get/{table}/{rowkey}/{qualifier}", method = RequestMethod.GET)
	@ResponseBody
	public String getHbaseBook(@PathVariable String table, 
			@PathVariable String rowkey,
			@PathVariable String qualifier,
			HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("GetHBaseBook: " + rowkey);
		String result = "";
	    try {
//	        is = this.getClass().getResourceAsStream("/caslogo.png");

			byte [] bs = new GetFiles().get(table, rowkey, qualifier, "json");
			if(bs!=null)
				result = new String(bs);
			return JSONObject.parse(result).toString();
	    } catch (Exception e) {
	         e.printStackTrace();
	    } finally {}
	    
	    return result;
	     
	}
}
