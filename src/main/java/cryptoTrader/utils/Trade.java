package cryptoTrader.utils;

/**
 * The trade object
 * @author Nick Barrie & Nathan Chan
 */
public class Trade {
	private String clientName;
	private String strategyName;
	private String coinTraded;
	private String action;
	private int quantity;
	private double unitPrice;
	private String timeStamp;
	
	/**
	 * 
	 * @param clientName name of the broker
	 * @param strategyName name of the strategy used
	 * @param coinTraded name of the coin
	 * @param action buy or sell
	 * @param quantity number of coins traded
	 * @param unitPrice price of the coin
	 * @param timeStamp the date of the trade
	 */
	public Trade(String clientName, String strategyName, String coinTraded, String action, int quantity, double unitPrice, String timeStamp) {
		this.clientName = clientName;
		this.strategyName = strategyName;
		this.coinTraded = coinTraded;
		this.action = action;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.timeStamp = timeStamp;
	}
	
	/**
	 * returns the information stored in the trade
	 * @return object array with all of the information from the trade
	 */
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

	/**
	 * 
	 * @return name of the broker that made the trade
	 */
	public String getName(){
		return clientName;
	}

}