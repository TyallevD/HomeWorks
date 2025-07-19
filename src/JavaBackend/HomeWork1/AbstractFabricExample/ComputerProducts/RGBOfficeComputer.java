package JavaBackend.HomeWork1.AbstractFabricExample.ComputerProducts;

import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.OfficeComputer;

public class RGBOfficeComputer implements OfficeComputer {
    @Override
    public void doWork() {
        System.out.println("Работник офиса выполняет задачи на компьютере с различной подсветкой");
    }
}