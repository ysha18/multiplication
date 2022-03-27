package strategy.test.duckExample;

public class MainClassCode {

  public void code(){
    Duck mallar =  new MallarDuck(new FlyWithWings(), new Squeack());
    mallar.performFly();
    mallar.performQuack();
    mallar.setFlyBehavior(new FlyNoWay()).setQuackBehavior(new MuteQuack());
    mallar.performFly();
    mallar.performQuack();
  }
}
