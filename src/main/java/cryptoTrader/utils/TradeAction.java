package cryptoTrader.utils;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * this class contains the logic of making a trade
 * @author Nathan Chan & Nick Barrie
 */
public class TradeAction {
    public void performTrade(BrokerManager bm){
        ArrayList<Broker> brokerlist = new ArrayList<>();//list of the brokers
        brokerlist = bm.getBrokers();
        ArrayList<String> coins = new ArrayList<>();//list of the coins
        for(int i =0; i < brokerlist.size(); i++){//loop through and add all the coins the brokers are interested in to a list
            Broker temp = brokerlist.get(i);
            String[] tempCoins = temp.getCoins();
            for(int k = 0; k<temp.getCoins().length;k++){
                coins.add(tempCoins[k]);
            }
            
        }
        DataFetcher fetcher = new DataFetcher();
        LocalDateTime LocalDate = LocalDateTime.now();
        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");//date in proper format for api call
        String today = dateformatter.format(LocalDate).toString();

        System.out.println(today);
        String[] allCoins = {"ethereum","bitcoin","cardano","tether","solana","decentraland"};//the name for the api call
        String[] shortForm = {"ETH","BTC","ADA","USDT","SOL","MANA"};//the symbol
        HashMap<String,Double> coin_price = new HashMap<String, Double>();//a map that associates the coin to the price
        for(int i = 0; i<allCoins.length;i++){
            Double price = fetcher.getPriceForCoin(allCoins[i], today);//fetch price
            coin_price.put(shortForm[i], price);
        }
        
        for(int i = 0; i < brokerlist.size();i++){//loop through each broker and make their trade
            Broker temp = brokerlist.get(i);
            if (temp.getStrategy() != null){ //if the broker has a strategy
                temp.makeTrade(coin_price, today); //perform its strategies trade
            }
        }
        
    }
}
