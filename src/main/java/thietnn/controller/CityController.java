package thietnn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thietnn.model.City;
import thietnn.model.Country;
import thietnn.service.city.ICityService;
import thietnn.service.country.ICountryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
@CrossOrigin("*")
public class CityController {
    @Autowired
    private ICityService cityService;
    @Autowired
    private ICountryService countryService;

    @GetMapping("")
    public ResponseEntity<Iterable<City>> cityList(){
        Iterable<City> cityList = cityService.findAll();
        List<City> cities = (List<City>) cityList;
//        if (cities.isEmpty())
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/country")
    public ResponseEntity<Iterable<Country>> countryList(){
        Iterable<Country> countryList = countryService.findAll();
        List<Country> countries = (List<Country>) countryList;
//        if (cities.isEmpty())
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<City>> findCityById(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
//        if (!city.isPresent())
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(city,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<City> addNewCity(@RequestBody City city){
        cityService.save(city);
        return new ResponseEntity<>(city,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> removeCityById(@PathVariable Long id){
        Optional<City> removedCity = cityService.findById(id);
//        if (!removedCity.isPresent())
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        cityService.removeById(id);
        return new ResponseEntity<>(removedCity.get(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCityInfo(@PathVariable Long id, @RequestBody City city){
        Optional<City> originalCity = cityService.findById(id);
//        if (!originalCity.isPresent())
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Long originalId = originalCity.get().getId();
        city.setId(originalId);
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
