package JavaBackend.HomeWork1.AbstractFabricExample.DecorationFactory;

import JavaBackend.HomeWork1.AbstractFabricExample.ComputerFactory.ComputerFactory;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerProducts.*;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.GamerComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.HomeComputer;
import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.OfficeComputer;

public class WhiteComputer implements ComputerFactory {
    @Override
    public OfficeComputer createOfficeComputer() {
        return new WhiteOfficeComputer();
    }

    @Override
    public GamerComputer createGamerComputer() {
        return new WhiteGamerComputer();
    }

    @Override
    public HomeComputer createHomeComputer() {
        return new WhiteHomeComputer();
    }
}