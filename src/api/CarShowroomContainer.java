package api;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class CarShowroomContainer implements Serializable {

    Map<String, CarShowroom> CarCenters;

    public CarShowroomContainer() {
        CarCenters = new LinkedHashMap<>();
    }

    public void addCenter(CarShowroom carShowroom, int max) {
        carShowroom.maxVehiclesInCarCenter = max;
        CarCenters.put(carShowroom.CarCenterName, carShowroom);
    }

    public void removeCenter(String name) {
        CarCenters.remove(name);
    }

    public List<CarShowroom> findEmpty() {
        return CarCenters.values()
                .stream()
                .filter(s -> s.getVehiclesCount() == 0)
                .collect(Collectors.toList());
    }

    public Map<String, Double> summary() {
        Map<String, Double> percentageFilling = new HashMap<>();
        for (Map.Entry<String, CarShowroom> entry : CarCenters.entrySet()) {
            double tempFilling = (entry.getValue().getVehiclesCount() / (double) entry.getValue().maxVehiclesInCarCenter) * 100;
            percentageFilling.put(entry.getKey(), tempFilling);
        }
        return percentageFilling;
    }

    public List<Vehicle> getVehicleListByCarCenterName(String CarCenterName) {
        CarShowroom carShowroom = (CarShowroom) CarCenters.values().stream()
                .filter(cs -> cs.getCarCenterName().equals(CarCenterName));
        return carShowroom.getListOfVehicles();
    }

    public int getCarShowRoomsSize() {
        return CarCenters.size();
    }

    public List<CarShowroom> getCarShowrooms() {
        return new ArrayList<>(CarCenters.values());
    }

    public Map<String,CarShowroom> getCarShowroomsMap(){
        return this.CarCenters;
    }

    public CarShowroom getCarshowroomByName(String name){
        return CarCenters.values().stream()
                .filter(carShowroom -> carShowroom.getCarCenterName().equals(name))
                .findFirst()
                .get();
    }



}
