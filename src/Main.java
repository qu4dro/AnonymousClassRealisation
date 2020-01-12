import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        testInt();
    }

    private static void testInt() {
        Random r = new Random();
        final ISummator summator = ClassCreator.createSummator();

        for (int i = 0; i < 100; i++) {
            final int firstInt = r.nextInt(200) - 100;
            final int secondInt = r.nextInt(200) - 100;

            testInt(() -> summator.plus(firstInt, secondInt), firstInt, secondInt, firstInt + secondInt, "plus");
            testInt(() -> summator.minus(firstInt, secondInt), firstInt, secondInt, firstInt - secondInt, "minus");
            testInt(() -> summator.mult(firstInt, secondInt), firstInt, secondInt, firstInt * secondInt, "mult");

            testDouble(() -> summator.div(firstInt, secondInt), firstInt, secondInt, ((double) firstInt / secondInt));

            final int firstArg = r.nextInt(20) - 10;
            final int secondArg = r.nextInt(10);
            testInt(() -> summator.pow(firstArg, secondArg), firstArg, secondArg, ((int) Math.pow(firstArg, secondArg)), "pow");


            final int argFirst = r.nextInt(20) - 10;
            final int argSecond = r.nextInt(10) + 1;
            testInt(() -> summator.remDiv(argFirst, argSecond), argFirst, argSecond, argFirst % argSecond, "remDiv");
        }
    }

    private static void testInt(final Supplier<Integer> f, final int a, final int b, final int expected, final String methodName) {
        final int actual = f.get();
        if (actual != expected) {
            throw new RuntimeException(String.format("Method %s is not working correctly with input (%d, %d), it's returning: %d, expected: %d", methodName, a, b, actual, expected));
        }
    }

    private static void testDouble(final Supplier<Double> f, final int a, final int b, final double expected) {
        final double actual = f.get();
        if (actual != expected) {
            throw new RuntimeException(String.format("Method div() is not working correctly with input (%d, %d), it's returning: %f, expected: %f", a, b, actual, expected));
        }
    }
}
