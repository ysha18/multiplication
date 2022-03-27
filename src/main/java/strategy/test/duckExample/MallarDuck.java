package strategy.test.duckExample;

public class MallarDuck extends Duck{

  public MallarDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
    super(flyBehavior, quackBehavior);
  }

  @Override
  public void display() {
    System.out.println("Display in a Mallar way");
  }
}
