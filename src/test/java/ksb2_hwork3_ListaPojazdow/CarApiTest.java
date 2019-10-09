package ksb2_hwork3_ListaPojazdow;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CarApiTest {

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
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(5,"Mazda", "3", "Black"));
        //when
        Car id = carList.get(5);

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
