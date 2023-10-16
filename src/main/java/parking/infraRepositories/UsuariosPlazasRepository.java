package parking.infraRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import parking.domain.models.UsuariosPlazas;
public interface UsuariosPlazasRepository extends JpaRepository<UsuariosPlazas, Integer> {
}
