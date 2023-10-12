package parking.domain.services;

import parking.domain.models.Usuarios;
import java.util.ArrayList;
import java.util.List;

public class UsuariosServices {
    private List<Usuarios> usuariosList = new ArrayList<>();
    private Integer idGenerator = 1;

    public void crearUsuario(Usuarios usuario) {
        usuario.setId(idGenerator++);
        usuariosList.add(usuario);
    }

    public Usuarios obtenerUsuarioPorId(Integer id) {
        for (Usuarios usuario : usuariosList) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public void actualizarUsuario(Usuarios usuarioActualizado) {
        for (Usuarios usuario : usuariosList) {
            if (usuarioActualizado.getId().equals(usuario.getId())) {
                usuario.setNombre(usuarioActualizado.getNombre());
                usuario.setEmail(usuarioActualizado.getEmail());
                usuario.setDni(usuarioActualizado.getDni());
                usuario.setTelefono(usuarioActualizado.getTelefono());
                usuario.setRol(usuarioActualizado.getRol());
            }
        }
    }

    public void eliminarUsuario(Integer id) {
        usuariosList.removeIf(usuarios -> usuarios.getId().equals(id));
    }

    public List<Usuarios> obtenerTodosLosUsuarios(){
        return usuariosList;
    }

    public static void main(String[] args) {
        UsuariosServices usuariosServices = new UsuariosServices();

        Usuarios usuario1 = new Usuarios();
        usuariosServices.crearUsuario(usuario1);

        Usuarios usuarioRecuperado = usuariosServices.obtenerUsuarioPorId(1);

        Usuarios usuarioActualizado = new Usuarios();
        usuariosServices.actualizarUsuario(usuarioActualizado);
        System.out.println(usuariosServices.obtenerUsuarioPorId(1));

        usuariosServices.eliminarUsuario(1);
        System.out.println(usuariosServices.obtenerUsuarioPorId(1));

        List<Usuarios> todosLosUsuarios = usuariosServices.obtenerTodosLosUsuarios();
        todosLosUsuarios.forEach(System.out::println);
    }
}
