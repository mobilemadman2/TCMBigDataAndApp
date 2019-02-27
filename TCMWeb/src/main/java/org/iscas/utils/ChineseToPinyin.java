package org.iscas.utils;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

public class ChineseToPinyin {
  public static String spliter = " ";
  public static String getPinyin(String param) {
	  String res = "";
	  try {
		res = PinyinHelper.convertToPinyinString(param, ChineseToPinyin.spliter, PinyinFormat.WITHOUT_TONE);
	} catch (PinyinException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return res;
  }
  
  public static void main(String [] args) {
	  System.out.println(ChineseToPinyin.getPinyin("中医大数据千秋万载"));
  }
}
