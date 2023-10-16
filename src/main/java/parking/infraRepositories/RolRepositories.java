package parking.infraRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import parking.domain.models.Rol;

public interface RolRepositories extends JpaRepository<Rol, Integer> {
}
