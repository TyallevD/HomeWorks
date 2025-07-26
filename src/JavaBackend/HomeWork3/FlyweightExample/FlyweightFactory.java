package JavaBackend.HomeWork3.FlyweightExample;

import java.util.HashMap;

public class FlyweightFactory {
    static HashMap<String, SymbolFlyweight> hashMap = new HashMap<>();

    public SymbolFlyweight getSymbol(String symbol, String symbolStyle) {
        if (hashMap.get(symbol) == null) {
            hashMap.put(symbol, new ConcreteFlyweight(symbol, symbolStyle));
        }
        return hashMap.get(symbol);
    }
}
