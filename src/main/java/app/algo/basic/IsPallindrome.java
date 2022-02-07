package app.algo.basic;

public class IsPallindrome {
    static boolean solution(String inputString) {

        if (inputString.length() == 1) {
            return true;
        } else if (inputString.length() == 2) {
            return inputString.charAt(0) == inputString.charAt(1);
        } else {
            int mid = inputString.length() / 2;
            int i, j;

            if (inputString.length() % 2 == 0) {
                i = mid;
                j = mid + 1;
            } else {
                i = mid;
                j = mid;
            }
            while (i != 0 && j != inputString.length()) {
                if (inputString.charAt(i) != inputString.charAt(j)) {
                    return false;
                }
                i--;
                j++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("hlbeeykoqqqqokyeeblh"));
    }
}
