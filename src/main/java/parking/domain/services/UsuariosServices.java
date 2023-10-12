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
            Integer idUsuario = usuario.getId();
            if (idUsuario != null && idUsuario.equals(usuarioActualizado.getId())) {
                usuario.setNombre(usuarioActualizado.getNombre());
                usuario.setEmail(usuarioActualizado.getEmail());
                usuario.setDni(usuarioActualizado.getDni());
                usuario.setTelefono(usuarioActualizado.getTelefono());
                usuario.setRol(usuarioActualizado.getRol());
                return;
            }
        }
    }

    public void eliminarUsuario(Integer id) {
        usuariosList.removeIf(usuarios -> usuarios.getId().equals(id));
    }

    public List<Usuarios> obtenerTodosLosUsuarios() {
        return usuariosList;
    }

    public static void main(String[] args) {
        UsuariosServices usuariosServices = new UsuariosServices();

        // Crear un usuario
        Usuarios usuario1 = new Usuarios("Usuario 1", "usuario1@example.com", "12345678X", 123456789, "Rol 1");
        usuariosServices.crearUsuario(usuario1);

        // Obtener y mostrar el usuario
        Usuarios usuarioRecuperado = usuariosServices.obtenerUsuarioPorId(1);
        System.out.println(usuarioRecuperado);

        // Actualizar el usuario
        Usuarios usuarioActualizado = new Usuarios(1, "Nuevo Nombre", "nuevo@email.com", "87654321X", 987654321, "Nuevo Rol");
        usuariosServices.actualizarUsuario(usuarioActualizado);

        // Obtener y mostrar el usuario actualizado
        Usuarios usuarioActualizadoRecuperado = usuariosServices.obtenerUsuarioPorId(1);
        System.out.println(usuarioActualizadoRecuperado);

        // Eliminar el usuario
        usuariosServices.eliminarUsuario(1);

        // Intentar obtener el usuario eliminado (debería ser nulo)
        Usuarios usuarioEliminado = usuariosServices.obtenerUsuarioPorId(1);
        System.out.println(usuarioEliminado);

        // Obtener y mostrar todos los usuarios
        List<Usuarios> todosLosUsuarios = usuariosServices.obtenerTodosLosUsuarios();
        todosLosUsuarios.forEach(System.out::println);
    }
}


