package io.github.nathanjrussell;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {public static void main(String[] args) {
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
