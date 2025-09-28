package app.core.concurex;

import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class Receiver implements Runnable {
  private Data load;

  @Override
  public void run() {
    for (String msg = load.receive(); !"End".equalsIgnoreCase(msg); msg = load.receive()) {
      System.out.println(msg);
      try {
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Thread Interrupted");
      }
    }
  }
}

@AllArgsConstructor
class Sender implements Runnable {
  private Data data;

  public void run() {

    String packets[] = {"First packet", "Second packet", "Third packet", "Fourth packet", "End"};

    for (String packet : packets) {
      data.send(packet);
      // Thread.sleep() to mimic heavy server-side processing
      try {
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Thread Interrupted");
      }
    }
  }
}

class Data {
  private String packet;
  private boolean transfer = true;

  // True if receiver should wait
  // False if sender should wait
  public synchronized String receive() {
    while (transfer) {
      try {
        wait();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Thread Interrupted");
      }
    }
    transfer = true;
    notifyAll();
    return packet;
  }

  public synchronized void send(String packet) {
    while (!transfer) {
      try {
        wait();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Thread Interrupted");
      }
    }
    transfer = false;
    this.packet = packet;
    notifyAll();
  }
}

public class WaitNotifyExample {
  public static void main(String[] args) {
    Data data = new Data();
    Thread sender = new Thread(new Sender(data));
    Thread receiver = new Thread(new Receiver(data));
    sender.start();
    receiver.start();
  }
}
