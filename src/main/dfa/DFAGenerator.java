package dfa;

import java.util.HashSet;

public class DFAGenerator {
    public Boolean isAccepted(States states, String alphabets, Transition transitions, State initialState, HashSet<State> finalState) {
        for (int i = 0; i<alphabets.length(); i++){
            initialState = transitions.getTransition(initialState, String.valueOf(alphabets.charAt(i)));
        }
        return states.isFinalState(initialState);
    }
}
