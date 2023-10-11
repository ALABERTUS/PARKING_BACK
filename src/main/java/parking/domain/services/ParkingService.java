package parking.domain.services;

import org.springframework.stereotype.Service;

@Service
public class ParkingService {
    public List<Usuarios> getUsuarios(){
        return Liss.of{
            new Usuarios(
                    id 1,


            )
        }
    }
}
