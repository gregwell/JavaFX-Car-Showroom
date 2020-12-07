package ui;

import api.ItemCondition;
import api.CarShowroom;
import api.CarShowroomContainer;
import api.Vehicle;

public class DataGenerator {

    public static CarShowroomContainer loadData() {
        CarShowroomContainer carShowroomContainer = new CarShowroomContainer();
        CarShowroom carShowroom1 = new CarShowroom("Kovalski Saloon", 16);
        CarShowroom carShowroom2 = new CarShowroom("Novak Saloon", 12);
        CarShowroom carShowroom3 = new CarShowroom("Black Saloon", 6);
        CarShowroom carShowroom4 = new CarShowroom("Modern Saloon", 20);

        carShowroom1.addVehicle(new Vehicle("Tesla", "MODEL S", ItemCondition.NEW, 200000, 2019, 10, 200));
        carShowroom2.addVehicle(new Vehicle("BMW", "x4", ItemCondition.USED, 30000, 2011, 321312, 200));
        carShowroom1.addVehicle(new Vehicle("BMW", "x4", ItemCondition.USED, 30000, 2011, 321312, 200));
        carShowroom1.addVehicle(new Vehicle("Tesla", "MODEL S", ItemCondition.NEW, 200000, 2019, 10, 200));
        carShowroom2.addVehicle(new Vehicle("Audi", "A3", ItemCondition.NEW, 100000, 2018, 15, 150));
        carShowroom2.addVehicle(new Vehicle("Ferrari", "California", ItemCondition.DAMAGED, 15000, 2010, 112372, 500));
        carShowroom3.addVehicle(new Vehicle("Voklkswagen", "T4", ItemCondition.USED, 30000, 2009, 3546, 100));
        carShowroom4.addVehicle(new Vehicle("Opel", "Signum", ItemCondition.USED, 2000, 2009, 30292, 80));
        carShowroom4.addVehicle(new Vehicle("Alfa Romeo", "Mito", ItemCondition.NEW, 30000, 2020, 10, 115));

        carShowroomContainer.addCenter(carShowroom1, 16);
        carShowroomContainer.addCenter(carShowroom2, 12);
        carShowroomContainer.addCenter(carShowroom3, 6);
        carShowroomContainer.addCenter(carShowroom4,20);
        return carShowroomContainer;
    }
}
