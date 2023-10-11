package apiControllers.controllers;

import apiControllers.domain.models.State;
import apiControllers.domain.services.StateService;
import apiControllers.springframework.beans.factory.annotation.Autowired;
import apiControllers.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "api/parking/states")
public class StateController {
    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    public void addStateController(@RequestBody State state) {
        stateService.addState(state);
    }
}