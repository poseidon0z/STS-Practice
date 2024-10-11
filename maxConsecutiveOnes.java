import java.util.Scanner;

public class maxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number");
        char number[] = in.next().toCharArray();

        System.out.println("Enter the number of flips: ");
        int flips = in.nextInt();

        int maxOnes = 0;
        int replacements = 0;
        int start = 0;

        for (int end = 0; end < number.length; end++) {
            if (number[end] == '0') {
                replacements++;
            }
            while (replacements > flips) {
                if (number[start] == '0') {
                    replacements--;
                }
                start++;
            }
            maxOnes = Math.max(maxOnes, end - start + 1);
        }

        System.out.println(maxOnes);
        in.close();
    }
}
