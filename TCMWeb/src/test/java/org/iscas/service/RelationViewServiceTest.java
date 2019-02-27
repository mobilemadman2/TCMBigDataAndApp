package org.iscas.service;

import org.iscas.web.service.RelationViewService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationViewServiceTest {

	@Autowired
	RelationViewService rvs;
	public RelationViewServiceTest() {
		// TODO Auto-generated constructor stub
	}

	
	@Ignore
	@Test
	public void test() {
		rvs.GenerateView("黄帝内经", "0-0-0");
	}
	
	@Ignore
	@Test
	public void testRelationController() {
		rvs.update("黄帝内经", "0-0-0", "book-disease_肺心病", "肺心病", "肺心病1");
	}
}
