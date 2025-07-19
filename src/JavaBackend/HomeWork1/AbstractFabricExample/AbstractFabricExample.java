package JavaBackend.HomeWork1.AbstractFabricExample;

import JavaBackend.HomeWork1.AbstractFabricExample.ComputerFactory.ComputerFactory;
import JavaBackend.HomeWork1.AbstractFabricExample.DecorationFactory.BlackComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.DecorationFactory.RGBComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.DecorationFactory.WhiteComputer;

public class AbstractFabricExample {
    public static void main(String[] args) {
        ComputerFactory computerFactory1 = new BlackComputer();
        ComputerUsage computerUsage1 = new ComputerUsage(computerFactory1);
        computerUsage1.showUsage();

        ComputerFactory computerFactory2 = new RGBComputer();
        ComputerUsage computerUsage2 = new ComputerUsage(computerFactory2);
        computerUsage2.showUsage();

        ComputerFactory computerFactory3 = new WhiteComputer();
        ComputerUsage computerUsage3 = new ComputerUsage(computerFactory3);
        computerUsage3.showUsage();
    }
}