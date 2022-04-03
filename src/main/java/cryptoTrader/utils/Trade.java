package cryptoTrader.utils;

public class Trade {
	String clientName;
	String strategyName;
	String coinTraded;
	String action;
	int quantity;
	float unitPrice;
	String timeStamp;
	
	public Trade(String clientName, String strategyName, String coinTraded, String action, int quantity, float unitPrice, String timeStamp) {
		this.clientName = clientName;
		this.strategyName = strategyName;
		this.coinTraded = coinTraded;
		this.action = action;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.timeStamp = timeStamp;
	}
	
	public Object[] getTradeInfo(){
		Object[] tradeInfo = new Object[7];
		tradeInfo[0] = clientName;
		tradeInfo[1] = strategyName;
		tradeInfo[2] = coinTraded;
		tradeInfo[3] = action;
		tradeInfo[4] = quantity;
		tradeInfo[5] = unitPrice;
		tradeInfo[6] = timeStamp;
		return tradeInfo;
	}

}