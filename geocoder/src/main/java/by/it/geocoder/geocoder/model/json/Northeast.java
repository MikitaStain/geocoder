package by.it.geocoder.geocoder.model.json;

public class Northeast {

    private String lat;

    private String lng;

    public Northeast() {
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Northeast{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}'+"\n";
    }
}
