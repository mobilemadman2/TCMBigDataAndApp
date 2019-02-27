package org.iscas.controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolExecutor {
	
	private static int bookNumber = 0;
	
	public ThreadPoolExecutor(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	
	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(bookNumber);
		
		for(int i = 0; i < bookNumber; i++) {
			//fixedThreadPool.execute();
		}
	}
}