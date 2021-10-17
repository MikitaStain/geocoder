package by.it.geocoder.geocoder.service;

import by.it.geocoder.geocoder.model.Coordinate;
import by.it.geocoder.geocoder.model.json.Geocoder;
import by.it.geocoder.geocoder.model.json.Results;
import by.it.geocoder.geocoder.service.api.ISearchServiceAddress;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SearchAddressService implements ISearchServiceAddress {

    public static final SearchAddressService instance = new SearchAddressService();

    @Override
    public URL getURL(Coordinate coordinate) {
        final URL googleGeocoding;
        try {
            googleGeocoding = new URL("https://maps.googleapis.com/maps/api/geocode/json?latlng="+coordinate.getLat()
                    +","+coordinate.getLng()+"&key=AIzaSyDUBngCASYl_wHRz9RzOBjdq5ZiBtGhvgM");
            return googleGeocoding;
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Неверный адрес",e );
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
    public List<String> getAddress(Geocoder geocoder) {

        List<String> address = new ArrayList<>();
        List<Results> results = geocoder.getResults();

        for (Results result : results) {

            String formatted_address = result.getFormatted_address();
            address.add(formatted_address);
        }
        return address;
    }


    @Override
    public boolean isValidations(Coordinate coordinate) {

        return (!(coordinate.getLng().equals("")
                || coordinate.getLat().equals("")));
    }



    public static SearchAddressService getInstance() {
        return instance;
    }
}
