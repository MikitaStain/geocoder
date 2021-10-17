package by.it.geocoder.geocoder.service;

import by.it.geocoder.geocoder.model.Address;
import by.it.geocoder.geocoder.model.Coordinate;
import by.it.geocoder.geocoder.model.json.Geocoder;
import by.it.geocoder.geocoder.model.json.Geometry;
import by.it.geocoder.geocoder.model.json.Location;
import by.it.geocoder.geocoder.model.json.Results;
import by.it.geocoder.geocoder.service.api.ISearchServiceCoordinate;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SearchCoordinateService implements ISearchServiceCoordinate {

    private static final SearchCoordinateService instance = new SearchCoordinateService();


    @Override
    public URL getURL(Address address) {
        final URL googleGeocoding;
        try {
            googleGeocoding = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" + address.getNumber() +
                    "%" + address.getStreet() + "%" + address.getCity() + "&key=");
            return googleGeocoding;
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Неверный адрес");
        }

    }

    @Override
    public BufferedReader getBR(URL url) {
        try {
            return new BufferedReader(
                    new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            throw new IllegalStateException("Ошибка открытия потока", e);
        }
    }

    @Override
    public Geocoder getGeocoder(BufferedReader bufferedReader) {
        Gson gson = new Gson();
        return gson.fromJson(bufferedReader, Geocoder.class);
    }

    @Override
    public Coordinate getCoordinate(Geocoder geocoder) {

        List<Results> results = geocoder.getResults();
        Coordinate coordinate = new Coordinate();

        for (Results result : results) {
            final Geometry geometry = result.getGeometry();
            final Location location = geometry.getLocation();

            coordinate.setLat(location.getLat());
            coordinate.setLng(location.getLng());
        }
        return coordinate;
    }

    @Override
    public boolean isValidations(Address address) {

        return (!(address.getNumber().equals("")
                || address.getStreet().equals("")
                || address.getCity().equals("")));
    }


    public static SearchCoordinateService getInstance() {
        return instance;
    }
}
