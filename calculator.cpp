#include <iostream>

// Template for basic arithmetic operations
template <typename T>
class Calculator {
public:
    static T add(T a, T b) {
        return a + b;
    }

    static T subtract(T a, T b) {
        return a - b;
    }

    static T multiply(T a, T b) {
        return a * b;
    }

    static T divide(T a, T b) {
        if (b == 0) {
            throw std::runtime_error("Division by zero error");
        }
        return a / b;
    }
};

int main() {
    // Example usage with int
    std::cout << "Addition: " << Calculator<int>::add(10, 5) << std::endl;
    std::cout << "Subtraction: " << Calculator<int>::subtract(10, 5) << std::endl;
    std::cout << "Multiplication: " << Calculator<int>::multiply(10, 5) << std::endl;
    std::cout << "Division: " << Calculator<int>::divide(10, 5) << std::endl;
    
    // Example usage with double
    std::cout << "Addition: " << Calculator<double>::add(10.5, 5.2) << std::endl;
    std::cout << "Subtraction: " << Calculator<double>::subtract(10.5, 5.2) << std::endl;
    std::cout << "Multiplication: " << Calculator<double>::multiply(10.5, 5.2) << std::endl;
    std::cout << "Division: " << Calculator<double>::divide(10.5, 5.2) << std::endl;
    
    return 0;
}
