package JavaBackend.HomeWork3.FlyweightExample;

public final class ConcreteFlyweight implements SymbolFlyweight {
    private final String symbol;
    private final String symbolStyle;

    public ConcreteFlyweight(String symbol, String symbolStyle) {
        this.symbol = symbol;
        this.symbolStyle = symbolStyle;
    }

    @Override
    public void drawSymbol(PositionExternalContext position) {
        System.out.println("Отображаем символ: \"" + symbol
                + "\", в стиле: \"" + symbolStyle
                + "\", в координатах: x и y, как \"" + position.getX() + ":" + position.getY()+"\"");
    }
}
