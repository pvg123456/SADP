
interface FlyBehavior {
    void fly();
}

interface QuackBehavior {
    void quack();
}

class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Flying with wings!");
    }
}

class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly!");
    }
}

class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quacking loudly!");
    }
}

class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("... (Silence)");
    }
}

abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks can swim!");
    }

    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }

    public abstract void display();
}

class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings(); 
        quackBehavior = new Quack();      
    }

    @Override
    public void display() {
        System.out.println("I'm a Mallard Duck!");
    }
}

class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay(); 
        quackBehavior = new MuteQuack(); 
    }

    @Override
    public void display() {
        System.out.println("I'm a Model Duck!");
    }
}


public class Slip_10 {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();
        mallard.swim();

        System.out.println("\n--- Changing behaviors ---");

        mallard.setFlyBehavior(new FlyNoWay());
        mallard.setQuackBehavior(new MuteQuack());
        mallard.performFly();  
        mallard.performQuack(); 

        System.out.println("\n--- Model Duck ---");

        Duck model = new ModelDuck();
        model.display();
        model.performFly();
        model.performQuack();
        model.swim();
    }
}
