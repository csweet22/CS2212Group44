package cryptoTrader.utils;

import java.util.HashMap;

interface Strategy {
    public Trade trade(String broker, String[] coins,HashMap<String,Double> coin_price, String date);
    public String getName();
}
