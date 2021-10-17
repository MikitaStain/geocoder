package by.it.geocoder.geocoder.service;


import by.it.geocoder.geocoder.model.Address;
import by.it.geocoder.geocoder.model.Coordinate;
import by.it.geocoder.geocoder.model.json.Geocoder;
import by.it.geocoder.geocoder.service.api.ISearchServiceAddress;
import by.it.geocoder.geocoder.service.api.ISearchServiceCoordinate;
import by.it.geocoder.geocoder.service.api.IService;

import javax.sql.rowset.CachedRowSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Service implements IService {

    private final static Service instance = new Service();
    private final ISearchServiceCoordinate searchServiceCoordinate;
    private final ISearchServiceAddress searchServiceAddress;


    public Service() {

        this.searchServiceCoordinate = SearchCoordinateService.getInstance();
        this.searchServiceAddress = SearchAddressService.getInstance();
    }

    @Override
    public Coordinate getCoordinate(Address address) {

        URL url = searchServiceCoordinate.getURL(address);

        try (BufferedReader br = searchServiceCoordinate.getBR(url)) {

            Geocoder geocoder = searchServiceCoordinate.getGeocoder(br);

            return searchServiceCoordinate.getCoordinate(geocoder);

        } catch (IOException e) {

            throw new IllegalStateException("Ошибка закрытия потока", e);
        }

    }
    @Override
    public List<String> getAddress(Coordinate coordinate) {

        URL url = searchServiceAddress.getURL(coordinate);


        try(BufferedReader br = searchServiceAddress.getBR(url)) {

            Geocoder geocoder = searchServiceAddress.getGeocoder(br);

            return searchServiceAddress.getAddress(geocoder);

        } catch (IOException e) {

            throw new IllegalStateException("Ошибка закрытия потока",e);
        }
    }

    public static Service getInstance() {
        return instance;
    }
}
