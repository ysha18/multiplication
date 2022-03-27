package strategy.test.duckExample;

public class FlyNoWay implements FlyBehavior{

  @Override
  public void fly() {
    System.out.println("No flying");
  }
}
