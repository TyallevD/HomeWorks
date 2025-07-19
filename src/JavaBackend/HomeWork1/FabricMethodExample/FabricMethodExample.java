package JavaBackend.HomeWork1.FabricMethodExample;

import JavaBackend.HomeWork1.FabricMethodExample.Creators.BusCreator;
import JavaBackend.HomeWork1.FabricMethodExample.Creators.CarCreator;
import JavaBackend.HomeWork1.FabricMethodExample.Creators.TruckCreator;
import JavaBackend.HomeWork1.FabricMethodExample.TransportDrivers.TransportDriver;
import JavaBackend.HomeWork1.FabricMethodExample.Interface.Transport;

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
    //метод для получения транспорта по типу водителя
    static Transport getTransportByDriverType(String driverType) {
        return switch (driverType) {
            case CAR_DRIVER -> new CarCreator().createTransport();
            case BUS_DRIVER -> new BusCreator().createTransport();
            case TRUCK_DRIVER -> new TruckCreator().createTransport();
            default -> null;
        };
    }
}
