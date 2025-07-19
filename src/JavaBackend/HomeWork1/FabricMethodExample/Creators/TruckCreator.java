package JavaBackend.HomeWork1.FabricMethodExample.Creators;

import JavaBackend.HomeWork1.FabricMethodExample.Interface.Transport;
import JavaBackend.HomeWork1.FabricMethodExample.Transports.Truck;


public class TruckCreator extends TransportCreator {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
