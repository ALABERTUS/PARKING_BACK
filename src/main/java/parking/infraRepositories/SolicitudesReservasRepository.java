package parking.infraRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import parking.domain.models.SolicitudesReservas;

public interface SolicitudesReservasRepository extends JpaRepository<SolicitudesReservas, Integer> {
}
