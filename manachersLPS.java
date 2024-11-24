import java.util.Scanner;

class manachersLPS {
    private static String dollarify(String text) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i = 0; i < text.length(); i++) {
            sb.append(text.charAt(i));
            sb.append('$');
        }
        return sb.toString();
    }

    private static String manachers(String text) {
        String dollaredText = dollarify(text);
        int N = dollaredText.length();

        if (N == 0) {
            return "";
        }

        int right = 0;
        int center = 0;
        int bestCenter = 0;
        int lengths[] = new int[N];

        for (int i = 0; i < N; i++) {
            int imirror = center - (i - center);

            if (i < right) {
                lengths[i] = Math.min(right - i, lengths[imirror]);
            }

            int l = i - lengths[i] - 1;
            int r = i + lengths[i] + 1;

            while (l >= 0 && r < N && dollaredText.charAt(l) == dollaredText.charAt(r)) {
                lengths[i]++;
                l--;
                r++;
            }

            if (i + lengths[i] > right) {
                right = i + lengths[i];
                center = i;
            }

            if (lengths[i] > lengths[bestCenter]) {
                bestCenter = i;
            }
        }

        int start = (bestCenter - lengths[bestCenter]) / 2;
        String answer = text.substring(start, start + lengths[bestCenter]);

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the string to search for pallindromes in (in a single line): ");
        String text = in.nextLine();

        System.out.println(manachers(text));

        in.close();
    }
}