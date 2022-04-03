package cryptoTrader.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DummyA implements Strategy{
    private String name = "Dummy-Strategy-A";

    @Override
    public Trade trade(String broker, String[] coins) {
    	//buy ETH if its more than 3,000
    	DataFetcher fetcher = new DataFetcher();
    	String date = java.time.LocalDate.now().toString();
    	float price = (float) fetcher.getPriceForCoin("ETH", date);
    	if(price > 3000) {
    		TradeInterface tInterface = new TradeInterface();
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
