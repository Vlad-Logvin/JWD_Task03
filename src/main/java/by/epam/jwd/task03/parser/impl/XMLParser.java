package by.epam.jwd.task03.parser.impl;

import java.io.File;
import java.io.IOException;

import by.epam.jwd.task03.document.Document;
import by.epam.jwd.task03.parser.Parser;
import by.epam.jwd.task03.parser.util.ElementBuilder;
import by.epam.jwd.task03.parser.util.Reader;
import by.epam.jwd.task03.parser.util.TextFormatter;
import by.epam.jwd.task03.parser.util.impl.NodeBuilder;
import by.epam.jwd.task03.parser.util.impl.NodeBuilderException;
import by.epam.jwd.task03.parser.util.impl.XMLReader;
import by.epam.jwd.task03.parser.util.impl.XMLTextFormatter;

public class XMLParser extends Parser {

	@Override
	public Document parse(File file) throws IOException, NodeBuilderException {

		Reader xmlReader = new XMLReader();

		TextFormatter xmlFileText = new XMLTextFormatter(xmlReader.read(file));

		ElementBuilder xmlBuilder = new NodeBuilder(xmlFileText.format());

		return xmlBuilder.build();
	}
}
