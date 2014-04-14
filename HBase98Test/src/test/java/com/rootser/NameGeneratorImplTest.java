package com.rootser;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context.xml"})
public class NameGeneratorImplTest {
	Logger logger = Logger.getLogger(NameGeneratorImplTest.class);
	@Autowired
	NameGenerator nameGen;
	@Test
	public void testGetNextName() {
		String name = nameGen.getNextName();
		logger.info("name is " + name);
		assertTrue("nameGen returned a null name", name != null);
	}

}
