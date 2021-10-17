package by.it.geocoder.geocoder.model.json;

import java.util.ArrayList;
import java.util.List;

public class Geocoder {

    private String error_message;

    private List<Results> results;

    private String status;

    public Geocoder() {
        this.results=new ArrayList<>();
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    @Override
    public String toString() {
        return "Geocoder{" +
                "error_message='" + error_message + '\'' +
                ", results=" + results +
                ", status='" + status + '\'' +
                '}';
    }
}
