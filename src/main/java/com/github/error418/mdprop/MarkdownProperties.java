package com.github.error418.mdprop;

import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * Loads properties from a Markdown file.
 * 
 * <p>
 * Properties need to be specified in markdown code blocks of this format
 * anywhere in the file:
 * 
 * <pre>
 *	``` property here.goes.the.property.name
 * 	This is the property value
 *	```
 * </pre>
 * </p>
 * 
 * @author Micha
 *
 */
public class MarkdownProperties extends Properties {
	private static final long serialVersionUID = 1L;

	/**
	 * Regex Pattern, which finds properties in a Markdown file.
	 * 
	 * <p>
	 * Group 1: Property name
	 * </p>
	 * <p>
	 * Group 2: Property value
	 * </p>
	 * 
	 */
	private static Pattern PROPERTY_PATTERN = Pattern.compile("^```property:(\\S+)\\s*^(.*?)\\s*^```", Pattern.UNIX_LINES | Pattern.MULTILINE | Pattern.DOTALL | Pattern.CASE_INSENSITIVE);

	public MarkdownProperties() {
		super();
	}

	public MarkdownProperties(Properties defaults) {
		super(defaults);
	}

	public void load(InputStream inputStream) {
		Scanner scanner = new Scanner(inputStream);
		readProperties(scanner);
		scanner.close();
	}

	public void load(Reader reader) {
		Scanner scanner = new Scanner(reader);
		readProperties(scanner);
		scanner.close();
	}

	public void loadFromXml(InputStream stream) {
		throw new RuntimeException("The method is not supported by this class");
	}

	private void readProperties(Scanner scanner) {
		while (scanner.findWithinHorizon(PROPERTY_PATTERN, 0) != null) {
			MatchResult m = scanner.match();

			String propertyName = m.group(1);
			String propertyValue = m.group(2);

			this.setProperty(propertyName, propertyValue);
		}
	}
}
