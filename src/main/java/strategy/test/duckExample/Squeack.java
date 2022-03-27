package strategy.test.duckExample;

public class Squeack implements QuackBehavior{

  @Override
  public void quack() {
    System.out.println("Squeaking quack");
  }
}
