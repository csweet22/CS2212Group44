package cryptoTrader.utils;

import java.util.ArrayList;

public class TradeInterface {
	static TradeHistoryDB db; //use singleton method to retrieve
	
	public Trade createTrade(String clientName, String strategyName, String coinTraded, String action, int quantity, double unitPrice, String timeStamp) {
		Trade trade = new Trade(clientName, strategyName, coinTraded, action, quantity, unitPrice, timeStamp);
		db.store(trade);//store the trade in the database
		return trade;
	}
	
	public TradeInterface() {
		db = TradeHistoryDB.getInstance();
	}
	
	public Object[][] getTableData(){//get the information that the table needs
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
	
	public Object[][] getBarData() {//get the information that the bar graph needs
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
