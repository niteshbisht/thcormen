package app.algo.easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PowerOfTwoCompute {
  public static void main(String[] args) {
    PowerOfTwoCompute pc = new PowerOfTwoCompute();
    log.info("Power of 2 = {}", pc.isPowerOfTwo(32));
  }

  public boolean isPowerOfTwo(int n) {
    return n > 0 && ((n & n - 1) == 0);
  }
}
