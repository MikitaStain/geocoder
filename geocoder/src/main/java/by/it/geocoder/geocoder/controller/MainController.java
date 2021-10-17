package by.it.geocoder.geocoder.controller;

import by.it.geocoder.geocoder.model.Address;
import by.it.geocoder.geocoder.model.Coordinate;
import by.it.geocoder.geocoder.service.SearchAddressService;
import by.it.geocoder.geocoder.service.SearchCoordinateService;
import by.it.geocoder.geocoder.service.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "");
        return "home";
    }

    @GetMapping("/home/searchCoordinate")
    public String searchCoordinate() {
        return "searchCoordinate";
    }

    @GetMapping("/home/searchAddress")
    public String searchAddress() {
        return "searchAddress";
    }

    @PostMapping("/home/searchAddress")
    public String searchAddressPost(@RequestParam String lat
            , @RequestParam String lng
            , Model model) {

        Coordinate coordinate = new Coordinate(lng, lat);

        StringBuilder string = new StringBuilder();

        if (!SearchAddressService.getInstance().isValidations(coordinate)) {
            return "notFound";
        } else {
            List<String> address = Service.getInstance().getAddress(coordinate);
            for (String s : address) {

                string.append(s).append(" ");
            }
            model.addAttribute("address", string.toString());

            return "address";
        }
    }

    @PostMapping("/home/searchCoordinate")
    public String searchCoordinatePost(@RequestParam String number
            , @RequestParam String street
            , @RequestParam String city
            , Model model) {

        Address address = new Address(number, street, city);

        if (!SearchCoordinateService.getInstance().isValidations(address)) {
            return "notFound";
        } else {
            Coordinate coordinate = Service.getInstance().getCoordinate(address);

            model.addAttribute("lat", coordinate.getLat());
            model.addAttribute("lng", coordinate.getLng());

            return "coordinate";
        }
    }

}
