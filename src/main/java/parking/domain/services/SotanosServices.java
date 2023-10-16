package parking.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parking.domain.models.Sotanos;
import parking.infraRepositories.SotanosRepository;

import java.util.List;

@Service
public class SotanosServices {

    private final SotanosRepository sotanosRepository;

    @Autowired
    public SotanosServices(SotanosRepository sotanosRepository) {
        this.sotanosRepository = sotanosRepository;
    }

    public List<Sotanos> listarSotanos() {
        return sotanosRepository.findAll();
    }

    public Sotanos obtenerSotanoPorId(Integer id) {
        return sotanosRepository.findById(id).orElse(null);
    }

    public Sotanos crearSotano(Sotanos sotano) {
        return sotanosRepository.save(sotano);
    }

    public Sotanos actualizarSotano(Integer id, Sotanos sotanoActualizado) {
        sotanoActualizado.setId(id);
        return sotanosRepository.save(sotanoActualizado);
    }

    public void eliminarSotano(Integer id) {
        sotanosRepository.deleteById(id);
    }
}

