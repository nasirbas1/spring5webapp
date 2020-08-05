package nasir.spring5webapp.repositories;

import nasir.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
