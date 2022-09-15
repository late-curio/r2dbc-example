package latecurio.webgres;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ReactiveSortingRepository<Item, Long> {
}
