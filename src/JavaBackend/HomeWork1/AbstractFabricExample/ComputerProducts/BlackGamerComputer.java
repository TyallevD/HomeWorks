package JavaBackend.HomeWork1.AbstractFabricExample.ComputerProducts;

import JavaBackend.HomeWork1.AbstractFabricExample.ComputerTypes.GamerComputer;

public class BlackGamerComputer implements GamerComputer {
    @Override
    public void playCoolGames(){
        System.out.println("Геймер играет на черном компьютере");
    }
}
