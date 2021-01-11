package by.epam.jwd.task03.parser.util;

import by.epam.jwd.task03.document.Document;
import by.epam.jwd.task03.parser.util.impl.NodeBuilderException;

public abstract class ElementBuilder {

	public abstract Document build() throws NodeBuilderException;

}
