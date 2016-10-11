package dfa;

public class State {

    private final String stateName;

    public State(String state) {
        this.stateName = state;
    }

    public String getStateName(){
        return this.stateName;
    }
}
