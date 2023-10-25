package parking.infraRepositories.Data;

import parking.domain.models.Plazas;
import parking.domain.models.Rol;
import parking.domain.models.Usuarios;
import parking.infraRepositories.PlazasRepository;
import parking.infraRepositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import parking.infraRepositories.UsuariosRepository;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PlazasRepository plazasRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

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

        Usuarios usuarios = new Usuarios();
        usuarios.setId(1);
        usuarios.setNombre("Raul");
        usuarios.setEmail("Manolito@manolito");
        usuarios.setDni("454545464l");
        usuarios.setTelefono("55156444");
        usuarios.setRol("usuario");
        usuariosRepository.save(usuarios);
    }
}

