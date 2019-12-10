package com.jco.utils;

import java.util.ArrayList;

public class Tree {
	private Node root;
	private Node currentNode;
	
	public Tree() {
		super();
	}

	public Tree(Node root) {
		super();
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public void addNode(String nodeId, String parentId) {
		Node n = findNodeById(parentId, root);
		
		if (n != null) {
			n.addNode(new Node(nodeId));
		}
	}

	
	public Node findNodeById(String id, Node n) {
		if (this.root == null) {
			return null;
		}
		
		if (n.getId().contentEquals(id)) {
			return n;
		}
		
		ArrayList<Node> children = n.getNodes();
		Node res = new Node();
		for (int i=0; res.getId() == null && i<children.size(); i++) {
			res = findNodeById(id, children.get(i));
		}
		return res;
	}

	public ArrayList<Node> getEveryNode(Node n, int level) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		if (this.root == null) {
			return null;
		}
				
		ArrayList<Node> children = n.getNodes();
		for (Node node : children) {
			nodes.add(node);
			getEveryNode(node, level + 1);
			System.out.println(node.getId() + ", " + level);
		}
		
		return nodes;
	}
	
	public int getDepthSum(Node n, int level) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		ArrayList<Node> children = n.getNodes();
		level++;
		for (Node node : children) {
			nodes.add(node);
			getDepthSum(node, level);
			System.out.println(node.getId() + ", " + level);
		}
		
		return level;
	}
}
