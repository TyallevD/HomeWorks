package JavaBackend.HomeWork1.FabricMethodExample.TransportDrivers;

import JavaBackend.HomeWork1.FabricMethodExample.Interface.Transport;

public class TransportDriver {
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
