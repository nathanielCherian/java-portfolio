package calc;

public class Math {

    public static enum OPERATOR { NOOP, PLUS, MINUS, DIVIDE, MULTIPLY };
    public static double calculateIt(double arg1, OPERATOR mathOp, double arg2) {

        double calcAnswer;
        switch(mathOp)
        {
            case PLUS:
                calcAnswer = arg1 + arg2;
                break;
            case MINUS:
                calcAnswer = arg1 - arg2;
                break;
            case DIVIDE:
                calcAnswer = arg1 / arg2;
                break;
            case MULTIPLY:
                calcAnswer = arg1 * arg2;
                break;
            case NOOP:
            default:
                calcAnswer = arg1;
        }
        return calcAnswer;
    }


}
