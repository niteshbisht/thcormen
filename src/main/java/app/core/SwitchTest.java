package app.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SwitchTest {
  public static void main(String[] args) {
    List<Integer> test = IntStream.range(1, 200).boxed().collect(Collectors.toList());
    Stream<Integer> parallel = test.stream().parallel();
    System.out.println("parallel");
  }
}
