package cryptoTrader.utils;

interface Strategy {
    public Trade trade(String broker, String[] coins);
    public String getName();
}
