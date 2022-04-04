package cryptoTrader.utils;

import java.util.HashMap;
/**
 * A strategy that the broker can use
 * @author Nathan Chan & Nick Barrie
 */
public class Sell_ETH implements Strategy{
    private String name = "Sell_ETH";

     /**
     * @param broker the name of the broker
     * @param coins the coins the broker is interested in
     * @param coin_price the map of coins and their prices
	 * @param date the date of the action
	 * @return Trade object that is stored in the database
     */
    public Trade trade(String broker, String[] coins, HashMap<String,Double> coin_price, String date) {
        	//sell 1 ETH if its less than 4500
            double price = coin_price.get("ETH");
            if(price < 4500) {
                TradeInterface tInterface = new TradeInterface();
                Trade trade = tInterface.createTrade(broker, name, "ETH", "sell", 1, price, date);
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
