package cryptoTrader.utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class for implementing singleton design pattern for multiple strategies.
 * Eager initialization is used to create each strategy, which other files can then
 * get a reference to by passing a name
 * @author Mitchell Walker
 */
public class StrategyFactory {

    private static StrategyFactory instance = null;

    private HashMap<String, Strategy> strategies = new HashMap<String, Strategy>();

     /**
     * The factory itself is also singleton, however it uses lazy instantiation
     * @return a reference to the StrategyFactory object. If the objects does not exist, it is first
     * created and then returned
     */
    public static StrategyFactory getInstance(){
        if (instance == null){
            instance = new StrategyFactory();
        }
        return instance;
    }

    /**
     * Constructor for the StrategyFactory
     */
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
    
    
      /**
     * Returns a reference to the strategy specified by its name
     * @param strategyName the name of the strategy to be returned
     * @return the strategy with the matching name. If the strategy is "none" return null instead
     */
    public Strategy getStrategy(String strategyName){
        if (strategyName.equals("None")){
            return null;
        } else {
            return strategies.get(strategyName);
        }
    }

     /**
     * Gets a list of all the strategy names so they can easily be added to the UI
     * @return an ArrayList<String> of all strategy names
     */
    public ArrayList<String> getStrategyNames(){
         ArrayList<String> names = new ArrayList<>();
         for (String key: strategies.keySet()){
             names.add(key);
         }
         return names;
    }


}
