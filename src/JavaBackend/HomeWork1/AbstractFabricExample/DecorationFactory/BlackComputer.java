package JavaBackend.HomeWork1.AbstractFabricExample.DecorationFactory;

import JavaBackend.HomeWork1.AbstractFabricExample.ComputerFactory.ComputerFactory;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerProducts.BlackGamerComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerProducts.BlackHomeComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerProducts.BlackOfficeComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.GamerComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.HomeComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.OfficeComputer;

public class BlackComputer implements ComputerFactory {
    @Override
    public OfficeComputer createOfficeComputer() {
        return new BlackOfficeComputer();
    }

    @Override
    public GamerComputer createGamerComputer() {
        return new BlackGamerComputer();
    }

    @Override
    public HomeComputer createHomeComputer() {
        return new BlackHomeComputer();
    }
}