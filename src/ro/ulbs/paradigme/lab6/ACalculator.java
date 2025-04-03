package ro.ulbs.paradigme.lab6;

public abstract class ACalculator {
    protected Object state = null;

    public Object result() {
        return state;
    }

    protected ACalculator clear() {
        this.init();
        return this;
    }
    protected abstract ACalculator init();
}
