package cryptoTrader.utils;

import java.util.HashMap;

public class DummyB implements Strategy{
    private String name = "Dummy-Strategy-B";

    @Override
    public Trade trade(String broker, String[] coins, HashMap<String,Double> coin_price, String date) {
        	//buy BTC if ADA is more than $1
            double bitPrice = coin_price.get("BTC");
            double adaPrice = coin_price.get("ADA");
            if(adaPrice > 1) {
                TradeInterface tInterface = new TradeInterface();
                System.out.println("the price in dummy " + adaPrice);
                Trade trade = tInterface.createTrade(broker, name, "BTC", "buy", 340, bitPrice, date);
                return trade;
            }
            return null;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
