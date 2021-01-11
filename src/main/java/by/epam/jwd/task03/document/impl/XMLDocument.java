package by.epam.jwd.task03.document.impl;

import java.io.Serializable;

import by.epam.jwd.task03.document.Document;
import by.epam.jwd.task03.entity.impl.Node;

public class XMLDocument extends Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4990730620915850428L;

	private String declatation;
	private Node rootNode;

	public String getDeclatation() {
		return declatation;
	}

	public void setDeclatation(String declatation) {
		this.declatation = declatation;
	}

	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

	public XMLDocument() {

	}

	public XMLDocument(String declatation, Node rootNode) {
		super();
		this.declatation = declatation;
		this.rootNode = rootNode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((declatation == null) ? 0 : declatation.hashCode());
		result = prime * result + ((rootNode == null) ? 0 : rootNode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XMLDocument other = (XMLDocument) obj;
		if (declatation == null) {
			if (other.declatation != null)
				return false;
		} else if (!declatation.equals(other.declatation))
			return false;
		if (rootNode == null) {
			if (other.rootNode != null)
				return false;
		} else if (!rootNode.equals(other.rootNode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "XMLDocument [declatation=" + declatation + ", rootNode=" + rootNode + "]";
	}

}
