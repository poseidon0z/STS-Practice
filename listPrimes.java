import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Thread;

class listPrimes {
    // Using 2 loops
    public static ArrayList<Integer> dualLoops(int max) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for (Integer i = 2; i < max; i++) {
            boolean flag = true;
            for (Integer j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                answer.add(i);
            }
        }

        return answer;
    }

    // Simple Seive
    public static ArrayList<Integer> simpleSeive(int max) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        boolean isPrime[] = new boolean[max + 1];

        for (Integer i = 0; i < max + 1; i++) {
            isPrime[i] = true;
        }

        for (Integer i = 2; i < Math.sqrt(max); i++) {
            if (isPrime[i]) {
                for (Integer j = i * 2; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (Integer i = 2; i < max + 1; i++) {
            if (isPrime[i]) {
                answer.add(i);
            }
        }

        return answer;
    }

    public static ArrayList<Integer> segmentedSeive(int max) {
        Integer root = (int) Math.ceil(Math.sqrt(max));
        ArrayList<Integer> primes = simpleSeive(root);

        Integer low = root;
        Integer high = 2 * root;

        while (low < max) {
            if (high > max) {
                high = max;
            }

            int length = high - low + 1;
            boolean isPrime[] = new boolean[length];

            for (Integer i = 0; i < length; i++) {
                isPrime[i] = true;
            }

            for (Integer prime : primes) {
                int start = (int) Math.ceil((double) low / prime) * prime;
                for (int i = start; i <= high; i += prime) {
                    isPrime[i - low] = false;
                }
            }

            for (Integer i = 0; i < length; i++) {
                if (isPrime[i]) {
                    primes.add(i + low);
                }
            }
            low += root;
            high += root;
        }
        return primes;
    }

    public static void incrementalSeive(int max) {
        Integer root = (int) Math.ceil(Math.sqrt(max));
        ArrayList<Integer> primes = simpleSeive(root);

        Integer low = root;
        Integer high = 2 * root;
        for (Integer i : primes) {
            System.out.print(i + " ");
        }

        while (true) {
            int length = high - low + 1;
            boolean isPrime[] = new boolean[length];

            for (Integer i = 0; i < length; i++) {
                isPrime[i] = true;
            }

            for (Integer prime : primes) {
                int start = (int) Math.ceil((double) low / prime) * prime;
                for (int i = start; i <= high; i += prime) {
                    isPrime[i - low] = false;
                }
            }

            for (Integer i = 0; i < length; i++) {
                if (isPrime[i]) {
                    primes.add(i + low);
                    System.out.print((i + low) + " ");
                }
            }
            low += root;
            high += root;

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void printArrayList(ArrayList<Integer> arr) {
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the max number: ");
        int max = in.nextInt();
        printArrayList(dualLoops(max));
        printArrayList(simpleSeive(max));
        printArrayList(segmentedSeive(max));
        incrementalSeive(max);
        in.close();
    }
}