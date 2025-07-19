package JavaBackend.HomeWork1.FabricMethodExample.Transports;

import JavaBackend.HomeWork1.FabricMethodExample.Interface.Transport;

public class Truck implements Transport {
    @Override
    public void ride() {
        System.out.println("Truck riding");
    }
}
