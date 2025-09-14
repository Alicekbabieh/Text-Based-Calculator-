package alicekbabieh.projects.scicalc;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
public class OperationMap {
    public static final Map<String, BiFunction<Double, Double, Double>> 
            BINARY_OPERATIONS = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> {
                if (b == 0) throw new ArithmeticException("Unable to divide by zero");
                return a / b;
            },
            "^", Math::pow);

    public static final Map<String, Function<Double, Double>> 
            UNARY_OPERATIONS = Map.of(
            "√", a -> {
                if (a < 0) throw new ArithmeticException("Cannot take square root of negative number");
                return Math.sqrt(a);
            },
            "sin", a -> Math.sin(Math.toRadians(a)),
            "cos", a -> Math.cos(Math.toRadians(a)),
            "tan", a -> Math.tan(Math.toRadians(a))
    );

    public static boolean isBinary(String op) {
        return BINARY_OPERATIONS.containsKey(op);
    }

    public static boolean isUnary(String op) {
        return UNARY_OPERATIONS.containsKey(op);
    }
    public static BiFunction<Double, Double, Double> getBinaryOperation(String op) {
        BiFunction<Double, Double, Double> func = BINARY_OPERATIONS.get(op);
        if (func == null) throw new IllegalArgumentException("Unknown binary operation: " + op);
        return func;
    }

    public static Function<Double, Double> getUnaryOperation(String op) {
        Function<Double, Double> func = UNARY_OPERATIONS.get(op);
        if (func == null) throw new IllegalArgumentException("Unknown unary operation: " + op);
        return func;
    }

    // Optional: Print all available operations
    public static void printAvailableOperations() {
        System.out.println("Binary operations: " + BINARY_OPERATIONS.keySet());
        System.out.println("Unary operations: " + UNARY_OPERATIONS.keySet());
    }
}