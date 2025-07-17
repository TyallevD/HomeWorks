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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
public class FabricMethodExample {
    static final String CAR_DRIVER = "car driver";
    static final String BUS_DRIVER = "bus driver";
    static final String TRUCK_DRIVER = "truck driver";

    public static void main(String[] args) {

        //Создаём водителя автомобиля (Car)
        TransportDriver transportDriver1 = new TransportDriver();
        //Сажаем водителя в автомобиль подходящий ему по типу (через метод getTransportByDriverType)
        transportDriver1.setTransport(getTransportByDriverType(CAR_DRIVER));
        //Водитель едет на подходящем ему транспорте
        transportDriver1.getTransport().ride();

        //Создаём водителя автобуса (Bus)
        TransportDriver transportDriver2 = new TransportDriver();
        //Сажаем водителя в автомобиль подходящий ему по типу (через метод getTransportByDriverType)
        transportDriver2.setTransport(getTransportByDriverType(BUS_DRIVER));
        //Водитель едет на подходящем ему транспорте
        transportDriver2.getTransport().ride();

        //Создаём водителя грузовика (Truck)
        TransportDriver transportDriver3 = new TransportDriver();
        //Сажаем водителя в автомобиль подходящий ему по типу (через метод getTransportByDriverType)
        transportDriver3.setTransport(getTransportByDriverType(TRUCK_DRIVER));
        //Водитель едет на подходящем ему транспорте
        transportDriver3.getTransport().ride();

    }

    static Transport getTransportByDriverType(String driverType) {
        return switch (driverType) {
            case CAR_DRIVER -> new CarCreator().createTransport();
            case BUS_DRIVER -> new BusCreator().createTransport();
            case TRUCK_DRIVER -> new TruckCreator().createTransport();
            default -> null;
        };
    }
}

//todo надо б подразобраться, правильно ли я понял эту конструкцию
