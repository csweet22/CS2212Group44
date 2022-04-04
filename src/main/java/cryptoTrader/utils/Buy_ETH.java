package cryptoTrader.utils;

import java.util.HashMap;

/**
 * A strategy that the broker can use
 * @author Nathan Chan & Nick Barrie
 */
public class Buy_ETH implements Strategy{
    private String name = "Buy_ETH";

    /**
     * @param broker the name of the broker
     * @param coins the coins the broker is interested in
     * @param coin_price the map of coins and their prices
	 * @param date the date of the action
	 * @return Trade object that is stored in the database
     */
    public Trade trade(String broker, String[] coins, HashMap<String,Double> coin_price, String date)  {
       //buy 5 ETH if its above 4500
       double ETHPrice = coin_price.get("ETH");
       if(ETHPrice > 4500) {
           TradeInterface tInterface = new TradeInterface();//create a trade interface
           Trade trade = tInterface.createTrade(broker, name, "SOL", "buy", 100, ETHPrice, date);//create the trade
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
