package org.iscas;

import org.iscas.utils.DiseasesItemToPinyin;
import org.iscas.utils.MaterialItemToPinyin;
import org.iscas.utils.PatentItemToPinyin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratePatentPinyin {

	@Autowired
	PatentItemToPinyin patentItemToPinyin;
	
	public GeneratePatentPinyin() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testGeneratePinyin() {
		System.out.println("start pinyin pro");
		patentItemToPinyin.GenerateNamePinyin();
		System.out.println("end pinyin pro");
	}

}