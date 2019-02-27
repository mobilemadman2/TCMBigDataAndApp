package org.iscas.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenerateBookPinyinTest {

	@Autowired
	GenerateBookPinyin generateBookPinyin;
	
	public GenerateBookPinyinTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testGeneratePinyin() {
		generateBookPinyin.GeneratePinyin();
	}

}
