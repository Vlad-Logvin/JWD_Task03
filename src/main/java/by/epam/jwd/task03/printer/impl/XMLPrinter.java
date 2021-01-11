package by.epam.jwd.task03.printer.impl;

import java.util.Map;

import by.epam.jwd.task03.entity.impl.Node;
import by.epam.jwd.task03.printer.Printer;

public class XMLPrinter extends Printer {

	private final static String _NAME = "Name: ";
	private final static String _ATTRIBUTTES = "Attributtes: ";
	private final static String _EQUAL_WITH_SPACES = " = ";
	private final static String _NONE = "None";
	private final static String _CONTENT = "Content: ";

	public static void printContent(Node rootNode) {

		for (Node node : rootNode.getChildNodes()) {
			if (null != node.getContent()) {
				System.out.println(node.getContent());
			}
			printContent(node);
		}
	}

	public static void printAll(Node rootNode) {

		printRootNodeInfo(rootNode);

		for (Node node : rootNode.getChildNodes()) {
			printAll(node);
		}
	}

	public static void printRootNodeInfo(Node rootNode) {

		System.out.println(_NAME + rootNode.getName());
		System.out.print(_ATTRIBUTTES);
		Map<String, String> attributtes = rootNode.getAttributtes();
		if (!attributtes.isEmpty()) {
			for (Map.Entry<String, String> value : attributtes.entrySet()) {
				System.out.print(value.getKey() + _EQUAL_WITH_SPACES);
				System.out.println(value.getValue());
			}
		} else {
			System.out.println(_NONE);
		}

		System.out.print(_CONTENT);
		if (null != rootNode.getContent()) {
			System.out.println(rootNode.getContent());
		} else {
			System.out.println(_NONE);
		}

		System.out.println();
	}
}
