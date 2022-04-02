package cryptoTrader.utils;

public class DummyA implements Strategy{
    private String name = "Dummy-Strategy-A";

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
