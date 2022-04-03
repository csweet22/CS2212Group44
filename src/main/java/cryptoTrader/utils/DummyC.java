package cryptoTrader.utils;

import java.util.HashMap;

public class DummyC implements Strategy{
    private String name = "Dummy-Strategy-C";

    @Override
    public Trade trade(String broker, String[] coins, HashMap<String,Double> coin_price, String date)  {
       //buy 1000 SOL if ADA is above $1
       double adaPrice = coin_price.get("ADA");
       double solPrice = coin_price.get("SOL");
       if(adaPrice > 1) {
           TradeInterface tInterface = new TradeInterface();
           System.out.println("the price in dummy " + solPrice);
           Trade trade = tInterface.createTrade(broker, name, "SOL", "buy", 100, solPrice, date);
           return trade;
       }
       return null;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
