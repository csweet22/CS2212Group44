package cryptoTrader.utils;

import java.util.ArrayList;
/**
 * A facade that allows the TradeHistoryDB to be acccessed 
 * @author Nick Barrie & Nathan Chan
 */
public class TradeInterface {
	static TradeHistoryDB db; //use singleton method to retrieve
	
	/**
	 * 
	 * @param clientName the name of the broker
	 * @param strategyName the name of the strategy used by the broker
	 * @param coinTraded the name of the coin
	 * @param action buy or sell
	 * @param quantity the number of coins to be bought or sold
	 * @param unitPrice the price of the coin
	 * @param timeStamp the date of the action
	 * @return Trade object that is stored in the database
	 */
	public Trade createTrade(String clientName, String strategyName, String coinTraded, String action, int quantity, double unitPrice, String timeStamp) {
		Trade trade = new Trade(clientName, strategyName, coinTraded, action, quantity, unitPrice, timeStamp);
		db.store(trade);//store the trade in the database
		return trade;
	}
	
	/**
	 * Create the interface
	 */
	public TradeInterface() {
		db = TradeHistoryDB.getInstance();
	}
	
	/**
	 * Formats the data for the table
	 * @return 2-d Object array of the data to be displayed in the table
	 */
	public Object[][] getTableData(){
		Object[][] table = new Object[db.size()][7];
		for(int i = 0; i < db.size(); i++) {
			Object[] tradeInfo = db.get(i).getTradeInfo();
			table[i][0] =tradeInfo[0];
			table[i][1] = tradeInfo[1];
			table[i][2] = tradeInfo[2];
			table[i][3] = tradeInfo[3];
			table[i][4] = tradeInfo[4];
			table[i][5] = tradeInfo[5];
			table[i][6] = tradeInfo[6];
		}
		return table;
	}
	
	/**
	 * Formats the data for the bar graph
	 * @return 2-d Object array of the data to be displayed in the bar graph
	 */
	public Object[][] getBarData() {
		BrokerManager brokerManager = BrokerManager.getInstance();
		ArrayList<String> names = new ArrayList<String>();//names of brokers
		names.addAll(db.getMap().keySet());
		ArrayList<Integer> values = new ArrayList<Integer>();//number of trades made
		values.addAll(db.getMap().values());
		Object[][] barData = new Object[names.size()][3];
		for(int i =0; i< names.size(); i++) {//formats the information how the bargraph wants
			barData[i][0] = values.get(i);//number of trades
			barData[i][1] = names.get(i);//name of broker
			barData[i][2]= brokerManager.getBrokerStrategy(names.get(i));//strategy name
			
		}
		return barData;
	}
}
