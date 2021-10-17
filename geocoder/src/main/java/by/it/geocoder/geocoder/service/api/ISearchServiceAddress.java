package by.it.geocoder.geocoder.service.api;

import by.it.geocoder.geocoder.model.Address;
import by.it.geocoder.geocoder.model.Coordinate;
import by.it.geocoder.geocoder.model.json.Geocoder;

import java.io.BufferedReader;
import java.net.URL;
import java.util.List;

public interface ISearchServiceAddress {

    URL getURL(Coordinate coordinate);

    BufferedReader getBR(URL url);

    Geocoder getGeocoder(BufferedReader bufferedReader);

    List<String> getAddress(Geocoder geocoder);

    boolean isValidations(Coordinate coordinate);
}
