import dfa.DFAGenerator;
import dfa.State;
import dfa.States;
import dfa.Transition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFAGeneratorTest {
    @Test
    public void should_accept_string_starting_with_1_and_ending_with_0() throws Exception {
        States states = new States();
        State initialState = new State("q1");
        states.setInitialState(initialState);

        HashSet<State> finalStates = new HashSet<>();

        State secondState = new State("q2");
        finalStates.add(secondState);
        states.addFinalState(finalStates);

        Transition transitions = new Transition();
        transitions.addTransition(initialState, "1", initialState);
        transitions.addTransition(initialState, "0", secondState);

        transitions.addTransition(secondState, "1", initialState);
        transitions.addTransition(secondState, "0", secondState);

        DFAGenerator dfaGenerator = new DFAGenerator();
        String alphabets = "11110000";
        assertTrue(dfaGenerator.isAccepted(states, alphabets, transitions, initialState, finalStates));
    }

    @Test
    public void should_not_accept_string_starting_with_1_and_ending_with_0() throws Exception {
        States states = new States();
        State initialState = new State("q1");
        states.setInitialState(initialState);

        HashSet<State> finalStates = new HashSet<>();

        State secondState = new State("q2");
        finalStates.add(secondState);
        states.addFinalState(finalStates);

        Transition transitions = new Transition();
        transitions.addTransition(initialState, "1", initialState);
        transitions.addTransition(initialState, "0", secondState);

        transitions.addTransition(secondState, "1", initialState);
        transitions.addTransition(secondState, "0", secondState);

        DFAGenerator dfaGenerator = new DFAGenerator();
        String alphabets = "11110001";
        assertFalse(dfaGenerator.isAccepted(states, alphabets, transitions, initialState, finalStates));
    }
}
