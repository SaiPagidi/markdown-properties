# markdown-properties 

Store application properties along with their documentation in a neat Markdown file and load them using this library.

[![Build Status](https://travis-ci.org/error418/markdown-properties.svg?branch=master)](https://travis-ci.org/error418/markdown-properties)
[![Code Climate](https://codeclimate.com/github/error418/markdown-properties/badges/gpa.svg)](https://codeclimate.com/github/error418/markdown-properties)

## Intention

Comments in property files tend to be not that appealing to the eye. The main reason is the lack of possibilities
to format the text written in these files. A different approach would be to write a separate documentation supporting
these features, which has the downside, that the location and prescense of these files needs to be known by users and developers.

The question is: Why should a property file not be configuration and well-readable documentation at the same time?
Markdown supports a easy-to-learn and powerful way to write nicely formatted text. Storing, reading and configuring
properties could be done with any text editor.

For a small example and giving you an idea of what this project is about you can view the project's
[Example Properties](examples/example-properties.md) file.

### TL;DR

> Storing documentation and the property values in one file (which supports text formatting) saves the developer
> and the user time and configuration errors.


## Usage

This library is written to support the `CommonMark` Markdown specification.

### Markdown Layout

To embed your property configuration inside a Markdown file you specify a code block like this:

	```property:here.goes.the.property.key
	And here goes the value
	```

For a more detailled example you can view the [Example Properties](examples/example-properties.md)

### Loading Properties

Loading Properties in your code can then be done like this:

```java
Properties mdProperties = new MarkdownProperties();
mdProperties.load(ClassLoader.class.getResourceAsStream("/example-properties.md"));
```

You may notice `MarkdownProperties` extends `java.util.Properties` and can be used like a "normal" `Properties` instance.

### Storing Properties

Storing Properties is not supported by this library. Calling `store` or `storeAsXML` methods will behave like the standard `Property` class methods.

## Get it

You can get the library via Maven

```xml
<dependency>
  <groupId>com.github.error418.properties</groupId>
  <artifactId>markdown-properties</artifactId>
  <version>0.0.2</version>
</dependency>
```
