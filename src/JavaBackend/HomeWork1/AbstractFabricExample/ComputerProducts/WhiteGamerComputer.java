package JavaBackend.HomeWork1.AbstractFabricExample.ComputerProducts;

import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.GamerComputer;

public class WhiteGamerComputer implements GamerComputer {
    @Override
    public void playCoolGames() {
        System.out.println("Геймер играет на белом компьютере");
    }
}