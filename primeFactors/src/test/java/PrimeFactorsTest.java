import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PrimeFactorsTest {
    @Test
    void of_1_is_none() {
        assertThat(PrimeFactors.of(1)).isEmpty();
    }

    @Test
    void of_2_is_2() {
        assertThat(PrimeFactors.of(2)).containsExactlyInAnyOrder(2);
    }

    @Test
    void of_3_is_3() {
        assertThat(PrimeFactors.of(3)).containsExactlyInAnyOrder(3);
    }

    @Test
    void of_4_is_2_2() {
        assertThat(PrimeFactors.of(4)).containsExactlyInAnyOrder(2, 2);
    }

    @Test
    void of_6_is_2_3() {
        assertThat(PrimeFactors.of(6)).containsExactlyInAnyOrder(3, 2);
    }

    @Test
    void of_8_is_2_2_2() {
        assertThat(PrimeFactors.of(8)).containsExactlyInAnyOrder(2, 2, 2);
    }

    @Test
    void of_9_is_3_3() {
        assertThat(PrimeFactors.of(9)).containsExactlyInAnyOrder(3, 3);
    }
}
