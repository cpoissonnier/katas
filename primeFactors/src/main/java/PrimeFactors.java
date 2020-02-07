import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static List<Integer> of(int number) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int candidate = 2; number > 1; candidate++) {
            while (number % candidate == 0) {
                primes.add(candidate);
                number = number / candidate;
            }
        }

        return primes;
    }
}
