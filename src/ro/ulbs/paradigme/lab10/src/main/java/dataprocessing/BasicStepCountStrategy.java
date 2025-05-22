package ro.ulbs.paradigme.lab10.src.main.java.dataprocessing;

import ro.ulbs.paradigme.lab10.src.main.java.storage.SensorData;

public class BasicStepCountStrategy implements StepCountStrategy {
    private int totalSteps;
    @Override
    public void consumeMessage(SensorData sample) {
        totalSteps=totalSteps+sample.getStepsCount();
    }
    @Override
    public int getTotalSteps() {
        return totalSteps;
    }
    @Override
    public String getStrategyDescription() {
        return "Strategie basic de numarat pasii";}
}