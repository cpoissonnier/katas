public class FizzBuzz {
    public static String fizzbuzz(int number) {
        if (isDivisibleBy3(number) && isDivisibleBy5(number)) {
            return "FizzBuzz";
        }
        if (isDivisibleBy3(number)) {
            return "Fizz";
        }
        if (isDivisibleBy5(number)) {
            return "Buzz";
        }
        return "" + number;
    }

    private static boolean isDivisibleBy5(int number) {
        return isDivisibleBy(number, 5);
    }

    private static boolean isDivisibleBy3(int number) {
        return isDivisibleBy(number, 3);
    }

    private static boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }

}
