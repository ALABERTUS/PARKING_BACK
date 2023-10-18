package parking.infraRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import parking.domain.models.PlazasEstados;

public interface PlazasEstadosRepository extends JpaRepository<PlazasEstados, Integer> {
}
