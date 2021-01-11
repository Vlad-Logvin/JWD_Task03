package by.epam.jwd.task03.parser.util;

import java.io.File;
import java.io.IOException;

public abstract class Reader {

	public abstract String read(File file) throws IOException;

}
