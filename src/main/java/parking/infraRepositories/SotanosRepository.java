package parking.infraRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parking.domain.models.Sotanos;

@Repository
public interface SotanosRepository extends JpaRepository<Sotanos, Long> {
    // Puedes definir consultas personalizadas si es necesario
}
