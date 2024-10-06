public class BitManipulationUtility {

    // Set a specific bit (set to 1)
    public static int setBit(int value, int position) {
        return value | (1 << position);
    }

    // Clear a specific bit (set to 0)
    public static int clearBit(int value, int position) {
        return value & ~(1 << position);
    }

    // Toggle a specific bit (flip its value)
    public static int toggleBit(int value, int position) {
        return value ^ (1 << position);
    }

    // Get the value of a specific bit (0 or 1)
    public static int getBit(int value, int position) {
        return (value >> position) & 1;
    }

    // Shift bits left (multiply by 2^n)
    public static int shiftLeft(int value, int positions) {
        return value << positions;
    }

    // Shift bits right (divide by 2^n)
    public static int shiftRight(int value, int positions) {
        return value >> positions;
    }

    // Convert an integer to its binary string representation
    public static String toBinaryString(int value) {
        return Integer.toBinaryString(value);
    }

    // Convert an integer to its hexadecimal string representation
    public static String toHexString(int value) {
        return Integer.toHexString(value);
    }

    // Add two binary numbers
    public static int add(int a, int b) {
        return a + b;
    }

    // Subtract two binary numbers
    public static int subtract(int a, int b) {
        return a - b;
    }

    // Multiply two binary numbers
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Divide two binary numbers
    public static int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }

    // Print the binary representation of a value
    public static void printBinary(int value) {
        System.out.println(Integer.toBinaryString(value));
    }
}

