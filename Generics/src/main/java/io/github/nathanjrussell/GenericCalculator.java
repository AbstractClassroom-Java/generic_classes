package io.github.nathanjrussell;

import java.util.ArrayList;
import java.util.List;

public class GenericCalculator<T extends Number> {

    private final T value;

    public GenericCalculator(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @SuppressWarnings("unchecked")
    public T add(T other) {
        Number result = value.doubleValue() + other.doubleValue();
        return (T) result;  // ⚠️ Unchecked cast (may fail for certain types)
    }
//    public Double add(T other) {
//        return value.doubleValue() + other.doubleValue();
//    }

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

        List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("World");

        for (String str : strList) {
            System.out.println(str);
        }

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);

        for (Integer i : intList) {
            System.out.println(i);
        }

        Integer g = 5;
        Integer h = 6;
        g += h;

        double ttt = g.doubleValue();
        int c = g.intValue();
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
