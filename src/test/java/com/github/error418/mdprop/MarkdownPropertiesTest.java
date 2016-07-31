package com.github.error418.mdprop;

import org.junit.Test;

import com.github.error418.mdprop.MarkdownProperties;

public class MarkdownPropertiesTest {

	@Test
	public void testPropertyLoad() throws Exception {
		MarkdownProperties mdProperties = new MarkdownProperties();
		mdProperties.load(ClassLoader.class.getResourceAsStream("/example-properties.md"));
		
		System.out.println("#" + mdProperties.getProperty("tree.dimension.height.max") + "#");
		System.out.println("#" + mdProperties.getProperty("tree.branch.fruits.max") + "#");
		
		System.out.println(mdProperties.size());
	}
}
