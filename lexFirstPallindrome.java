import java.util.Scanner;

public class lexFirstPallindrome {
    static boolean checkIfPallindrome(String val, int freq[]) {
        for (int i = 0; i < val.length(); i++) {
            freq[val.charAt(i) - 'a']++;
        }

        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                odd++;
            }
        }
        System.out.println("hello");

        if (odd > 1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String val = in.next();

        int freq[] = new int[26];

        if (!checkIfPallindrome(val, freq)) {
            System.out.println(-1);
            return;
        }

        String start = "", middle = "", end = "";

        for (int i = 0; i < 26; i++) {
            String current = String.valueOf((char) ('a' + i));

            start += current.repeat(freq[i] / 2);

            if (freq[i] % 2 != 0) {
                middle += current;
            }

            end = current.repeat(freq[i] / 2) + end;
        }

        System.out.println(start + middle + end);
        in.close();
    }
}
