package parking.infraRepositories.Data;

import parking.domain.models.*;
import parking.infraRepositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PlazasRepository plazasRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private SolicitudesReservasRepository solicitudesReservasRepository;

    @Autowired
    private SotanosRepository sotanosRepository;



    @Override
    public void run(String... args) throws Exception {
        Rol rol = new Rol();
        rol.setId(1);
        rol.setNombreRol("Administrador");
        rolRepository.save(rol);

        Rol rol1 = new Rol();
        rol1.setId(2);
        rol1.setNombreRol("Solicitante");
        rolRepository.save(rol1);

        Rol rol2 = new Rol();
        rol2.setId(3);
        rol2.setNombreRol("Propietario");
        rolRepository.save(rol2);


        Plazas plazas = new Plazas();
        plazas.setId(1);
        plazas.setNumeroPlazas("75");
        plazas.setSotano("1");
        plazas.setDisponible(true);
        plazas.setPropietario("Juan valdes");
        plazasRepository.save(plazas);

        Usuarios usuarios = new Usuarios();
        usuarios.setId(1);
        usuarios.setNombre("Raul");
        usuarios.setEmail("Manolito@manolito");
        usuarios.setDni("454545464l");
        usuarios.setTelefono("55156444");
        usuarios.setRol("usuario");
        usuariosRepository.save(usuarios);

        SolicitudesReservas solicitudesReservas = new SolicitudesReservas();
        solicitudesReservas.setId(1);
        solicitudesReservas.setFecha("15/02/80 ");
        solicitudesReservas.setEstado("ocupada");
        solicitudesReservasRepository.save(solicitudesReservas);

        Sotanos sotanos = new Sotanos();
        sotanos.setId(1);
        sotanos.setNumeroSotano("2");
        sotanos.setNumeroPlaza("73");
        sotanosRepository.save(sotanos);


    }
}

