package cryptoTrader.utils;

import java.util.HashMap;

/**
 * A strategy that the broker can use
 * @author Nathan Chan & Nick Barrie
 */
public class DummyA implements Strategy{
    private String name = "Dummy-Strategy-A";

    /**
     * @param broker the name of the broker
     * @param coins the coins the broker is interested in
     * @param coin_price the map of coins and their prices
	 * @param date the date of the action
	 * @return Trade object that is stored in the database
     */
    public Trade trade(String broker, String[] coins, HashMap<String,Double> coin_price, String date) {
    	//buy ETH if its more than 1,000
        double price = coin_price.get("ETH");
    	if(price > 1000) {
    		TradeInterface tInterface = new TradeInterface();
            Trade trade = tInterface.createTrade(broker, name, "ETH", "buy", 400, price, date);
            return trade;
    	}
        return null;
    }

    /**
     * @return the name of the strategy
     */
    public String getName() {
        return name;
    }
    
}
