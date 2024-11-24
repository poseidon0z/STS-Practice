import java.util.Scanner;

public class boothsAlgorithm {

    // Function to perform multiplication using Booth's Algorithm
    public int multiply(int multiplicand, int multiplier) {
        int[] A = new int[9]; // Accumulator (8 bits + 1 for extra space)
        int[] S = new int[9]; // Negative of multiplicand
        int[] P = new int[9]; // Accumulator + Multiplier (8 bits + extra bit)

        // Populate binary representations of multiplicand and multiplier
        int[] m = binary(multiplicand, 4);
        int[] mNeg = binary(-multiplicand, 4);
        int[] r = binary(multiplier, 4);

        // Initialize A, S, and P
        for (int i = 0; i < 4; i++) {
            A[i] = m[i];
            S[i] = mNeg[i];
            P[i + 4] = r[i];
        }

        // Display initial values
        display(A, 'A');
        display(S, 'S');
        display(P, 'P');

        // Perform Booth's algorithm
        for (int i = 0; i < 4; i++) {
            if (P[7] == 0 && P[8] == 1) {
                add(P, A); // P = P + A
            } else if (P[7] == 1 && P[8] == 0) {
                add(P, S); // P = P + S
            }
            rightShift(P);
            display(P, 'P');
        }

        // Return the final decimal result from the binary array P
        return getDecimal(P);
    }

    // Function to convert an integer to its binary form (4 bits for simplicity)
    private int[] binary(int n, int bits) {
        int[] bin = new int[bits];
        int ctr = bits - 1;
        int num = n < 0 ? (int) Math.pow(2, bits) + n : n; // Two's complement for negative numbers
        while (num != 0 && ctr >= 0) {
            bin[ctr--] = num % 2;
            num /= 2;
        }
        return bin;
    }

    // Function to add two binary arrays and store the result in the first array
    private void add(int[] P, int[] operand) {
        int carry = 0;
        for (int i = 8; i >= 0; i--) {
            int sum = P[i] + operand[i] + carry;
            P[i] = sum % 2;
            carry = sum / 2;
        }
    }

    // Function to right shift the binary array (with sign extension)
    private void rightShift(int[] P) {
        for (int i = 8; i > 0; i--) {
            P[i] = P[i - 1];
        }
        P[0] = P[1]; // Sign extension
    }

    // Function to display a binary array with a label
    private void display(int[] array, char label) {
        System.out.print("\n" + label + " : ");
        for (int i = 0; i < array.length; i++) {
            if (i == 4)
                System.out.print(" "); // Add space between sections
            System.out.print(array[i]);
        }
    }

    // Function to convert a binary array to its decimal value
    private int getDecimal(int[] binary) {
        int value = 0;
        int base = 1;
        for (int i = 7; i >= 0; i--) {
            value += binary[i] * base;
            base *= 2;
        }
        // Check if the result is negative (in two's complement)
        if (binary[0] == 1) {
            value -= 256; // Adjust for 8-bit two's complement
        }
        return value;
    }

    // Main function to get input from the user and perform multiplication
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boothsAlgorithm multiplier = new boothsAlgorithm();

        System.out.println("Enter two integers to multiply:");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        int result = multiplier.multiply(n1, n2);
        System.out.println("\nResult: " + n1 + " * " + n2 + " = " + result);
        scanner.close();
    }
}