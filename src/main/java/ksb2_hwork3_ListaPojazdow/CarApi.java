package ksb2_hwork3_ListaPojazdow;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarApi {

    private List<Car> carList;

    public CarApi() {
        this.carList = new ArrayList<>();
        carList.add(new Car(1, "Fiat", "Bravo", "gray"));
        carList.add(new Car(2, "Ford", "Focus", "white"));
        carList.add(new Car(3, "Opel", "Astra", "red"));
    }

    @GetMapping(produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Car>> getVehicles() {
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> getVehiclesById(@PathVariable int id) {
        Optional<Car> first = carList.stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

        @PatchMapping("/{id}/{color}")
        public ResponseEntity modVehicleElement(@PathVariable long id, @PathVariable String color){
            Optional<Car> firstCar = carList.stream().filter(carFromList -> carFromList.getId() == id).findFirst();
            if(firstCar.isPresent()){
                firstCar.get().setColor(color);
                return new ResponseEntity(HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    @PostMapping
    public ResponseEntity addVehicle(@RequestBody Car car) {
        boolean add = carList.add(car);
        if (add) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
}
    public ResponseEntity modVehicle(@RequestBody Car newCar) {
        Optional<Car> first = carList.stream().filter(car -> car.getId() == newCar.getId()).findFirst();
        if (first.isPresent()) {
            carList.remove(first.get());
            carList.add(newCar);

            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity removeVehicle(@PathVariable int id) {
        Optional<Car> first = carList.stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            carList.remove(first.get());
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
