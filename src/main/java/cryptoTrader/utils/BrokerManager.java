package cryptoTrader.utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class used to create and manage several brokers during execution.
 * Also helps to reduce coupling by minimizing direct interaction with 
 * the MainUI and individual brokers
 * @author Mitchell Walker
 */
public class BrokerManager {

    private static BrokerManager instance = null; //singleton reference to object
    private HashMap<String, Broker> brokers = new HashMap<>(); //a map to store all brokers

    private BrokerManager(){}

    /**
     * singleton design using lazy instantiation. Returns a reference to the BrokerManager
     * if it exists. If it doesn't exist it is first initialized and then returned
     * @return a reference to the BrokerManager 
     */
    public static BrokerManager getInstance(){
        if (instance == null){
            instance = new BrokerManager();
        }
        return instance;
    }

    /**
     * used to clear all brokers from the manager to prepare 
     * it for the next "perform trade" action
     */
    public void clearBrokers(){
        brokers.clear();
    }

    /**
     * Creates a new broker with the given parameters and adds it to the current brokers
     * @param name the name of the broker to be created
     * @param coins the list of coins this broker will be interested in
     * @param strategyName the name of the strategy this broker will employ
     * @return false if the brokers name is already in the current brokers and true otherwise
     */
    public boolean addBroker(String name, String[] coins, String strategyName){
        if (brokers.get(name) != null){ //if this key is already in the hashmap
            return false;
        }
        Strategy strategy = StrategyFactory.getInstance().getStrategy(strategyName); //gets a reference to the strategy object this broker will use to make trades
        brokers.put(name, new Broker(name, coins, strategy)); //create a broker and add it to the hashmap, using its name as the associated key
        return true;
    }

    /**
     * Returns a list of all the current brokers
     * @return an ArrayList<Broker> containing all the current brokers in the manager
     */
    public ArrayList<Broker> getBrokers(){
        ArrayList<Broker> brokerList = new ArrayList<>(); //create a new array list
        for (Broker broker: brokers.values()){ //for every broker in the values set of the hashmap
            brokerList.add(broker); //add the broker to the array list
        }
        return brokerList; //return the list
    }

    /**
     * Gets a reference to the strategy of a given broker
     * @param name the name of the broker to get the strategy of
     * @return a reference to the strategy of the broker with the given name
     */
    public String getBrokerStrategy(String name){//gets the strategy of a given broker
       return  brokers.get(name).getName();
    }
    
}
