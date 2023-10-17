package parking.infraRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parking.domain.models.SolicitudesReservas;

@Repository
public interface SolicitudesReservasRepository extends JpaRepository<SolicitudesReservas, Integer> {

}
