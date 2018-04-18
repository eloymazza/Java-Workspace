package nodeList;

import java.util.Iterator;

public class NodeIterator implements Iterator<Node> {
	
	protected Node itRoot;
	
	public NodeIterator(Node root){
		itRoot = root;
	}
	
	@Override
	public boolean hasNext() {
		return itRoot != null;
	}

	@Override
	public Node next() {
		Node next = itRoot;
		itRoot = itRoot.getNext();
		return next;
	}

}
