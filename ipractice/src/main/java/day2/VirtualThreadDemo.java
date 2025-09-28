package day2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class VirtualThreadDemo {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // Using Thread.ofVirtual()
    //        Thread virtualThread = Thread.ofVirtual().start(() -> {
    //            System.out.println("Running in a virtual thread");
    //        });

    // Using Executors.newVirtualThreadPerTaskExecutor()
    try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
      List<Future<?>> futureList = new ArrayList<>();
      for (int i = 0; i < Integer.MAX_VALUE; i++) {

        Future<?> future =
            executor.submit(
                () -> {
                  System.out.println("Running in a virtual thread using executor");
                });
        futureList.add(future);
      }

      for (Future<?> future : futureList) {
        future.get();
      }
    }
  }
}
