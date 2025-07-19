package JavaBackend.HomeWork1.FabricMethodExample.Creators;

import JavaBackend.HomeWork1.FabricMethodExample.Interface.Transport;
import JavaBackend.HomeWork1.FabricMethodExample.Transports.Car;

public class CarCreator extends TransportCreator {
    @Override
    public Transport createTransport() {
        return new Car();
    }
}
