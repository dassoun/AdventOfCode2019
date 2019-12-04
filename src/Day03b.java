import java.util.ArrayList;

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
		
		
		
	}

}
