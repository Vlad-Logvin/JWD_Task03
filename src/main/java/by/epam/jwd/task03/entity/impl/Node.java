package by.epam.jwd.task03.entity.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.epam.jwd.task03.entity.Element;

public class Node extends Element implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2619215218084285718L;

	private String name;
	private Map<String, String> attributtes = new HashMap<>();
	private List<Node> childNodes = new ArrayList<>();
	private String content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getAttributtes() {
		return attributtes;
	}

	public void setAttributtes(Map<String, String> attributtes) {
		this.attributtes = attributtes;
	}

	public List<Node> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(List<Node> childNodes) {
		this.childNodes = childNodes;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void addChildNodeToList(Node node) {
		childNodes.add(node);
	}

	public Node removeChildNodeFromList(int index) {
		return childNodes.remove(index);
	}

	public Node(String name, Map<String, String> attributtes) {
		this(name);
		this.attributtes = attributtes;
	}

	public Node(String name) {
		this.name = name;
	}

	public Node(String name, Map<String, String> attributtes, String content) {
		this(name, attributtes);
		this.content = content;
	}

	public Node(String name, String content) {
		this(name);
		this.content = content;
	}

	public Node() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributtes == null) ? 0 : attributtes.hashCode());
		result = prime * result + ((childNodes == null) ? 0 : childNodes.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Node other = (Node) obj;
		if (attributtes == null) {
			if (other.attributtes != null)
				return false;
		} else if (!attributtes.equals(other.attributtes))
			return false;
		if (childNodes == null) {
			if (other.childNodes != null)
				return false;
		} else if (!childNodes.equals(other.childNodes))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [name=" + name + ", attributtes=" + attributtes + ", childNodes=" + childNodes + ", content="
				+ content + "]";
	}
}
