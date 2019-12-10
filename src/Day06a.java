import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import com.jco.utils.Tree;
import com.jco.utils.Node;

public class Day06a {

	public static void main(String[] args) {
		
		Tree tree = new Tree(new Node("COM"));
		tree.addNode("B", "COM");
		tree.addNode("C", "B");
//		tree.addNode("D", "C");
//		tree.addNode("E", "D");
//		tree.addNode("F", "E");
		tree.addNode("G", "B");
//		tree.addNode("H", "G");
//		tree.addNode("I", "D");
//		tree.addNode("J", "E");
//		tree.addNode("K", "J");
//		tree.addNode("L", "K");
		
//		Node n = tree.findNodeById("C", tree.getRoot());
		
		Node n = tree.getRoot();
		
		//ArrayList<Node> l = tree.getEveryNode(tree.getRoot(), 1);
		
//		tree.getDepthSum(tree.getRoot(), 0);
		System.out.println(tree.getDepthSum(tree.getRoot(), 0));
	}

}
