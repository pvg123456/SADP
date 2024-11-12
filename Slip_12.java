
interface Car {
    void assemble();  
}

class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Basic Car assembly completed.");
    }
}

abstract class CarDecorator implements Car {
    protected Car decoratedCar; 

    public CarDecorator(Car car) {
        this.decoratedCar = car;
    }

    public void assemble() {
        this.decoratedCar.assemble(); 
    }
}

class SportsCar extends CarDecorator {
    public SportsCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble(); 
        System.out.println("Adding features of Sports Car.");
    }
}

class LuxuryCar extends CarDecorator {
    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble(); 
        System.out.println("Adding features of Luxury Car.");
    }
}

public class Slip_12 {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        System.out.println("Sports Car:");
        sportsCar.assemble();  

        System.out.println("\n---");

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        System.out.println("Sports Luxury Car:");
        sportsLuxuryCar.assemble();  
    }
}
