package parking.infraRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import parking.domain.models.EstadoPlaza;

public interface EstadoPlazaRepository extends JpaRepository<EstadoPlaza, Integer> {
}
