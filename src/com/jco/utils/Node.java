package com.jco.utils;

import java.util.ArrayList;

public class Node {
	private String id;
	private ArrayList<Node> nodes;
	
	public Node() {
		super();
	}
	
	public Node(String id) {
		super();
		this.id = id;
		nodes = new ArrayList<Node>();
	}
	
	public Node(String id, ArrayList<Node> nodes) {
		super();
		this.id = id;
		this.nodes = nodes;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	
	public void addNode(Node n) {
		nodes.add(n);
	}
}
