package parking.infraRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parking.domain.models.UsuariosPlazas;

@Repository
public interface UsuariosPlazasRepository extends JpaRepository<UsuariosPlazas, Integer> {
    // Puedes definir consultas personalizadas si es necesario
}
