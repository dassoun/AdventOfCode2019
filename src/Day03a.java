import java.util.ArrayList;

import com.jco.utils.CharMap;
import com.jco.utils.FileTransfom;
import com.jco.utils.Point;

public class Day03a {

	public static void main(String[] args) {
		String fileName = "inputs/day03a.txt";
		
		ArrayList<String> inputs = FileTransfom.inLineFileToStringArrayList(fileName);
		
		String wire1[] = inputs.get(0).split(",");
		
		CharMap map1 = new CharMap();
		
		for (String s : wire1) {
			map1.move(s);
		}
		
//		map1.display();
		
		String wire2[] = inputs.get(1).split(",");
		
		CharMap map2 = new CharMap();
		
		for (String s : wire2) {
			map2.move(s);
		}
		
//		map2.display();
		
		
		
		int xMin = Math.min(map1.getStartX(), map2.getStartX()) * -1;
		int xMax = Math.min(map1.getWidth() - map1.getStartX(), map2.getWidth() - map2.getStartX()) - 1;
		
		int yMin = Math.min(map1.getStartY(), map2.getStartY()) * -1;
		int yMax = Math.min(map1.getHeight() - map1.getStartY(), map2.getHeight() - map2.getStartY()) - 1;
		
		System.out.println("X min : " + xMin);
		System.out.println("X max : " + xMax);
		System.out.println("Y min : " + yMin);
		System.out.println("Y max : " + yMax);
		System.out.println();
		
		
		ArrayList<Point> listMap1 = new ArrayList<Point>();
		ArrayList<Point> listMap2 = new ArrayList<Point>();
		
		Point center1 = new Point(map1.getStartX(), map1.getStartY());
		Point center2 = new Point(map2.getStartX(), map2.getStartY());
		
		boolean found = false;
		int i = 1;
		while (!found) {
			listMap1 = map1.getPointsToManhattanDistance(center1, i);
			listMap2 = map2.getPointsToManhattanDistance(center2, i);
			
			for (Point p1 : listMap1) {
				for (Point p2 : listMap2) {
					if (p1.relativeTo(center1).equals(p2.relativeTo(center2))) {
						found = true;
					}
				}
			}
			
			if (!found) {
				i++;
			}
		}
		
		System.out.println(i);
	}
}
