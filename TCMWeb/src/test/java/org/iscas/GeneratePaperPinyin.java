package org.iscas;


import org.iscas.utils.PaperItemToPinyin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratePaperPinyin {

		@Autowired
		PaperItemToPinyin paperItemToPinyin;
		
		public GeneratePaperPinyin() {
			// TODO Auto-generated constructor stub
		}
		
		@Test
		public void testGeneratePinyin() {
			System.out.println("start pinyin pro");
			paperItemToPinyin.GenerateNameCnPinyin();
			System.out.println("end pinyin pro");
		}

}
