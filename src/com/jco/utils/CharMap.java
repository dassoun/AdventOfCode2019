package com.jco.utils;

public class CharMap {
	private int startX;
	private int startY;
	private int currentX;
	private int currentY;
	private int width;
	private int height;
	
	private char schema[][];

	public CharMap() {
		super();
		
		startX = 0;
		startY = 0;
		currentX = 0;
		currentY = 0;
		width = 1;
		height = 1;
		schema = new char[width][height];
		schema[currentX][currentY] = 'o';
	}

	public CharMap(int startX, int startY, int currentX, int currentY, int width, int height, char[][] schema) {
		super();
		this.startX = startX;
		this.startY = startY;
		this.currentX = currentX;
		this.currentY = currentY;
		this.width = width;
		this.height = height;
		this.schema = schema;
	}

	public CharMap(String move) {
		super();
		
		startX = 0;
		startY = 0;
		currentX = 0;
		currentY = 0;
		width = 1;
		height = 1;
		schema = new char[width][height];
		schema[currentX][currentY] = 'o';
		
		move(move);
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public char[][] getSchema() {
		return schema;
	}

	public void setSchema(char[][] schema) {
		this.schema = schema;
	}
	
	private void moveRight(int distance) {
		if ((currentX + distance) >= width) {
			int nbCharToAdd = (currentX + distance) - width + 1;
			
			resizeSchema(width + nbCharToAdd, height, "R");
		}
		for (int i=1; i<=distance; i++) {
			schema[currentX + i][currentY] = '-';
		}
		currentX += distance; 
		
		schema[currentX][currentY] = '+';
	}
	
	private void moveDown(int distance) {
		if ((currentY + distance) >= height) {
			int nbCharToAdd = (currentY + distance) - height + 1;
			
			resizeSchema(width, height + nbCharToAdd, "D");
		}
			
		for (int i=1; i<=distance; i++) {
			schema[currentX][currentY + i] = '|';
		}
		currentY += distance; 
		
		schema[currentX][currentY] = '+';
	}
	
	private void moveLeft(int distance) {
		if ((currentX - distance) < 0) {
			int nbCharToAdd = Math.abs(currentX - distance);
			
			resizeSchema(width + nbCharToAdd, height, "L");
		}

		for (int i=1; i<=distance; i++) {
			schema[currentX - i][currentY] = '-';
		}
		currentX -= distance; 
		
		schema[currentX][currentY] = '+';
	}
	
	private void moveUp(int distance) {
		if ((currentY - distance) < 0) {
			int nbCharToAdd = Math.abs(currentY - distance);
			
			resizeSchema(width, height + nbCharToAdd, "U");
		}

		for (int i=1; i<=distance; i++) {
			schema[currentX][currentY - i] = '|';
		}
		currentY -= distance; 
		
		schema[currentX][currentY] = '+';
	}
	
	private void resizeSchema(int newWidth, int newHeight, String direction) {
		char newSchema[][] = new char[newWidth][newHeight];
		
		// Initialize the new array
		for (int i=0; i<newWidth; i++) {
			for (int j=0; j<newHeight; j++) {
				newSchema[i][j] = '.';
			}
		}
		
		switch (direction) {
			case "R":
				for (int i=0; i<width; i++) {
					for (int j=0; j<height; j++) {
						newSchema[i][j] = schema[i][j];
					}
				}
				break;
			case "D":
				for (int i=0; i<width; i++) {
					for (int j=0; j<height; j++) {
						newSchema[i][j] = schema[i][j];
					}
				}
				break;
			case "L":
				for (int i=0; i<width; i++) {
					for (int j=0; j<height; j++) {
						newSchema[i + (newWidth - width)][j] = schema[i][j];
					}
				}
				
				currentX += (newWidth - width);
				startX += (newWidth - width);
				break;
			case "U":
				for (int i=0; i<width; i++) {
					for (int j=0; j<height; j++) {
						newSchema[i][j + (newHeight - height)] = schema[i][j];
					}
				}
				
				currentY += (newHeight - height);
				startY += (newHeight - height);
				break;
			default:
				break;
		}
		
		width = newWidth;
		height = newHeight;
		
		schema = newSchema;
	}
	
	public void move(String move) {
		String direction = move.substring(0, 1);
		int len = Integer.valueOf(move.substring(1));
		
		switch (direction) {
			case "R":
				moveRight(len);
				break;
			case "D":
				moveDown(len);
				break;
			case "L":
				moveLeft(len);
				break;
			case "U":
				moveUp(len);
				break;
			default:
				break;
		}
	}
	
	public void display() {
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				System.out.print(schema[j][i]);
			}
			System.out.print("\n");
		}
		
		System.out.println();
		System.out.println("start : (" + startX + ", " + startY + ")");
	}
}
