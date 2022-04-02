package cryptoTrader.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class TradeHistoryDB {

	private ArrayList<Object> db = new ArrayList<Object>();
	private HashMap<String,Object[]> numTrades = new HashMap<String, Object[]>();//index 0 is the number of trades, index 1 is the strategy
	
	private static TradeHistoryDB database = null;
	
	public TradeHistoryDB() {
	
	}
	
	public static TradeHistoryDB getInstance() {
		if(database == null) {
			database = new TradeHistoryDB();
		}
		return database;
	}
	
	public void store(Trade trade) {
		db.add(trade);
		Object[] temp = new Object[2];
		temp[0] = numTrades.get(trade.clientName)[0];
		temp[0] = (int) temp[0]+1;
		temp[1] = numTrades.get(trade.clientName)[1];
		numTrades.put(trade.clientName, temp);
	}

	public int size() {
		return db.size();
	}
	
	public Trade get(int i) {
		return (Trade) db.get(i);
	}
	
	public HashMap<String,Object[]> getMap(){
		return numTrades;
	}
}
