package JavaBackend.HomeWork1.AbstractFabricExample;

import JavaBackend.HomeWork1.AbstractFabricExample.ComputerFactory.Computer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.GamerComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.HomeComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.OfficeComputer;

public class ComputerUsage {
    private GamerComputer gamerComputer;
    private HomeComputer homeComputer;
    private OfficeComputer officeComputer;

    public ComputerUsage(Computer computer) {
        gamerComputer = computer.createGamerComputer();
        homeComputer = computer.createHomeComputer();
        officeComputer = computer.createOfficeComputer();
    }

    public void showUsage() {
        gamerComputer.playCoolGames();
        homeComputer.serfInternet();
        officeComputer.doWork();
    }
}
