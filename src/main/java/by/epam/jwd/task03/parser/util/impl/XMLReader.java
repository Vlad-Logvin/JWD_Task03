package by.epam.jwd.task03.parser.util.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import by.epam.jwd.task03.parser.util.Reader;

public class XMLReader extends Reader {

	private final String _EMPTINESS = "";

	@Override
	public String read(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		return getFileText(bufferedReader);
	}

	private String getFileText(BufferedReader bufferedReader) throws IOException {
		String fileText = _EMPTINESS;
		while (bufferedReader.ready()) {
			fileText += bufferedReader.readLine();
		}
		return fileText;
	}

}
