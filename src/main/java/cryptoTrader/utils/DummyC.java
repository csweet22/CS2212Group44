package cryptoTrader.utils;

public class DummyC implements Strategy{
    private String name = "Dummy-Strategy-C";

    @Override
    public Trade trade(String broker, String[] coins) {
        System.out.println("This strategy does nothing");
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
