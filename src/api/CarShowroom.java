package api;

import java.util.*;
import java.util.stream.Collectors;

public class
CarShowroom implements Comparator<String> {

    String CarCenterName;
    Map<Vehicle, Integer> vehicles;
    int maxVehiclesInCarCenter;

    public CarShowroom(String CarCenterName, int maxVehiclesInCarCenter) {
        this.CarCenterName = CarCenterName;
        this.maxVehiclesInCarCenter = maxVehiclesInCarCenter;
        vehicles = new HashMap<>();
    }

    public int getVehiclesCount() {
        int count = 0;
        for (Map.Entry<Vehicle, Integer> entry : vehicles.entrySet())
            count += entry.getValue();
        return count;
    }

    public void addVehicle(Vehicle vehicle) {
        if (getVehiclesCount() == this.maxVehiclesInCarCenter) {
            System.out.println("Too many vehicles");
        }
        if (checkIfVehicleExists(vehicle)!=null) {
            int count = getVehicleCount(vehicle);
            vehicles.put(vehicle, count + 1);
        }
        else{
            vehicles.put(vehicle,1);
        }
        vehicle.setCarShowroom(this);
    }

    public void getProduct(Vehicle vehicle) {
        if (checkIfVehicleExists(vehicle)==null) {
            System.out.println("Not found.");
        } else {
            int count = getVehicleCount(vehicle);
            if (count == 1)
                vehicles.remove(vehicle);
            else
                vehicles.replace(vehicle, count - 1);
        }
    }

    public void removeProduct(Vehicle vehicle) {
        if (!vehicles.containsKey(vehicle)) {
            System.out.println("Not found.");
        } else {
            vehicles.remove(vehicle);
        }
    }


    public Vehicle search(String model) {
        for (Map.Entry<Vehicle, Integer> entry : vehicles.entrySet()) {
            if (compare(entry.getKey().model, model) == 0) {
                return (Vehicle) entry;
            }
        }
        return null;
    }

    public long countByCondition(ItemCondition condition) {
        return vehicles.entrySet()
                .stream()
                .filter(v -> v.getKey().condition == condition)
                .count();
    }

    public void summary() {
        for (Map.Entry<Vehicle, Integer> entry : vehicles.entrySet()) {
            System.out.println(entry.getKey().print());
        }
    }

    public List<Vehicle> sortByName() {
        List<Vehicle> sortedVehicleListByName = getListOfVehicles();
        Collections.sort(sortedVehicleListByName, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle vehicle1, Vehicle vehicle2) {
                return vehicle1.brand.compareTo(vehicle2.brand);
            }
        });
        return sortedVehicleListByName;
    }

    public Map<Vehicle, Integer> sortByAmount() {
        return vehicles.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public List<Vehicle> getListOfVehicles() {
        List<Vehicle> vehicleListByName = new ArrayList<>();
        for (Map.Entry<Vehicle, Integer> entry : vehicles.entrySet())
            vehicleListByName.add(entry.getKey());
        return vehicleListByName;
    }

    public int max() {
        return Collections.max(vehicles.values());
    }

    public Vehicle checkIfVehicleExists(Vehicle v){
        return vehicles.keySet()
                .stream()
                .filter(e -> (e.brand.equals(v.brand) && e.model.equals(v.model)))
                .findFirst()
                .orElse(null);
    }
    public int getVehicleCount(Vehicle v){
        return  vehicles.entrySet()
                .stream()
                .filter(e -> (e.getKey().brand.equals(v.brand) && e.getKey().model.equals(v.model)))
                .findFirst().get().getValue();

    }

    public void setVehicles(Map<Vehicle, Integer> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public int compare(String v1, String v2) {
        return v1.compareTo(v2);
    }

    public String getCarCenterName() {
        return CarCenterName;
    }

    public Map<Vehicle, Integer> getVehicles() {
        return vehicles;
    }

    public int getMaxVehiclesInCarCenter() {
        return maxVehiclesInCarCenter;
    }
}