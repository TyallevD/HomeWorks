package JavaBackend.HomeWork1.AbstractFabricExample;

import JavaBackend.HomeWork1.AbstractFabricExample.ComputerFactory.Computer;
import JavaBackend.HomeWork1.AbstractFabricExample.DecorationFactory.BlackComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.DecorationFactory.RGBComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.DecorationFactory.WhiteComputer;

public class AbstractFabricExample {
    public static void main(String[] args) {
        Computer computer1 = new BlackComputer();
        ComputerUsage computerUsage1 = new ComputerUsage(computer1);
        computerUsage1.showUsage();

        Computer computer2 = new RGBComputer();
        ComputerUsage computerUsage2 = new ComputerUsage(computer2);
        computerUsage2.showUsage();

        Computer computer3 = new WhiteComputer();
        ComputerUsage computerUsage3 = new ComputerUsage(computer3);
        computerUsage3.showUsage();
    }
}
