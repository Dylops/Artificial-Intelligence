import java.util.*;

public class WumpusWorldState implements State {
    private int x, y;
    private boolean[][] pits;
    private boolean[][] wumpus;
    private int goldX, goldY;

    public WumpusWorldState(int x, int y, boolean[][] pits, boolean[][] wumpus, int goldX, int goldY) {
        this.x = x;
        this.y = y;
        this.pits = pits;
        this.wumpus = wumpus;
        this.goldX = goldX;
        this.goldY = goldY;
    }

    @Override
    public List<Action> getPossibleActions() {
        List<Action> actions = new ArrayList<>();
        int rows = pits.length;
        int cols = pits[0].length;

        // Check UP (y+1)
        if (y + 1 < cols && !pits[x][y + 1] && !wumpus[x][y + 1]) {
            actions.add(Action.Arriba);
        }
        // Check DOWN (y-1)
        if (y - 1 >= 0 && !pits[x][y - 1] && !wumpus[x][y - 1]) {
            actions.add(Action.Abajo);
        }
        // Check LEFT (x-1)
        if (x - 1 >= 0 && !pits[x - 1][y] && !wumpus[x - 1][y]) {
            actions.add(Action.Izquierda);
        }
        // Check RIGHT (x+1)
        if (x + 1 < rows && !pits[x + 1][y] && !wumpus[x + 1][y]) {
            actions.add(Action.Derecha);
        }
        return actions;
    }

    @Override
    public State getResult(Action action) {
        int newX = x, newY = y;
        switch (action) {
            case Arriba: newY++; break;
            case Abajo: newY--; break;
            case Izquierda: newX--; break;
            case Derecha: newX++; break;
        }
        return new WumpusWorldState(newX, newY, pits, wumpus, goldX, goldY);
    }

    @Override
    public boolean isGoal() {
        return x == goldX && y == goldY;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WumpusWorldState that = (WumpusWorldState) obj;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}