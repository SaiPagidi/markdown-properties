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
	 * RegEx Pattern, which finds properties in a Markdown file.
	 * 
	 * <p>
	 * Matching group 1: Property name
	 * </p>
	 * <p>
	 * Matching group 2: Property value
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

	/**
	 * Reads a Markdown file from the input byte stream.
	 * The input stream is assumed to use the UTF-8 character encoding
	 * 
	 * @param inputStream the input stream.
	 */
	public void load(InputStream inputStream) {
		Scanner scanner = new Scanner(inputStream, "UTF-8");
		readProperties(scanner);
		scanner.close();
	}

	public void load(Reader reader) {
		Scanner scanner = new Scanner(reader);
		readProperties(scanner);
		scanner.close();
	}

	/**
	 * This method is not supported by {@code MarkdownProperties} and will always throw a
	 * {@link RuntimeException}.
	 * 
	 * @throws RuntimeException always throws this exception, since this method is not supported by {@code MarkdownProperties}
	 * @param stream
	 */
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
