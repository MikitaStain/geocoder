package by.it.geocoder.geocoder.model.json;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private List<Address_components> address_components;

    private String formatted_address;

    private Geometry geometry;

    private String place_id;


    private Plus_code plus_code;

    private List<String> types;

    public Results() {
        this.types=new ArrayList<>();
    }

    public List<Address_components> getAddress_components() {
        return address_components;
    }

    public void setAddress_components(List<Address_components> address_components) {
        this.address_components = address_components;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Plus_code getPlus_code() {
        return plus_code;
    }

    public void setPlus_code(Plus_code plus_code) {
        this.plus_code = plus_code;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Results{" +
                "address_components=" + address_components +
                ", formatted_address='" + formatted_address + '\'' +
                ", geometry=" + geometry +
                ", place_id='" + place_id + '\'' +
                ", plus_code=" + plus_code +
                ", types=" + types +
                '}'+"\n";
    }
}
