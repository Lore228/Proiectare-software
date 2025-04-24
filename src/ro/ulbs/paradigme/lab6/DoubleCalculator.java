package ro.ulbs.paradigme.lab6;

public class DoubleCalculator extends ACalculator {

    public DoubleCalculator(Double initialValue) {
        this.state = initialValue;
    }

    @Override
    protected DoubleCalculator init() {
        this.state = 0.0;
        return this;
    }
    @Override
    protected DoubleCalculator clear() {
        this.init();
        return this;
    }

    public DoubleCalculator add(Double value) {
        this.state = (Double) this.state + value;
        return this;
    }

    public DoubleCalculator subtract(Double value) {
        this.state = (Double) this.state - value;
        return this;
    }

    public DoubleCalculator multiply(Double value) {
        this.state = (Double) this.state * value;
        return this;
    }
    public Double result() {
        return (Double)state;
    }
}