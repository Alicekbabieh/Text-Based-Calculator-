package alicekbabieh.projects.scicalc;

public class CalculationRecord {
    private final String operation; 
    private final double[] operands; 
    private final double result; 
    
    public CalculationRecord(String operation, double[] operands, double result) {
        this.operation = operation;
        this.operands = operands; 
        this.result = result; 
    }
    public double getResult() {
        return result;
    }
    
    @Override
    public String toString() {
        return switch (operands.length) {
            case 2 -> operation + ": " + operands[0] + " and " + operands[1] + " = Result: " + result;
            case 1 -> operation + ": " + operands[0] + " = Result: " + result;
            default -> operation + ": = Result: " + result;
        };
    }
}
        
               