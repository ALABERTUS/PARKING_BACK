package parking.infraRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parking.domain.models.Plazas;
@Repository
public interface PlazasRepository extends JpaRepository<Plazas, Integer> {
}

