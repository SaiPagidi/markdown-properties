package com.github.error418.properties;

import java.util.Properties;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;


public class MarkdownPropertiesTest {

	@Test
	public void testPropertyLoad() throws Exception {
		Properties mdProperties = new MarkdownProperties();
		mdProperties.load(ClassLoader.class.getResourceAsStream("/example-properties.md"));
		
		Assert.assertEquals("12", mdProperties.getProperty("tree.dimension.height.max"));
		Assert.assertEquals("4", mdProperties.getProperty("tree.branch.fruits.max"));
		
		Assert.assertThat(mdProperties.getProperty("tree.inscript"), Matchers.containsString("first line"));
		Assert.assertThat(mdProperties.getProperty("tree.inscript"), Matchers.containsString("second line"));
		Assert.assertThat(mdProperties.getProperty("tree.inscript"), Matchers.containsString("third line"));

		Assert.assertEquals(3, mdProperties.size());
	}
	
	@Test(expected=RuntimeException.class)
	public void testXmlMethod() throws Exception {
		Properties mdProperties = new MarkdownProperties();
		mdProperties.loadFromXML(ClassLoader.class.getResourceAsStream("/example-properties.md"));
	}
	
	@Test(expected=RuntimeException.class)
	public void testXmlWriterMethodA() throws Exception {
		Properties mdProperties = new MarkdownProperties();
		mdProperties.storeToXML(System.out, "test", "utf-8");
	}
	
	@Test(expected=RuntimeException.class)
	public void testXmlWriterMethodB() throws Exception {
		Properties mdProperties = new MarkdownProperties();
		mdProperties.storeToXML(System.out, "test");
	}
}
