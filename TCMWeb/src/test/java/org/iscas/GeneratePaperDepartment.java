package org.iscas;

import org.iscas.utils.PaperItemToDepartment;
import org.iscas.utils.PaperItemToPinyin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratePaperDepartment {
	@Autowired
	PaperItemToDepartment paperItemToDepartment;
	
	public GeneratePaperDepartment() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testGenerateDepartment() {
		System.out.println("start department pro");
		paperItemToDepartment.GenerateDepartment();
		System.out.println("end department pro");
	}

}
