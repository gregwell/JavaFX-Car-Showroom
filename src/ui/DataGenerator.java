package ui;

import api.ItemCondition;
import api.CarShowroom;
import api.CarShowroomContainer;
import api.Vehicle;

public class DataGenerator {

    public static CarShowroomContainer loadData() {
        CarShowroomContainer carShowroomContainer = new CarShowroomContainer();
        CarShowroom carShowroom1 = new CarShowroom("Drogie ale wolmne Auta", 16);
        CarShowroom carShowroom2 = new CarShowroom("Salon braci Kaczynskich", 12);
        CarShowroom carShowroom3 = new CarShowroom("Fiat Seicento jaktalala", 6);
        CarShowroom carShowroom4 = new CarShowroom("Voyage", 20);

        carShowroom1.addVehicle(new Vehicle("Fiat", "Stilo", ItemCondition.NEW, 200000, 2019, 10, 200));
        carShowroom1.addVehicle(new Vehicle("Fiat", "Stilo", ItemCondition.NEW, 200000, 2019, 10, 200));
        carShowroom1.addVehicle(new Vehicle("Fiat", "Stilo", ItemCondition.NEW, 200000, 2019, 10, 200));
        carShowroom2.addVehicle(new Vehicle("Fiat", "Multipla", ItemCondition.USED, 30000, 2011, 321312, 200));
        carShowroom1.addVehicle(new Vehicle("Fiat", "Multipla", ItemCondition.USED, 30000, 2011, 321312, 200));
        carShowroom1.addVehicle(new Vehicle("Fiat", "Stilo", ItemCondition.NEW, 200000, 2019, 10, 200));
        carShowroom3.addVehicle(new Vehicle("Audi", "A3", ItemCondition.NEW, 100000, 2018, 15, 150));
        carShowroom1.addVehicle(new Vehicle("Fiat", "Uno", ItemCondition.DAMAGED, 15000, 2010, 112372, 500));
        carShowroom1.addVehicle(new Vehicle("Fiat", "Uno", ItemCondition.DAMAGED, 15000, 2010, 112372, 500));
        carShowroom3.addVehicle(new Vehicle("Fiat", "Seicento", ItemCondition.USED, 30000, 2009, 3546, 100));
        carShowroom4.addVehicle(new Vehicle("Opel", "Corsa", ItemCondition.USED, 2000, 2009, 30292, 80));
        carShowroom4.addVehicle(new Vehicle("Fiat", "Seicento", ItemCondition.NEW, 3000, 2020, 10, 115));

        carShowroomContainer.addCenter(carShowroom1, 16);
        carShowroomContainer.addCenter(carShowroom2, 12);
        carShowroomContainer.addCenter(carShowroom3, 6);
        carShowroomContainer.addCenter(carShowroom4,20);

        Vehicle v1 = new Vehicle("Fiat", "Seicento", ItemCondition.USED, 600, 2001, 100732, 1.0);
        Vehicle v2 = new Vehicle("Renault", "Clio", ItemCondition.NEW, 30250, 2019, 0, 2.0);
        Vehicle v3 = new Vehicle("Renault", "Clio", ItemCondition.USED, 21000, 2014, 44555, 2.3);
        Vehicle v4 = new Vehicle("Ford", "Fiesta", ItemCondition.NEW, 50250, 2020, 0, 1.6);
        Vehicle v5 = new Vehicle("Volvo", "XC40", ItemCondition.NEW, 70222, 2020, 0, 2.5);
        Vehicle v6 = new Vehicle("Volvo", "XC60", ItemCondition.NEW, 90560, 2020, 0, 2.8);

        CarShowroom w = new CarShowroom("WCTS. Wiejskie Centrum Tanich Samochodow", 10);
        w.addVehicle(v1);
        w.addVehicle(v2);
        w.addVehicle(v3);
        w.addVehicle(v4);
        w.addVehicle(v5);
        w.addVehicle(v6);
        w.addVehicle(v6);

        Vehicle v7 = new Vehicle("Fiat", "Seicento", ItemCondition.USED, 1150, 2006, 160732, 1.0);
        Vehicle v8 = new Vehicle("Renault", "Clio", ItemCondition.DAMAGED, 5000, 2005, 300250, 2.0);
       // Vehicle v9 = new Vehicle("Renault", "Clio", ItemCondition.USED, 21000, 2014, 44555, 2.3);
        Vehicle v10 = new Vehicle("Ford", "Fiesta", ItemCondition.USED, 10500, 1999, 250567, 1.6);
        Vehicle v11 = new Vehicle("Volvo", "XC40", ItemCondition.USED, 45250, 2016, 70232, 2.5);
        Vehicle v12 = new Vehicle("Volvo", "XC60", ItemCondition.USED, 50233, 2016, 111200, 2.8);
        Vehicle v13 = new Vehicle("Volvo", "XC60", ItemCondition.USED, 50233, 2016, 111200, 2.8);
        Vehicle v14 = new Vehicle("Volvo", "XC60", ItemCondition.USED, 50233, 2016, 111200, 2.8);
        Vehicle v15 = new Vehicle("Volvo", "XC60", ItemCondition.USED, 50233, 2016, 111200, 2.8);

        CarShowroom m = new CarShowroom("McDonalds Samochody Polska", 120);
        m.addVehicle(v7);
        m.addVehicle(v8);
        //m.addVehicle(v9);
        m.addVehicle(v10);
        m.addVehicle(v11);
        m.addVehicle(v12);
        m.addVehicle(v13);
        m.addVehicle(v14);
        m.addVehicle(v15);

        carShowroomContainer.addCenter(m, 10);
        carShowroomContainer.addCenter(w, 120);

        return carShowroomContainer;
    }
}
