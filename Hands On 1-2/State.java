import java.util.List;

public interface State {

    List<Action> getPossibleActions();

    State getResult(Action action);

    boolean isGoal();

    // Metodo para comparar estados
    boolean equals(Object obj);
    int hashCode();
}