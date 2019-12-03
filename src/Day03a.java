import java.util.ArrayList;

import com.jco.utils.CharMap;
import com.jco.utils.FileTransfom;

public class Day03a {

	public static void main(String[] args) {
		String fileName = "inputs/day03a.txt";
		
		ArrayList<String> inputs = FileTransfom.inLineFileToStringArrayList(fileName);
		
		String wire1[] = inputs.get(0).split(",");
		
		CharMap map1 = new CharMap();
		
		for (String s : wire1) {
			map1.move(s);
		}
		
		map1.display();
		
		String wire2[] = inputs.get(1).split(",");
		
		CharMap map2 = new CharMap();
		
		for (String s : wire2) {
			map2.move(s);
		}
		
		map2.display();
		
		
		
		int xMin = Math.min(map1.getStartX(), map2.getStartX()) * -1;
		int xMax = Math.min(map1.getWidth() - map1.getStartX(), map2.getWidth() - map2.getStartX()) - 1;
		
		int yMin = Math.min(map1.getStartY(), map2.getStartY()) * -1;
		int yMax = Math.min(map1.getHeight() - map1.getStartY(), map2.getHeight() - map2.getStartY()) - 1;
		
		System.out.println("X min : " + xMin);
		System.out.println("X max : " + xMax);
		System.out.println("Y min : " + yMin);
		System.out.println("Y max : " + yMax);
		System.out.println();
		
		boolean found = false;
		
		int manhattanDistance = 1;
		while (!found) {
			for (int j=1; j<=manhattanDistance; j++) {
				for (int k=manhattanDistance-j; k<=manhattanDistance; k++) {
//					if () {
//						found = true;
//					}
				}
			}
			
			manhattanDistance++;
		}
	}
}
