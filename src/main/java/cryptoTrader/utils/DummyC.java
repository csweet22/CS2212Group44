package cryptoTrader.utils;

import java.util.HashMap;

/**
 * A strategy that the broker can use
 * @author Nathan Chan & Nick Barrie
 */
public class DummyC implements Strategy{
    private String name = "Dummy-Strategy-C";

    /**
     * @param broker the name of the broker
     * @param coins the coins the broker is interested in
     * @param coin_price the map of coins and their prices
	 * @param date the date of the action
	 * @return Trade object that is stored in the database
     */
    public Trade trade(String broker, String[] coins, HashMap<String,Double> coin_price, String date)  {
       //buy 1000 SOL if ADA is above $1
       double adaPrice = coin_price.get("ADA");
       double solPrice = coin_price.get("SOL");
       if(adaPrice > 1) {
           TradeInterface tInterface = new TradeInterface();//create a trade interface
           Trade trade = tInterface.createTrade(broker, name, "SOL", "buy", 100, solPrice, date);//create the trade
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
