package JavaBackend.HomeWork3.FlyweightExample;

public class FlyweightExample {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        factory.getSymbol("h", "Arial")
                .drawSymbol(new PositionExternalContext(0, 0));
        factory.getSymbol("e", "Arial")
                .drawSymbol(new PositionExternalContext(0, 1));
        factory.getSymbol("l", "Arial")
                .drawSymbol(new PositionExternalContext(0, 2));
        factory.getSymbol("l", "Arial")
                .drawSymbol(new PositionExternalContext(0, 3));
        factory.getSymbol("o", "Arial")
                .drawSymbol(new PositionExternalContext(0, 4));
        System.out.println();
    }
}
