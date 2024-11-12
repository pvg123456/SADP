
class Volt {
    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }
}

class Socket {
    public Volt getVolt() {
        return new Volt(120); 
    }
}

interface SocketAdapter {
    Volt get3Volt();
    Volt get12Volt();
    Volt get120Volt();
}


class SocketClassAdapterImpl extends Socket implements SocketAdapter {

    @Override
    public Volt get3Volt() {
        return convertVolt(getVolt(), 40);
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(getVolt(), 10); 
    }

    @Override
    public Volt get120Volt() {
        return getVolt(); 
    }

    private Volt convertVolt(Volt v, int divider) {
        return new Volt(v.getVolts() / divider);
    }
}

public class Slip_13 {

    public static void main(String[] args) {
        SocketAdapter socketAdapter = new SocketClassAdapterImpl();

        Volt v3 = socketAdapter.get3Volt();
        System.out.println("3 volts using Class Adapter: " + v3.getVolts() + "V");

        Volt v12 = socketAdapter.get12Volt();
        System.out.println("12 volts using Class Adapter: " + v12.getVolts() + "V");

        Volt v120 = socketAdapter.get120Volt();
        System.out.println("120 volts using Class Adapter: " + v120.getVolts() + "V");
    }
}
