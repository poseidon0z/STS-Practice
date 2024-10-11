import java.util.Scanner;;

public class binaryPallindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number: ");
        String num = Integer.toBinaryString(in.nextInt());
        int i = 0;
        int j = num.length() - 1;

        boolean answer = true;

        while (i < j) {
            if (num.charAt(i) != num.charAt(j)) {
                answer = false;
                break;
            }
            i++;
            j--;
        }

        System.out.println(answer ? "The number is pallindrome" : "The number is not a pallindrome");
        in.close();
    }
}
