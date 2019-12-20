package com.realtez.emailer.service;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileProcessorTests {

	@Autowired
	FileProcessor fileProc;

 
	@Test
	public void processtest() throws Exception {

		fileProc.process("C://temp//trecfile.txt");

	}

}
