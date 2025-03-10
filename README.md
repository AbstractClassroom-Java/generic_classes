# GenericCalculator

## Overview
`GenericCalculator<T extends Number>` is a Java class that provides basic arithmetic operations (addition, subtraction, multiplication, and division) for numeric types using Java Generics. It allows performing calculations on different number types (`Integer`, `Double`, `Float`, etc.) while maintaining type safety.

## Features
- Supports arithmetic operations: **addition, subtraction, multiplication, and division**.
- Works with any type that extends `Number`.
- Uses `doubleValue()` to ensure precision in calculations.
- Handles division by zero with an exception.

## Why `Double` is Used Instead of `T`
Since `T` extends `Number`, Java provides methods like `intValue()`, `doubleValue()`, `floatValue()`, etc. However, using `T` directly in operations like `T + T` is not possible because Java Generics do not support primitive arithmetic. Instead, **all operations are performed using `doubleValue()`**, ensuring consistent precision and avoiding type mismatch errors.

### **Key Reasons:**
1. **Generics do not support primitive types** → `T` cannot be used directly in arithmetic.
2. **`doubleValue()` provides a common numeric format** that can represent all `Number` subtypes.
3. **Ensures type safety and avoids casting issues** when performing calculations.
4. **Returning `Integer` would lose precision**, as floating-point calculations might be needed.
5. **Java Generics do not allow instantiation of `T`**, making it impossible to create new `T` objects for returning values directly.

While returning `Integer` could be achieved via explicit casting, it may introduce rounding errors and potential `ClassCastException`. Using `Double` ensures safe and precise calculations for all numeric types.

### **Additional Considerations**
#### 1. **Arithmetic Operations on `T` Are Not Allowed**
Java **generics do not support primitive types**, meaning you can't perform direct arithmetic like `T + T`.
```java
public T add(T other) {
    return value + other;  // ❌ Compilation Error
}
```
Instead, `doubleValue()` is used as a common numeric format for safe calculations:
```java
public Double add(T other) {
    return value.doubleValue() + other.doubleValue(); // ✅ Works for all Number types
}
```

#### 2. **`doubleValue()` Ensures Consistency Across Numeric Types**
Java provides multiple numeric conversions (`intValue()`, `floatValue()`, etc.), but `doubleValue()` is the most flexible.
```java
public Double multiply(T other) {
    return value.doubleValue() * other.doubleValue();
}
```
Using `doubleValue()` ensures calculations remain precise and work for all `Number` types.

#### 3. **Returning `Integer` Would Lead to Precision Loss**
If the method returned `Integer`, it would **truncate** decimal values, causing precision loss in calculations.
```java
public Integer add(T other) {
    return (int) (value.doubleValue() + other.doubleValue()); // ❌ Loses precision
}
```
Example:
```java
GenericCalculator<Double> doubleCalc = new GenericCalculator<>(5.5);
System.out.println(doubleCalc.add(1.2)); // Expected: 6.7, but would return 6
```

#### 4. **Instantiating `T` is Not Possible in Java Generics**
Java does not allow `new T()` due to **type erasure**.
```java
public T add(T other) {
    return new T(value.doubleValue() + other.doubleValue()); // ❌ Compilation Error
}
```
Since the exact type of `T` is unknown at runtime, using `doubleValue()` ensures a valid return type.

#### **Alternative Approach (Manual Casting to T, Risky)**
If you need the result to be the same type as `T`, you must manually cast it:
```java
public T add(T other) {
    Number result = value.doubleValue() + other.doubleValue();
    return (T) result;  // ⚠️ Unchecked cast (may fail for certain types)
}
```
However, this is **unsafe** and may cause `ClassCastException` at runtime.

## Usage Example
```java
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
```

## Exception Handling
- **Division by Zero:**
  ```java
  if (other.doubleValue() == 0) {
      throw new ArithmeticException("Division by zero is not allowed.");
  }
  ```
  This prevents undefined operations when dividing by zero.

## Limitations
- All calculations return `Double`, even when using `Integer` or `Float`, which may lead to slight precision loss in certain cases.
- Does not support `BigDecimal` or `BigInteger`.

## Conclusion
The `GenericCalculator` class is a flexible solution for performing arithmetic operations on different numeric types. By using `doubleValue()`, it ensures that all calculations are performed safely and consistently, avoiding issues related to Java's type system restrictions in Generics.
