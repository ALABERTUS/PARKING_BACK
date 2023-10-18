package parking.domain.services;

import org.springframework.stereotype.Service;
import parking.domain.models.PlazasEstados;
import parking.infraRepositories.PlazasEstadosRepository;

import java.util.List;

@Service
public class PlazasEstadosService {
    private final PlazasEstadosRepository plazasEstadosRepository;

    public PlazasEstadosService(PlazasEstadosRepository plazasEstadosRepository) {
        this.plazasEstadosRepository = plazasEstadosRepository;
    }

    public void crearPlazasEstados(PlazasEstados plazasEstados) {
        plazasEstadosRepository.save(plazasEstados);
    }

    public PlazasEstados obtenerPlazasEstadosPorId(Integer id) {
        return plazasEstadosRepository.findById(id).orElse(null);
    }

    public void actualizarPlazasEstados(PlazasEstados plazasEstadosActualizado) {
        plazasEstadosRepository.save(plazasEstadosActualizado);
    }

    public void eliminarPlazasEstados(Integer id) {
        plazasEstadosRepository.deleteById(id);
    }

    public List<PlazasEstados> obtenerTodasLasPlazasEstados() {
        return plazasEstadosRepository.findAll();
    }
}
