package day1;

import static day1.StringToInteger.States.*;

public class StringToInteger {
    static void processUsingStateMachine(String num) {
        // StateMachineCompute sm = new StateMachineCompute();
        // for (char c: num.toCharArray()) {

        // }
    }

    ;

    public static int myAtoi(String s) {
        int index = 0;
        while (s.charAt(index) == ' ') {
            index++;
        }

        boolean isNegative = s.charAt(index) == '-';
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            index++;
        }
        int endIndex = index;
        while (endIndex <= s.length() - 1 && s.charAt(endIndex) >= '0' && s.charAt(endIndex) <= '9') {
            endIndex++;
        }

        int res = 0;
        while (index < endIndex) {
            int val = s.charAt(index) - '0';
            if (res * 10 < Integer.MAX_VALUE) {
                res = res * 10 + val;
            } else {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            index++;
        }
        return isNegative ? -1 * res : res;
    }

    public static void main(String[] args) {
        myAtoi("4193 with words");
    }

    void transition() {

    }

    enum States {
        q0,
        qspace,
        qdigit,
        qdead
    }

    static class StateMachineCompute {
        public States currentState;
        int res, sign;

        public StateMachineCompute() {
            this.currentState = q0;
            this.res = 0;
            this.sign = 1;
        }

        void toSpace() {
            this.currentState = qspace;
        }

        void toDigit(int digit) {
            this.currentState = qdigit;
            appendDigit(digit);
        }

        void toStateDead() {
            this.currentState = qdead;
        }

        void appendDigit(int val) {
            if (res > Integer.MAX_VALUE / 10
                    || (res == Integer.MAX_VALUE / 10 && val > Integer.MAX_VALUE % 10)) {
                // overflow
                if (sign == 1) {
                    res = Integer.MAX_VALUE;
                } else {
                    res = Integer.MIN_VALUE;
                }
                toStateDead();
            } else {
                res = res * 10 + val;
            }
        }
    }
}
