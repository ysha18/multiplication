package strategy.test.duckExample;

public class RubberDuck extends Duck{

  public RubberDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
    super(flyBehavior, quackBehavior);
  }

  @Override
  public void display() {
    System.out.println("You know, in the bathtub");
  }
}
