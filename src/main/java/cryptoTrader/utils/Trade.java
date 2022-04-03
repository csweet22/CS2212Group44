package cryptoTrader.utils;

public class Trade {
	private String clientName;
	private String strategyName;
	private String coinTraded;
	private String action;
	private int quantity;
	private double unitPrice;
	private String timeStamp;
	
	public Trade(String clientName, String strategyName, String coinTraded, String action, int quantity, double unitPrice, String timeStamp) {
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

	public String getName(){
		return clientName;
	}

}