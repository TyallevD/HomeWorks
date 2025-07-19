package JavaBackend.HomeWork1.AbstractFabricExample.ComputerProducts;

import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.HomeComputer;

public class WhiteHomeComputer implements HomeComputer {
    @Override
    public void serfInternet() {
        System.out.println("Пользователь серфит в интернете на белом компьютере");
    }
}