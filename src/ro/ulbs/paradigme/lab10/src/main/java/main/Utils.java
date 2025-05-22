package ro.ulbs.paradigme.lab10.src.main.java.main;

import ro.ulbs.paradigme.lab10.src.main.java.dataprocessing.BasicStepCountStrategy;
import ro.ulbs.paradigme.lab10.src.main.java.dataprocessing.FilteredStepCountStrategy;
import ro.ulbs.paradigme.lab10.src.main.java.dataprocessing.StepCountStrategy;

public class Utils {
    public static final String BASIC_STRATEGY = "basic";
    public static final String FILTERED_STRATEGY = "filtered";

    public static int getClientId() {
        return 42;
    }


    public static StepCountStrategy getStrategy(String type) {
        if (type.equals(BASIC_STRATEGY)) {
            return new BasicStepCountStrategy();
        } else if (type.equals(FILTERED_STRATEGY)) {
            return new FilteredStepCountStrategy();
        } else {
            return null;
        }
    }
}