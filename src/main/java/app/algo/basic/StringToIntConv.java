package app.algo.basic;

public class StringToIntConv {
    public static int solve(String s) {
        int res = 0;
        int index = 0;
        int sign = 0, n = s.length();
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index < s.length() && s.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < s.length() && s.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "  +1323212332";
        int res = solve(s);
        System.out.println(res);
    }
}
