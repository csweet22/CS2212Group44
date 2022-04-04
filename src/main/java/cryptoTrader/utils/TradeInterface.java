package cryptoTrader.utils;

import java.util.ArrayList;

import org.jfree.data.category.DefaultCategoryDataset;

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
	
	/**
	 * Formats the data for use in the bar graph
	 * @return a DefaultCategoryDataset to be used in the bar chart
	 */
	public DefaultCategoryDataset getBarData() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset(); //create a new dataset
		ArrayList<String> strategyNames = StrategyFactory.getInstance().getStrategyNames(); //get a list of all the strategy names
		
		Object[][] data = getTableData();// gets data for bar graph from TradeInterface
		for (Broker broker: BrokerManager.getInstance().getBrokers()){ //for every broker
			for (String strat: strategyNames){ //and every 
				dataset.setValue(null, broker.getName(), strat); //initialize the dataset with every broker and strategy
			}
		}


		for (int i = 0; i < data.length; i++){ //for all trades in the database
				dataset.incrementValue(1, data[i][0].toString(), data[i][1].toString()); //increment the value of the matching broker and strategy
		}
		return dataset; //return the formatted data
	}
}
