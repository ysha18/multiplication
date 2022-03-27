package strategy.test.duckExample;

public class MuteQuack implements QuackBehavior{

  @Override
  public void quack() {
    System.out.println("No quacking");
  }
}
