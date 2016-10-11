package dfa;

import java.util.HashMap;
import java.util.Map;

public class Transition {
    private Map<State, Map<String, State>> transitionStates = new HashMap<>();

    public void addTransition(State firstState, String alphabet, State secondState) {
        if(!transitionStates.containsKey(firstState)){
            HashMap<String, State> map = new HashMap<>();
            map.put(alphabet, secondState);
            transitionStates.put(firstState, map);
        }
        else{
            transitionStates.get(firstState).put(alphabet, secondState);
        }

    }

    public State getTransition(State currentState, String alphabet){
        return transitionStates.get(currentState).get(alphabet);
    }
}
