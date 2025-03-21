import java.util.*;

public class SearchAlgorithm {
    private Frontier frontier;
    private Set<State> visited = new HashSet<>();

    public SearchAlgorithm(Frontier frontier) {
        this.frontier = frontier;
    }

    public List<Action> search(State initialState) {
        Node initialNode = new Node(initialState, null, null);
        frontier.add(initialNode);
        visited.add(initialState);

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.remove();
            State currentState = currentNode.getState();

            if (currentState.isGoal()) {
                return buildPath(currentNode);
            }

            for (Action action : currentState.getPossibleActions()) {
                State nextState = currentState.getResult(action);
                if (!visited.contains(nextState)) {
                    visited.add(nextState);
                    frontier.add(new Node(nextState, currentNode, action));
                }
            }
        }
        return null;
    }

    private List<Action> buildPath(Node node) {
        LinkedList<Action> path = new LinkedList<>();
        while (node.getParent() != null) {
            path.addFirst(node.getAction());
            node = node.getParent();
        }
        return path;
    }
}