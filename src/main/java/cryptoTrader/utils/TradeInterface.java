package cryptoTrader.utils;

import java.util.ArrayList;

public class TradeInterface {
	static TradeHistoryDB db; //use singleton method to retrieve
	
	public Trade createTrade(String clientName, String strategyName, String coinTraded, String action, int quantity, float unitPrice, String timeStamp) {
		Trade trade = new Trade(clientName, strategyName, coinTraded, action, quantity, unitPrice, timeStamp);
		db.store(trade);
		return trade;
	}
	
	public TradeInterface() {
		db = TradeHistoryDB.getInstance();
	}
	
	public Object[] getTableData(){
		Object[] table = new Object[7];
		for(int i = 0; i < db.size(); i++) {
			Trade temp = (Trade) db.get(i);
			table[i] = temp.getTradeInfo();
		}
		return table;
	}
	
	public ArrayList<Object[]> getBarData() {
		ArrayList<String> names = new ArrayList<String>();
		names.addAll(db.getMap().keySet());
		ArrayList<Object[]> values = new ArrayList<Object[]>();
		values.addAll(db.getMap().values());
		ArrayList<Object[]> barValues = new ArrayList<Object[]>();
		for(int i =0; i< names.size(); i++) {
			Object[] temp = new Object[3];
			temp[0] = values.get(i)[0];
			temp[1] = names.get(i);
			temp[2] = values.get(i)[1];
			barValues.add(temp);
		}
		return barValues;
	}
}
