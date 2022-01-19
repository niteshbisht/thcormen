package app.core.multipleinheritancetest;

class Horse {
//  public String identifyMyself() {
//    return "I am a horse.";
//  }
}
interface Flyer {
  default public String identifyMyself() {
    return "I am able to fly.";
  }
}
interface Mythical {
  default public String identifyMyself() {
    return "I am a mythical creature.";
  }
}

interface Animal {
  default public String identifyMyself() {
    return "I am an animal.";
  }
}
interface EggLayer extends Animal {
  default public String identifyMyself() {
    return "I am able to lay eggs.";
  }
}
interface FireBreather extends EggLayer{ }

public class Pegasus implements  FireBreather {
  public static void main(String... args) {
    Pegasus myApp = new Pegasus();
    System.out.println(myApp.identifyMyself());
  }
}
