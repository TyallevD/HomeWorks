package JavaBackend.HomeWork1.FabricMethodExample.Transports;

import JavaBackend.HomeWork1.FabricMethodExample.Interface.Transport;

public class Car implements Transport {

    @Override
    public void ride() {
        System.out.println("Car riding");
    }
}
