package io.github.nathanjrussell;

public class GenericCalculator<T extends Number> {

    private final T value;

    public GenericCalculator(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Double add(T other) {
        return value.doubleValue() + other.doubleValue();
    }

    public Double subtract(T other) {
        return value.doubleValue() - other.doubleValue();
    }

    public Double multiply(T other) {
        return value.doubleValue() * other.doubleValue();
    }

    public Double divide(T other) {
        if (other.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return value.doubleValue() / other.doubleValue();
    }

    public static void main(String[] args) {
        GenericCalculator<Integer> intCalc = new GenericCalculator<>(10);
        GenericCalculator<Double> doubleCalc = new GenericCalculator<>(5.5);

        System.out.println("Integer Operations:");
        System.out.println("10 + 2 = " + intCalc.add(2));
        System.out.println("10 - 2 = " + intCalc.subtract(2));
        System.out.println("10 * 2 = " + intCalc.multiply(2));
        System.out.println("10 / 2 = " + intCalc.divide(2));

        System.out.println("\nDouble Operations:");
        System.out.println("5.5 + 1.5 = " + doubleCalc.add(1.5));
        System.out.println("5.5 - 1.5 = " + doubleCalc.subtract(1.5));
        System.out.println("5.5 * 1.5 = " + doubleCalc.multiply(1.5));
        System.out.println("5.5 / 1.5 = " + doubleCalc.divide(1.5));
    }
}
