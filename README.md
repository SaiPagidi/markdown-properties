# md-properties [![Build Status](https://travis-ci.org/error418/md-properties.svg?branch=master)](https://travis-ci.org/error418/md-properties)

Store your application properties and their documentation in one file.

## Usage

This library is written to support the `CommonMark` Markdown specification.

### Markdown Layout

To embed your property configuration inside a Markdown file you specify a code block like this:

	```property:here.goes.the.property.key
	And here goes the value
	```

For a more detailled example you can view the [Example Properties](example-properties.md)

### Loading Properties

Loading Properties in your code can then be done like this:

```java
MarkdownProperties mdProperties = new MarkdownProperties();
mdProperties.load(ClassLoader.class.getResourceAsStream("/example-properties.md"));
```

You may notice `MarkdownProperties` extends `java.util.Properties` and can be used like a "normal" `Properties` instance.

## Get it

You can get the library via Maven

```xml
<dependency>
  <groupId>com.github.error418.properties</groupId>
  <artifactId>md-properties</artifactId>
  <version>0.0.1</version>
</dependency>
```
