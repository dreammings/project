package com.jch.java;

import com.jch.java.system.httplog.listener.HttpLogListener;
import com.jch.java.system.httplog.producer.HttpLogProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GradeApplicationTests {

	@Autowired
	private HttpLogListener httpLogListener;
	@Test
	public void contextLoads() {
		for (int i = 0; i < 100; i++) {
			Map<String,Integer> map = new HashMap<>();
			map.put("index", i);
			new HttpLogProducer().produce(map);
		}
	}


}
