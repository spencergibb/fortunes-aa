package fortunes;

import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Spencer Gibb
 */
@RepositoryRestResource
public interface FortuneRepository extends TypedIdCassandraRepository<Fortune, String> {
}
