package search;

import java.util.Map;
import java.util.PriorityQueue;

public class AStarSearcher extends BreadthFirstSearcher {

	@Override
	public void initializeFrontier() {
		frontier = new PriorityQueue<Node>();
	}

	@Override
	public boolean inShallower(Node node, Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return false;
	}
}
