package api;

import java.util.Objects;

public class Vehicle implements Comparable<Vehicle> {

    String brand;
    String model;
    ItemCondition condition;
    double price;
    int prodYear;
    double progress;
    double engineCapacity;
    CarShowroom carShowroom;

    public Vehicle(String brand, String model, ItemCondition condition, double price, int prodYear, double progress, double engineCapacity) {
        this.brand = brand;
        this.model = model;
        this.condition = condition;
        this.price = price;
        this.prodYear = prodYear;
        this.progress = progress;
        this.engineCapacity = engineCapacity;
    }

    public Vehicle(String model) {
        this.model = model;
    }

    public String print() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", condition=" + condition +
                ", price=" + price +
                ", prodYear=" + prodYear +
                ", progress=" + progress +
                ", engineCapacity=" + engineCapacity +
                '}';
    }

    @Override
    public int compareTo(Vehicle vehicle) {
        return vehicle.brand.equals(this.brand) &&
                vehicle.model.equals(this.model) ? 1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.price, price) == 0 &&
                prodYear == vehicle.prodYear &&
                Double.compare(vehicle.progress, progress) == 0 &&
                Double.compare(vehicle.engineCapacity, engineCapacity) == 0 &&
                Objects.equals(brand, vehicle.brand) &&
                Objects.equals(model, vehicle.model) &&
                condition == vehicle.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, condition, price, prodYear, progress, engineCapacity);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getName() { return brand+" "+model;}

    public ItemCondition getCondition() {
        return condition;
    }

    public double getPrice() {
        return price;
    }

    public int getProdYear() {
        return prodYear;
    }

    public double getProgress() {
        return progress;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setCarShowroom(CarShowroom cs) {
        this.carShowroom = cs;
    }

    public CarShowroom getCarShowroom() {
        return carShowroom;
    }
}
