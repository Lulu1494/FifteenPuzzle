package search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearcher implements Searcher {

	private Queue<Node> frontier;
	private int nodeCount;
	private int cutoffDepth;
	
	@Override
	public void addToFrontier(Node node) {
		frontier.add(node);
	}

	@Override
	public boolean cutoff(Node node) {
		return node.getDepth() > cutoffDepth;
	}

	@Override
	public boolean frontierIsEmpty() {
		return frontier.isEmpty();
	}

	@Override
	public int getNodeCount() {
		return nodeCount;
	}

	@Override
	public void initializeFrontier() {
		frontier = new LinkedList<Node>();
	}

	@Override
	public boolean inShallower(Node node, Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node removeFromFrontier() {
		return frontier.poll();
	}

	@Override
	public void resetNodeCount() {
		nodeCount = 0;
	}

	@Override
	public LinkedList<Character> search(Node problem) {
		if(problem.isGoal()) return problem.path();
		resetNodeCount();
		initializeFrontier();
		addToFrontier(problem);
		Set<Node> explored = new HashSet<>();
		while(!frontierIsEmpty()) {
			Node node = removeFromFrontier();
			nodeCount++;
			explored.add(node);
			for(char action : node.getAvailableActions().toCharArray()) {
				Node child = node.perform(action);
				if(frontier.contains(child) || explored.contains(child)) continue;
				if(child.isGoal()) return child.path();
				addToFrontier(child);
			}
		}
		return null;
	}

}
