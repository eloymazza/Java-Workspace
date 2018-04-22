package ejercicio6;
import java.util.*;

public class DFSTree {
	
	private static List<Node> longestBranch = new ArrayList<Node>();

	
	public static List<Node> getLongestBranch(BinaryTree t){
		
		if(!t.isEmpty()){
			if(t.getHeight() == 0){
				longestBranch.add(t.getRoot());
			}
			else{
				Node targetNode = t.getElemAtLevel(t.getHeight()).iterator().next();
				Stack<Node> s = new Stack<Node>();
				getLongestBranch(s, t.getRoot(), targetNode);
			}
			return longestBranch;
		}
		return null;
	}

	private static void getLongestBranch(Stack<Node> s, Node currentNode, Node targetNode) {
		
		s.push(currentNode);
		Node left = currentNode.getLeft();
		Node right = currentNode.getRight();
		
		if(currentNode == targetNode){
			generateSolution(s);
		}
		else{
			if(left != null){
				getLongestBranch(s, left, targetNode);
			}
			if(right != null){
				getLongestBranch(s, right, targetNode);
			}
		}
		s.pop();
		
	}

	private static void generateSolution(Stack<Node> s) {
		
		Stack<Node> aux = new Stack<Node>();
		while(!s.isEmpty()){
			aux.push(s.pop());
		}
		while(!aux.isEmpty()){
			Node currentNode = aux.pop();
			longestBranch.add(currentNode);
			s.push(currentNode);
		}
		
	}


	
	
}
