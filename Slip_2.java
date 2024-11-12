class Singleton {
    private static volatile Singleton uniqueInstance;

    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {  
            synchronized (Singleton.class) { 
                if (uniqueInstance == null) {  
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}
public class Slip_2 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton singleton1 = Singleton.getInstance();
                singleton1.showMessage();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton singleton2 = Singleton.getInstance();
                singleton2.showMessage();
            }
        });

        thread1.start();
        thread2.start();
    }
}