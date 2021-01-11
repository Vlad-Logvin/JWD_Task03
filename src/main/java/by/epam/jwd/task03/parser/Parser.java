package by.epam.jwd.task03.parser;

import java.io.File;
import java.io.IOException;

import by.epam.jwd.task03.document.Document;
import by.epam.jwd.task03.parser.util.impl.NodeBuilderException;

public abstract class Parser {
	public abstract Document parse(File file) throws IOException, NodeBuilderException;
}
