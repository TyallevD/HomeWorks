package JavaBackend.HomeWork1.AbstractFabricExample.ComputerFactory;


import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.GamerComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.HomeComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.OfficeComputer;

public interface ComputerFactory {
    OfficeComputer createOfficeComputer();

    GamerComputer createGamerComputer();

    HomeComputer createHomeComputer();
}