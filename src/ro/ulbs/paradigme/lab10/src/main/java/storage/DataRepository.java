package ro.ulbs.paradigme.lab10.src.main.java.storage;


import java.util.ArrayList;
import java.util.List;

/**
 * Persists sensor data.
 */
// TODO make this class singleton

public class DataRepository {
    private List<SensorData> records = new ArrayList<>();
    private static DataRepository instance;

    private DataRepository() {
    }

    public static DataRepository getInstance() {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }

    public void addData(SensorData dataRecord) {

        records.add(dataRecord);
    }


    public List<SensorData> getRecords() {
        return records;
    }
}

