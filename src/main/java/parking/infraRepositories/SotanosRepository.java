package parking.infraRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import parking.domain.models.Sotanos;

public interface SotanosRepository extends JpaRepository<Sotanos, Integer> {
}
