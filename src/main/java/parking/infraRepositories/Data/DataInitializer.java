package parking.infraRepositories.Data;

import parking.domain.models.Plazas;
import parking.domain.models.Rol;
import parking.infraRepositories.PlazasRepository;
import parking.infraRepositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PlazasRepository plazasRepository;

    @Override
    public void run(String... args) throws Exception {

        Rol rol = new Rol();
        rol.setId(1); // Cambiado a un número si id es numérico
        rol.setNombreRol("Administrador");
        rolRepository.save(rol);


        Plazas plazas = new Plazas();
        plazas.setId(1);
        plazas.setNumeroPlazas("75");
        plazas.setSotano("1");
        plazas.setDisponible(true);
        plazas.setPropietario("si");
        plazasRepository.save(plazas);
    }
}
