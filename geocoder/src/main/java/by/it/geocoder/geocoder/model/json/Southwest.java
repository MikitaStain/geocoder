package by.it.geocoder.geocoder.model.json;

public class Southwest {

    private String lat;

    private String lng;

    public Southwest() {
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
        return "Southwest{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}'+"\n";
    }
}
