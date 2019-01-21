package main;

public enum ComputationsEnum {


    ADD("+"){
        @Override
        public double perform(double firstNumber, double secondNumber) {
            return firstNumber + secondNumber;
        }
    },
    SUBTRACT("-"){
        @Override
        public double perform(double firstNumber, double secondNumber) {
            return firstNumber - secondNumber;
        }
    },
    DIVIDE(":"){
        @Override
        public double perform(double firstNumber, double secondNumber) { return firstNumber / secondNumber; }
    },
    MULTIPLY("*"){
        @Override
        public double perform(double firstNumber, double secondNumber) {
            return firstNumber * secondNumber;
        }
    };

    public final String symbol;

    ComputationsEnum(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract double perform(double firstNumber, double secondNumber);
}

