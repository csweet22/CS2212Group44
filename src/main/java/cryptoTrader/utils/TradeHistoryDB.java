package cryptoTrader.utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class stores the information of a trade
 * @author Nick Barrie & Nathan Chan
 */
public class TradeHistoryDB {

	private ArrayList<Trade> db = new ArrayList<Trade>();
	private HashMap<String,Integer> numTrades = new HashMap<String, Integer>();//key is broker name, value is number of trades made
	
	private static TradeHistoryDB database = null;
	
	public TradeHistoryDB() {}
	
	/**
	 * create the database
	 * @return the database
	 */
	public static TradeHistoryDB getInstance() {
		if(database == null) {
			database = new TradeHistoryDB();
		}
		return database;
	}
	
	/**
	 * stores a trade in the database
	 * @param trade the trade to be stored
	 */
	public void store(Trade trade) {
		db.add(trade);//store the trade
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
	 * @return the trade requested
	 */
	public Trade get(int i) {
		return (Trade) db.get(i);
	}
	
	/**
	 * 
	 * @return hashmap for the bargraph
	 */
	public HashMap<String,Integer> getMap(){
		return numTrades;
	}
}