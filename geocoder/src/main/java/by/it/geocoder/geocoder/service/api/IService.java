package by.it.geocoder.geocoder.service.api;

import by.it.geocoder.geocoder.model.Address;
import by.it.geocoder.geocoder.model.Coordinate;

import java.util.List;

public interface IService {

    Coordinate getCoordinate(Address address);

    List<String> getAddress(Coordinate coordinate);
}
