public class Node {
    private State state;
    private Node parent;
    private Action action;

    public Node(State state, Node parent, Action action) {
        this.state = state;
        this.parent = parent;
        this.action = action;
    }

    public State getState() { return state; }
    public Node getParent() { return parent; }
    public Action getAction() { return action; }
}