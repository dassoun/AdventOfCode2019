package com.jco.utils;

public class Point {
	private int x;
	private int y;
	
	public Point() {
		super();
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Point p) {
		return (x == p.x && y == p.y);
	}
	
	public Point relativeTo(Point p) {
		return new Point(x - p.x, y - p.y);
	}
}
