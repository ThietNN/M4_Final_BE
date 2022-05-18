package thietnn.repository.country;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thietnn.model.Country;

@Repository
public interface ICountryRepository extends CrudRepository<Country, Long> {
}
