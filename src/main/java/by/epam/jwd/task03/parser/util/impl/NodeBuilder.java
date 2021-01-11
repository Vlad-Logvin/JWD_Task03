package by.epam.jwd.task03.parser.util.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.jwd.task03.document.impl.XMLDocument;
import by.epam.jwd.task03.entity.impl.Node;
import by.epam.jwd.task03.parser.util.ElementBuilder;

public class NodeBuilder extends ElementBuilder {

	private final Pattern _DECLARATION = Pattern.compile("<[?]xml.+?[?]>");
	private final Pattern _TAG = Pattern.compile("<[^?].+?>");
	private final Pattern _OPENING_TAG_WITHOUT_ATTRIBUTES = Pattern.compile("<[^\\/]\\S+?>");
	private final Pattern _OPENING_TAG = Pattern.compile("<[^\\/].+?>");
	private final Pattern _CLOSING_TAG = Pattern.compile("</.+?>");
	private final Pattern _COMMENT = Pattern.compile("<!--.+?-->");
	private final Pattern _ATTRIBUTE = Pattern.compile("\\s.+?=\".+?\"");

	private final String _EQUAL = "=";
	private final char _OPEN_TAG = '<';
	private final String _OPEN_TAG_WITH_SLASH = "</";
	private final String _SPACE = " ";

	private String fileText;
	private LinkedList<Node> nodes = new LinkedList<>();

	public void setFileText(String fileText) {
		this.fileText = fileText;
	}

	public NodeBuilder(String fileText) {
		this.setFileText(fileText);
	}

	public String getFileText() {
		return fileText;
	}

	@Override
	public XMLDocument build() throws NodeBuilderException {
		XMLDocument document = new XMLDocument();
		document.setDeclatation(findDeclaration());
		Matcher matcher = _TAG.matcher(fileText);
		while (matcher.find()) {
			Tag tagType = defineTagType(fileText.substring(matcher.start(), matcher.end()));
			if (tagType != Tag.COMMENT) {
				String content = null;
				if (matcher.end() < fileText.length() && fileText.charAt(matcher.end()) != _OPEN_TAG) {
					content = fileText.substring(matcher.end(), fileText.indexOf(_OPEN_TAG_WITH_SLASH, matcher.end()));
				}
				createNode(tagType, fileText.substring(matcher.start(), matcher.end()), content);
			}
		}
		document.setRootNode(nodes.pop());
		return document;
	}

	private void createNode(Tag tagType, String tag, String content) throws NodeBuilderException {
		switch (tagType) {
		case CLOSING_TAG:
			if (nodes.size() != 1 && tag.substring(2, tag.length() - 1).equals(nodes.peekLast().getName())) {
				Node node = nodes.removeLast();
				nodes.peekLast().addChildNodeToList(node);
			} else if (nodes.size() != 1) {
				throw new NodeBuilderException();
			}
			break;
		case COMMENT: // ignore
			break;
		case OPENING_TAG_WITHOUT_ATTRIBUTES:
			nodes.add(new Node(tag.substring(1, tag.length() - 1), content));
			break;
		case OPENING_TAG_WITH_ATTRIBUTES:
			HashMap<String, String> attributtes = getAttributtes(tag);
			nodes.add(new Node(tag.substring(1, tag.indexOf(_SPACE)), attributtes, content));
			break;
		default:
			throw new NodeBuilderException();
		}
	}

	private HashMap<String, String> getAttributtes(String tag) {
		HashMap<String, String> attributtes = new HashMap<>();
		Matcher matcher = _ATTRIBUTE.matcher(tag);
		while (matcher.find()) {
			attributtes.put(tag.substring(matcher.start() + 1, tag.indexOf(_EQUAL, matcher.start())),
					tag.substring(tag.indexOf(_EQUAL, matcher.start()) + 1, matcher.end()));
		}
		return attributtes;
	}

	private String findDeclaration() {
		Matcher matcher = _DECLARATION.matcher(fileText);
		if (matcher.find()) {
			return fileText.substring(matcher.start() + 2, matcher.end() - 2);
		}
		return null;
	}

	private enum Tag {
		OPENING_TAG_WITHOUT_ATTRIBUTES, OPENING_TAG_WITH_ATTRIBUTES, CLOSING_TAG, COMMENT
	}

	private Tag defineTagType(String tag) throws NodeBuilderException {
		if (_COMMENT.matcher(tag).find()) {
			return Tag.COMMENT;
		} else if (_OPENING_TAG_WITHOUT_ATTRIBUTES.matcher(tag).find()) {
			return Tag.OPENING_TAG_WITHOUT_ATTRIBUTES;
		} else if (_OPENING_TAG.matcher(tag).find()) {
			return Tag.OPENING_TAG_WITH_ATTRIBUTES;
		} else if (_CLOSING_TAG.matcher(tag).find()) {
			return Tag.CLOSING_TAG;
		} else {
			throw new NodeBuilderException();
		}
	}

}
