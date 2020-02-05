import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FizzBuzzShould {
    @Test
    public void return_1_for_1() {
        assertThat(FizzBuzz.fizzbuzzify(1)).isEqualTo("1");
    }

    @Test
    public void return_2_for_2() {
        assertThat(FizzBuzz.fizzbuzzify(2)).isEqualTo("2");
    }

    @Test
    public void return_fizz_for_3() {
        assertThat(FizzBuzz.fizzbuzzify(3)).isEqualTo("Fizz");
    }

    @Test
    public void return_buzz_for_5() {
        assertThat(FizzBuzz.fizzbuzzify(5)).isEqualTo("Buzz");
    }
    @Test
    public void return_fizzbuzz_for_15() {
        assertThat(FizzBuzz.fizzbuzzify(15)).isEqualTo("FizzBuzz");
    }

}
