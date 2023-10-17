package parking.infraRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parking.domain.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

}
