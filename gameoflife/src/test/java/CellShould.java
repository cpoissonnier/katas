import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CellShould {

    @Test
    public void die_from_isolation_with_no_neighbour() {
        // arrange
        Cell cell = new Cell(State.ALIVE);

        // act
        boolean shouldBeAlive = cell.shouldBeAlive();

        // assert
        assertThat(shouldBeAlive).isFalse();
    }

    @Test
    public void die_from_isolation_with_one_neighbour() {
        // arrange
        Cell cell = new Cell(State.ALIVE, List.of(new Cell(State.ALIVE)));

        // act
        boolean shouldBeAlive = cell.shouldBeAlive();

        // assert
        assertThat(shouldBeAlive).isFalse();
    }


    @Test
    public void die_from_overpopulation_with_more_than_neighbours() {
        // arrange
        Cell cell = new Cell(State.ALIVE, List.of(new Cell(State.ALIVE), new Cell(State.ALIVE), new Cell(State.ALIVE), new Cell(State.ALIVE)));

        // act
        boolean shouldBeAlive = cell.shouldBeAlive();

        // assert
        assertThat(shouldBeAlive).isFalse();
    }

    @Test
    public void stay_alive_with_3_neighbours() {
        // arrange
        Cell cell = new Cell(State.ALIVE, List.of(new Cell(State.ALIVE), new Cell(State.ALIVE), new Cell(State.ALIVE)));

        // act
        boolean shouldBeAlive = cell.shouldBeAlive();

        // assert
        assertThat(shouldBeAlive).isTrue();
    }

    @Test
    public void stay_alive_with_2_neighbours() {
        // arrange
        Cell cell = new Cell(State.ALIVE, List.of(new Cell(State.ALIVE), new Cell(State.ALIVE)));

        // act
        boolean shouldBeAlive = cell.shouldBeAlive();

        // assert
        assertThat(shouldBeAlive).isTrue();
    }

    @Test
    public void stay_come_to_life_with_3_neighbours() {
        // arrange
        Cell cell = new Cell(State.DEAD, List.of(new Cell(State.ALIVE), new Cell(State.ALIVE), new Cell(State.ALIVE)));

        // act
        boolean shouldBeAlive = cell.shouldBeAlive();

        // assert
        assertThat(shouldBeAlive).isTrue();
    }

    @Test
    public void dead_cell_should_remain_dead() {
        // arrange
        Cell cell = new Cell(State.DEAD, List.of(new Cell(State.ALIVE)));

        // act
        boolean shouldBeAlive = cell.shouldBeAlive();

        // assert
        assertThat(shouldBeAlive).isFalse();
    }

}
