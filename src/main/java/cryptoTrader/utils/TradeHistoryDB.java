package cryptoTrader.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class TradeHistoryDB {

	private ArrayList<Trade> db = new ArrayList<Trade>();
	private HashMap<String,Integer> numTrades = new HashMap<String, Integer>();//key is broker name, value is number of trades made
	
	private static TradeHistoryDB database = null;
	
	public TradeHistoryDB() {}
	
	public static TradeHistoryDB getInstance() {//create the database
		if(database == null) {
			database = new TradeHistoryDB();
		}
		return database;
	}
	
	public void store(Trade trade) {//store a trade

		db.add(trade);
		if(numTrades.get(trade.getName()) == null){//if this is the first time the broker has made a trade, start it at one
			numTrades.put(trade.getName(), 1);
		}
		int num = numTrades.get(trade.getName());//add one the the trades made
		 num = num + 1;
		numTrades.put(trade.getName(), num);
	}

	public int size() {//return the number of trades in the database
		return db.size();
	}
	
	public Trade get(int i) {//get a trade from the database
		return (Trade) db.get(i);
	}
	
	public HashMap<String,Integer> getMap(){//return map for the bar graph
		return numTrades;
	}
}
