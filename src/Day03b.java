import java.util.ArrayList;
import java.util.HashMap;

import com.jco.utils.CharMap;
import com.jco.utils.FileTransfom;

public class Day03b {

	public static void main(String[] args) {
		String fileName = "inputs/day03a.txt";
		
		ArrayList<String> inputs = FileTransfom.inLineFileToStringArrayList(fileName);
		
		String wire1[] = inputs.get(0).split(",");
		
		CharMap map1 = new CharMap();
		
		for (String s : wire1) {
			map1.move(s);
		}
		
		map1.display();
		
		String wire2[] = inputs.get(0).split(",");
		
		CharMap map2 = new CharMap();
		
		HashMap<String, Integer> collisions2 = new HashMap<String, Integer>();
		
		for (String s : wire2) {
			collisions2 = map2.moveWithCollisions(s, map1);
			System.out.println(s);
			if (collisions2 != null) {
				
				for (String currentKey : collisions2.keySet()) {
					System.out.println(currentKey + " : " + collisions2.get(currentKey).intValue());
				}
			}
		}
	}

}
