import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int number);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int number;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setNumber(int number) {
        this.number = number;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(number);
        }
    }
}

class BinaryObserver implements Observer {
    @Override
    public void update(int number) {
        System.out.println("Binary: " + Integer.toBinaryString(number));
    }
}

class OctalObserver implements Observer {
    @Override
    public void update(int number) {
        System.out.println("Octal: " + Integer.toOctalString(number));
    }
}

class HexadecimalObserver implements Observer {
    @Override
    public void update(int number) {
        System.out.println("Hexadecimal: " + Integer.toHexString(number).toUpperCase());
    }
}

public class Slip_16 {
    public static void main(String[] args) {
        Subject subject = new Subject();


        subject.addObserver(new BinaryObserver());
        subject.addObserver(new OctalObserver());
        subject.addObserver(new HexadecimalObserver());

        System.out.println("Converting the number 10:");
        subject.setNumber(10);

        System.out.println("\nConverting the number 30:");
        subject.setNumber(30);

        System.out.println("\nConverting the number 100:");
        subject.setNumber(100);
    }
}
