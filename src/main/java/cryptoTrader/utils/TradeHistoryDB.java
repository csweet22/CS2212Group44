package cryptoTrader.utils;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * A class that is the trade history database
 * All the trades that are made will be stored here 
 * @author Nathan Chan & Nick Barrie
 */
public class TradeHistoryDB {

	private ArrayList<Trade> db = new ArrayList<Trade>();//A list of the trades made
	private HashMap<String,Integer> numTrades = new HashMap<String, Integer>();//counts the number of trades that broker has made. key is broker name, value is number of trades made
	
	private static TradeHistoryDB database = null;
	
	public TradeHistoryDB() {}
	
	/**
	 * @return the instance of the database
	 */
	public static TradeHistoryDB getInstance() {
		if(database == null) {//create the database if it doesn't exist
			database = new TradeHistoryDB();
		}
		return database;
	}
	
	/**
	 * Stores a new trade in the database
	 * @param trade the Trade object to be stored
	 */
	public void store(Trade trade) {

		db.add(trade);//store trade in the list
		if(numTrades.get(trade.getName()) == null){//if this is the first time the broker has made a trade, start it at one
			numTrades.put(trade.getName(), 1);
		}
		int num = numTrades.get(trade.getName());//add one the the trades made
		 num = num + 1;
		numTrades.put(trade.getName(), num);
	}

	/**
	 * 
	 * @return the number of trades in the database
	 */
	public int size() {
		return db.size();
	}
	
	/**
	 * 
	 * @param i the index of the trade to get
	 * @return the Trade object at index i
	 */
	public Trade get(int i) {
		return (Trade) db.get(i);
	}
	/**
	 * Used by the dataVisualizer to display the histogram
	 * @return the hashmap containing how many times each broker has made a trade
	 */
	public HashMap<String,Integer> getMap(){
		return numTrades;
	}
}
