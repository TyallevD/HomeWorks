package JavaBackend.HomeWork1.FabricMethodExample.Creators;


import JavaBackend.HomeWork1.FabricMethodExample.Interface.Transport;
import JavaBackend.HomeWork1.FabricMethodExample.Transports.Bus;

public class BusCreator extends TransportCreator {
    @Override
    public Transport createTransport() {
        return new Bus();
    }
}
