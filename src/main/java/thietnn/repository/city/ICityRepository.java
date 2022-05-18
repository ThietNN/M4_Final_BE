package thietnn.repository.city;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thietnn.model.City;

@Repository
public interface ICityRepository extends CrudRepository<City, Long> {
}
