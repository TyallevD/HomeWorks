package JavaBackend.HomeWork1.AbstractFabricExample.DecorationFactory;

import JavaBackend.HomeWork1.AbstractFabricExample.ComputerFactory.ComputerFactory;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerProducts.RGBGamerComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerProducts.RGBHomeComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerProducts.RGBOfficeComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.GamerComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.HomeComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.OfficeComputer;

public class RGBComputer implements ComputerFactory {
    @Override
    public OfficeComputer createOfficeComputer() {
        return new RGBOfficeComputer();
    }

    public @Override
    GamerComputer createGamerComputer() {
        return new RGBGamerComputer();
    }

    public @Override
    HomeComputer createHomeComputer() {
        return new RGBHomeComputer();
    }
}