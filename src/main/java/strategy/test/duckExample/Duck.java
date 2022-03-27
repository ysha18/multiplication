package strategy.test.duckExample;

public abstract class Duck {

  FlyBehavior flyBehavior;
 QuackBehavior quackBehavior;

  public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
    this.flyBehavior = flyBehavior;
    this.quackBehavior = quackBehavior;
  }

  public FlyBehavior getFlyBehavior() {
    return flyBehavior;
  }
  // change behavior
  public Duck setFlyBehavior(FlyBehavior flyBehavior) {
    this.flyBehavior = flyBehavior;
    return this;
  }

  public void performFly(){
    this.flyBehavior.fly();
  }

  public void performQuack(){
    quackBehavior.quack();
  }


  public Duck setQuackBehavior(QuackBehavior quackBehavior) {
    this.quackBehavior = quackBehavior;
    return this;
  }

  public  void swim() {
    System.out.println("All ducks swim");
  }
  public abstract void display();

}
