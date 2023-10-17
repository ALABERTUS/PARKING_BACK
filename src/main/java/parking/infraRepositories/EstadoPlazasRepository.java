package parking.infraRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parking.domain.models.EstadoPlazas;

@Repository
public interface EstadoPlazasRepository extends JpaRepository<EstadoPlazas, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
