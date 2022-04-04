package cryptoTrader.utils;

import java.util.HashMap;

/**
 * A strategy that the broker can use
 * @author Nathan Chan & Nick Barrie
 */
public class Buy_ADA implements Strategy{
    private String name = "Buy_ADA";

    /**
     * @param broker the name of the broker
     * @param coins the coins the broker is interested in
     * @param coin_price the map of coins and their prices
	 * @param date the date of the action
	 * @return Trade object that is stored in the database
     */
    public Trade trade(String broker, String[] coins, HashMap<String,Double> coin_price, String date) {
    	//buy 100 ADA if its less than or equal to $2 and the price of ETH is less that $4,500
        double ADAprice = coin_price.get("ADA");
        double ETHprice = coin_price.get("ETH");
    	if(ADAprice > 2 && ETHprice < 4500) {
    		TradeInterface tInterface = new TradeInterface();
            Trade trade = tInterface.createTrade(broker, name, "ADA", "buy", 400, ADAprice, date);
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
