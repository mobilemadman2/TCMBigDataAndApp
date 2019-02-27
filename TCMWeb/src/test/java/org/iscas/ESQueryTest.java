package org.iscas;

import java.io.IOException;

import org.iscas.elastic.ESClientFactory;
import org.iscas.elastic.query.ESResult;
import org.iscas.elastic.query.ESRow;
import org.iscas.elastic.query.QueryEngine;
import org.iscas.elastic.query.SimpleQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class ESQueryTest {

	public ESQueryTest() {
		// TODO Auto-generated constructor stub
		
	}

	
	@Test
	public void queryTest() throws IOException{
		SimpleQuery simpleQuery = new SimpleQuery("");
		QueryEngine qe= new QueryEngine(ESClientFactory.getClient());
		ESResult esResult = qe.execute(simpleQuery);
		
		for(ESRow esrow:esResult.rows) {
			System.out.println(esrow.source);
		}
		
		System.out.println("Ok");
	}
}
