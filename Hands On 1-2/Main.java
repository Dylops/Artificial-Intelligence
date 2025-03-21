import java.util.List;

public class Main {
    public static void main(String[] args) {

        boolean[][] pits = new boolean[4][4];
        pits[3][1] = true;
        pits[3][3] = true;
        boolean[][] wumpus = new boolean[4][4];
        wumpus[1][3] = true;

        State initialState = new WumpusWorldState(0, 0, pits, wumpus, 2, 3);

        // Búsqueda en Anchura
        SearchAlgorithm bfs = new SearchAlgorithm(new QueueFrontier());
        List<Action> pathBFS = bfs.search(initialState);
        System.out.println("Camino BFS: " + pathBFS);

        // Búsqueda en Profundidad
        SearchAlgorithm dfs = new SearchAlgorithm(new StackFrontier());
        List<Action> pathDFS = dfs.search(initialState);
        System.out.println("Camino DFS: " + pathDFS);
    }
}