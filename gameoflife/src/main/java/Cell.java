import java.util.ArrayList;
import java.util.List;

public class Cell {
    private State state;
    private List<Cell> neighbours;

    public Cell(State state) {
        this.state = state;
        this.neighbours = new ArrayList<>();
    }

    public Cell(State state, List<Cell> neighbours) {
        this.state = state;
        this.neighbours = neighbours;
    }

    public boolean isAlive() {
        return state == State.ALIVE;
    }

    public boolean shouldBeAlive() {
        long numberOfNeighbours = this.neighbours.stream().filter(Cell::isAlive).count();
        if (state == State.ALIVE) {
            return numberOfNeighbours == 3 || numberOfNeighbours == 2;
        }
        return numberOfNeighbours == 3;
    }
}
