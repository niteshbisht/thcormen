package app.algo.basic.hackerrank;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FizzBuzzProblem {
    public void solve(int n) {
        int i = 1;
        while (i <= n) {
            final boolean divBy3 = i % 3 == 0;
            final boolean divBy5 = i % 5 == 0;
            String op =
                    divBy3 && divBy5
                            ? "FizzBuzz"
                            : divBy3 && !divBy5 ? "Fizz" : divBy5 && !divBy3 ? "Buzz" : String.valueOf(i);
            log.info("value for i = {} => {}", i, op);
            i++;
        }
    }
}
