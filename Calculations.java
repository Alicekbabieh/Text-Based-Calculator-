package alicekbabieh.projects.scicalc;
import java.util.ArrayList;
import java.util.List;
public class Calculations {
    private final List<CalculationRecord> history = new ArrayList<>();

    public double calculate(String op, double a, Double b) {
        double result;
        if (OperationMap.isBinary(op)) {
            if (b == null) throw new IllegalArgumentException("This operation needs two operands.");
            result = OperationMap.BINARY_OPERATIONS.get(op).apply(a, b);
            history.add(new CalculationRecord(op, new double[]{a, b}, result));
        } else if (OperationMap.isUnary(op)) {
            result = OperationMap.UNARY_OPERATIONS.get(op).apply(a);
            history.add(new CalculationRecord(op, new double[]{a}, result));
        } else {
            throw new IllegalArgumentException("User has entered an unknown operation: " + op);
        }
        return result;
    }
    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("There has not been any calculations yet.");
        } else {
            System.out.println("\n Calculation History ");
            for (CalculationRecord record : history) {
                System.out.println(record);
            }
        }
    } 
}
