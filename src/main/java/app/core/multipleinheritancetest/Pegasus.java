package app.core.multipleinheritancetest;

interface Flyer {
  public default String identifyMyself() {
    return "I am able to fly.";
  }
}

interface Mythical {
  public default String identifyMyself() {
    return "I am a mythical creature.";
  }
}

interface Animal {
  public default String identifyMyself() {
    return "I am an animal.";
  }
}

interface EggLayer extends Animal {
  public default String identifyMyself() {
    return "I am able to lay eggs.";
  }
}

interface FireBreather extends EggLayer {}

class Horse {
  //  public String identifyMyself() {
  //    return "I am a horse.";
  //  }
}

public class Pegasus implements FireBreather {
  public static void main(String... args) {
    Pegasus myApp = new Pegasus();
    System.out.println(myApp.identifyMyself());
  }
}
