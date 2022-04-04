package cryptoTrader.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class StrategyFactory {

    private static StrategyFactory instance = null;

    private HashMap<String, Strategy> strategies = new HashMap<String, Strategy>();

    //Singleton design pattern
    public static StrategyFactory getInstance(){
        if (instance == null){
            instance = new StrategyFactory();
        }
        return instance;
    }

    private StrategyFactory(){
        // Put all strategies into this array
        Strategy[] stratList = 
        {
            new Buy_BTC(),
            new Sell_BTC(),
            new Buy_ETH(),
            new Sell_ETH(),
            new Buy_ADA(),
            
        };

        for (Strategy strat: stratList){
            strategies.put(strat.getName(), strat);
        }
    }
    
    

    public Strategy getStrategy(String strategyName){
        if (strategyName.equals("None")){
            return null;
        } else {
            return strategies.get(strategyName);
        }
    }

    public ArrayList<String> getStrategyNames(){
         ArrayList<String> names = new ArrayList<>();
         for (String key: strategies.keySet()){
             names.add(key);
         }
         return names;
    }


}
