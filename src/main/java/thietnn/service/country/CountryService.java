package thietnn.service.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thietnn.model.Country;
import thietnn.repository.country.ICountryRepository;

import java.util.Optional;

@Service
public class CountryService implements ICountryService{
    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void removeById(Long id) {
        countryRepository.deleteById(id);
    }
}
