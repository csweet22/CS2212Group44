package cryptoTrader.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

public class DummyA implements Strategy{
    private String name = "Dummy-Strategy-A";

    @Override
    public Trade trade(String broker, String[] coins, HashMap<String,Double> coin_price, String date) {
    	//buy ETH if its more than 1,000
        double price = coin_price.get("ETH");
    	if(price > 1000) {
    		TradeInterface tInterface = new TradeInterface();
            System.out.println("the price in dummy " + price);
            Trade trade = tInterface.createTrade(broker, name, "ETH", "buy", 400, price, date);
            return trade;
    	}
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
