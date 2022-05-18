package thietnn.service.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thietnn.model.City;
import thietnn.repository.city.ICityRepository;

import java.util.Optional;

@Service
public class CityService implements ICityService{
    @Autowired
    private ICityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void removeById(Long id) {
        cityRepository.deleteById(id);
    }
}
