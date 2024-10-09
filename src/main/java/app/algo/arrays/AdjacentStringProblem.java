package app.algo.arrays;

import java.util.ArrayList;
import java.util.List;

public class AdjacentStringProblem {

    public void solve(char[] input) {

        int start = 0;
        int next = 1;
        var result = new ArrayList<>();
        while (start < input.length && next < input.length) {
            char startChar = input[start];
            char nextChar = input[next];
            if(nextChar== startChar + 1) {
                result.add(
                        String.format("%s%s", startChar, nextChar)
                );
                start = next;
                next = next + 1;
            } else if (nextChar == startChar - 1) {
                int temp = next;
                next = start;
                start = temp;
            } else {
                start = next;
                next = next + 1;
            }

            if(next == input.length && start < input.length) {
                start = start + 1;
                next = start + 1;
            }
        }
        result.forEach(System.out::println);
    }

    public static void main(String[] args) {
        var problem = new AdjacentStringProblem();
        problem.solve(new char[]{'a', 'b', 'd', 'q', 'e','p', 'c', 's'});
    }
}
