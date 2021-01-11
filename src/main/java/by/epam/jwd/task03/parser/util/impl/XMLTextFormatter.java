package by.epam.jwd.task03.parser.util.impl;

import by.epam.jwd.task03.parser.util.TextFormatter;

public class XMLTextFormatter extends TextFormatter {

	private final String _SPACES = "( +)";
	private final String _SPACE = " ";
	private final String _TAGS_WITH_SPACE = "> <";
	private final String _TAGS_WITHOUT_SPACE = "><";

	private String fileText;

	public XMLTextFormatter(String fileText) {
		this.fileText = fileText;
	}

	public String getFileText() {
		return fileText;
	}

	public void setFileText(String fileText) {
		this.fileText = fileText;
	}

	@Override
	public String format() {
		return fileText.replaceAll(_SPACES, _SPACE).trim().replace(_TAGS_WITH_SPACE, _TAGS_WITHOUT_SPACE);
	}
}
