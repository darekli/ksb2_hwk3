package ksb2_hwork3_ListaPojazdow;

import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleApiTest {

    @Test
    void getVehicles() {
        //given

        //when

        //then

    }

    @Test
    void getVehiclesById() {
        //given

        //when

        //then
    }

    @Test
    void modVehicleElement() {
        //given

        //when

        //then
    }

    @Test
    void addVehicle() {
        //given
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle(5,"Mazda", "3", "Black"));
        //when
        Vehicle id = vehicleList.get(5);

        //then
      //  assertArrayEquals(5,);
    }

    @Test
    void modVehicle() {
        //given

        //when

        //then
    }

    @Test
    void removeVehicle() {
        //given

        //when

        //then
    }
}