package ksb2_hwork3_ListaPojazdow;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleApi {

    private List<Vehicle> vehicleList;

    public VehicleApi() {
        this.vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle(1, "Fiat", "Bravo", "gray"));
        vehicleList.add(new Vehicle(2, "Ford", "Focus", "white"));
        vehicleList.add(new Vehicle(3, "Opel", "Astra", "red"));
    }

    @GetMapping(produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Vehicle>> getVehicles() {
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Vehicle> getVehiclesById(@PathVariable int id) {
        Optional<Vehicle> first = vehicleList.stream().filter(vehicle -> vehicle.getId() == id).findFirst();
        if (first.isPresent()) {
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

        @PatchMapping("/{id}/{color}")
        public ResponseEntity modVehicleElement(@PathVariable long id, @PathVariable String color){
            Optional<Vehicle> firstCar = vehicleList.stream().filter(carFromList -> carFromList.getId() == id).findFirst();
            if(firstCar.isPresent()){
                firstCar.get().setColor(color);
                return new ResponseEntity(HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    @PostMapping
    public ResponseEntity addVehicle(@RequestBody Vehicle vehicle) {
        boolean add = vehicleList.add(vehicle);
        if (add) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
}
    public ResponseEntity modVehicle(@RequestBody Vehicle newVehicle) {
        Optional<Vehicle> first = vehicleList.stream().filter(vehicle -> vehicle.getId() == newVehicle.getId()).findFirst();
        if (first.isPresent()) {
            vehicleList.remove(first.get());
            vehicleList.add(newVehicle);

            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity removeVehicle(@PathVariable int id) {
        Optional<Vehicle> first = vehicleList.stream().filter(vehicle -> vehicle.getId() == id).findFirst();
        if (first.isPresent()) {
            vehicleList.remove(first.get());
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
