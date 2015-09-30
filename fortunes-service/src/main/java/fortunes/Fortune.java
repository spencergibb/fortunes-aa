package fortunes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * @author Spencer Gibb
 */
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fortune {

	@PrimaryKey
	private String id;

	private String fortune;
}
