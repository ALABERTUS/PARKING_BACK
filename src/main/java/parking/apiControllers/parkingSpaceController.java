package apiControllers.controllers;


        import apiControllers.domain.models.ParkingSpace;
        import apiControllers.domain.services.ParkingSpaceService;
        import apiControllers.web.bind.annotation.*;

        import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "api/parking/parkings")
public class ParkingSpaceController {
    private final ParkingSpaceService parkingSpaceService;

    public ParkingSpaceController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @GetMapping()
    public List<ParkingSpace> getParkingSpacesController(){
        return parkingSpaceService.getParkingSpaces();
    }

    @PostMapping()
    public void postParkingSpaceController(@RequestBody ParkingSpace parkingSpace) {
        parkingSpaceService.addParkingSpace(parkingSpace);
    }
}