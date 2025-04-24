package ro.ulbs.paradigme.lab6;

public class NewIntCalculator extends ACalculator {

    public NewIntCalculator(Integer initialValue) {

        this.state = initialValue;
    }

    @Override
    protected NewIntCalculator init() {
        this.state = 0;
        return this;
    }
    @Override
    protected NewIntCalculator clear() {
        this.init();
        return this;
    }

    public NewIntCalculator add(Integer value) {
        this.state = (Integer) this.state + value;
        return this;
    }

    public NewIntCalculator subtract(Integer value) {
        this.state = (Integer) this.state - value;
        return this;
    }

    public NewIntCalculator multiply(Integer value) {
        this.state = (Integer) this.state * value;
        return this;
    }
    public Integer result() {
        return (Integer)state;
    }
}