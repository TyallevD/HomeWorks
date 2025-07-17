package JavaBackend.HomeWork1.FabricMethodExample;

interface Transport {
    void ride();
}

class Car implements Transport {

    @Override
    public void ride() {
        System.out.println("Car riding");
    }
}

class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Bus riding");
    }
}

class Truck implements Transport {
    @Override
    public void ride() {
        System.out.println("Truck riding");
    }
}

abstract class TransportCreator {
    public abstract Transport createTransport();
}

class CarCreator extends TransportCreator {
    @Override
    public Transport createTransport() {
        return new Car();
    }
}

class BusCreator extends TransportCreator {
    @Override
    public Transport createTransport() {
        return new Bus();
    }
}

class TruckCreator extends TransportCreator {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
class TransportDriver{
    private String driverName;
    private Transport transport;

    public TransportDriver() {
    }

    public TransportDriver(String driverName) {
        this.driverName = driverName;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public String getDriver() {
        return driverName;
    }

    public void setDriver(String driverName) {
        this.driverName = driverName;
    }
}
public class FarbicMethodExample {


    public static void main(String[] args) {

        String carDriver = "car driver";
        String busDriver = "bus driver";
        String truckDriver = "truck driver";

        TransportDriver transportDriver1 = new TransportDriver();
        transportDriver1.setTransport(getTransportByDriver(carDriver));
        transportDriver1.getTransport().ride();

        TransportDriver transportDriver2 = new TransportDriver();
        transportDriver2.setTransport(getTransportByDriver(busDriver));
        transportDriver2.getTransport().ride();

        TransportDriver transportDriver3 = new TransportDriver();
        transportDriver3.setTransport(getTransportByDriver(truckDriver));
        transportDriver2.getTransport().ride();
    }

    static Transport getTransportByDriver(String driver) {
        return switch (driver) {
            case "car driver" -> new CarCreator().createTransport();
            case "bus driver" -> new BusCreator().createTransport();
            case "truck driver" -> new TruckCreator().createTransport();
            default -> null;
        };
    }
}

//todo надо б подразобраться, правильно ли я понял эту конструкцию
