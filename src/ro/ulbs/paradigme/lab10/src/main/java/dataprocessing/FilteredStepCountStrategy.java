package ro.ulbs.paradigme.lab10.src.main.java.dataprocessing;

import ro.ulbs.paradigme.lab10.src.main.java.storage.SensorData;

import java.util.ArrayList;
import java.util.Collection;

public class FilteredStepCountStrategy implements StepCountStrategy {
    private Collection<SensorData> lastMinuteList = new ArrayList<>();
    private int totalSteps;
    private static final int STEP_LIMIT = 1000;

    @Override
    public void consumeMessage(SensorData sample) {
        if (sample.getStepsCount() > 0) {
            long one_minute_ago = System.currentTimeMillis() - 60000;


            int currentSum = lastMinuteList.stream()
                    .filter(data -> data.getTimestamp() >= one_minute_ago)
                    .mapToInt(SensorData::getStepsCount)
                    .sum();


            if (currentSum <= STEP_LIMIT && sample.getTimestamp() >= one_minute_ago) {
                lastMinuteList.add(sample);
            }
        }
    }

    @Override
    public int getTotalSteps() {
        totalSteps = lastMinuteList.stream()
                .mapToInt(SensorData::getStepsCount)
                .sum();
        return totalSteps;
    }

    @Override
    public String getStrategyDescription() {
        return "Strategie filtrata de numarat pasii ";
    }
}