package by.epam.jwd.task03.main;

import java.io.File;
import java.io.IOException;

import by.epam.jwd.task03.document.Document;
import by.epam.jwd.task03.document.impl.XMLDocument;
import by.epam.jwd.task03.entity.Element;
import by.epam.jwd.task03.entity.impl.Node;
import by.epam.jwd.task03.parser.Parser;
import by.epam.jwd.task03.parser.impl.XMLParser;
import by.epam.jwd.task03.parser.util.impl.NodeBuilderException;
import by.epam.jwd.task03.printer.impl.XMLPrinter;

public class Main {

	public static void main(String[] args) throws IOException, NodeBuilderException {

		// final String filePath = "D:\\Java\\Java
		// epam\\programs\\xml-parser\\src\\main\\resources\\breakfast-menu.xml";
		final String filePath = "D:\\Java\\Java epam\\programs\\xml-parser\\pom.xml";

		Parser parser = new XMLParser();

		Document document = parser.parse(new File(filePath));

		Element rootNode = ((XMLDocument) document).getRootNode();

		XMLPrinter.printContent((Node) rootNode);

		System.out.println("\n");

		XMLPrinter.printAll((Node) rootNode);
	}
}
