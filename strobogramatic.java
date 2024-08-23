import java.util.Scanner;

public class strobogramatic {
    public static boolean stroboCheck(String num) {
        for (int i = 0; i < (num.length() / 2) + 1; i++) {
            int thing = num.length() - i - 1;
            if (num.charAt(i) == '0' && num.charAt(thing) != '0') {
                return false;
            } else if (num.charAt(i) == '1' && num.charAt(thing) != '1') {
                return false;
            } else if (num.charAt(i) == '6' && num.charAt(thing) != '9') {
                return false;
            } else if (num.charAt(i) == '8' && num.charAt(thing) != '8') {
                return false;
            } else if (num.charAt(i) == '9' && num.charAt(thing) != '6') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number ");
        String num = in.next();
        System.out.println(stroboCheck(num));
        in.close();
    }
}
