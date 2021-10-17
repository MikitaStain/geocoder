package by.it.geocoder.geocoder.model;

public class Address {

    private String number;

    private String street;

    private String city;

    public Address(String number, String street, String city) {
        this.number = number;
        this.street = street;
        this.city = city;
    }

    public Address() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
