package dfa;

import java.util.HashSet;
import java.util.Iterator;

public class States {

    private HashSet<State> states = new HashSet<>();
    private HashSet<State> finalStates = new HashSet<>();

    private State initialState ;

    public void setInitialState(State initialState) {
        this.initialState = initialState;
        states.add(initialState);
    };

    public void addFinalState(HashSet<State> finalStates) {
        this.finalStates = finalStates ;
        for (State state : finalStates) {
            states.add(state);
        }
    }


    Boolean isFinalState(State currentState) {
        return finalStates.contains(currentState);
    }
}
