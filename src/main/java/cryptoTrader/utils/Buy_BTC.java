package cryptoTrader.utils;

import java.util.HashMap;

/**
 * A strategy that the broker can use
 * @author Nathan Chan & Nick Barrie
 */
public class Buy_BTC implements Strategy{
    private String name = "Buy_BTC";

    /**
     * @param broker the name of the broker
     * @param coins the coins the broker is interested in
     * @param coin_price the map of coins and their prices
	 * @param date the date of the action
	 * @return Trade object that is stored in the database
     */
    public Trade trade(String broker, String[] coins, HashMap<String,Double> coin_price, String date) {
    	//buy 3 BTC if its more than 50,000
        double price = coin_price.get("BTC");
    	if(price > 50000) {
    		TradeInterface tInterface = new TradeInterface();
            Trade trade = tInterface.createTrade(broker, name, "BTC", "buy", 3, price, date);
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
