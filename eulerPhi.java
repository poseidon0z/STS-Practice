class eulerPhi {
    static int phiFinder(int val) {
        int answer = val;

        for (int i = 2; i * i <= val; i++) {
            if (val % i == 0) {
                while (val % i == 0) {
                    val /= i;
                }
                answer -= answer / i;
            }
        }
        if (val > 1) {
            answer -= answer / val;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(phiFinder(100));
    }
}
