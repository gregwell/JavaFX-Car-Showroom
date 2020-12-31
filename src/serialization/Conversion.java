package serialization;

import api.CarShowroom;
import api.ItemCondition;
import api.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Conversion {


    private static final String serializedObjectDataFile = "data.ser";
    private static final String cartFile = "cart.csv";

    public void serialize(Serializable ser) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(serializedObjectDataFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(ser);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Serializable deserialize() {
        Serializable ser = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(serializedObjectDataFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ser = (Serializable) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ser;
    }

    public void saveCarShowroom(CarShowroom carShowroom) {
        try {
            final String fileName = carShowroom.getCarCenterName()+".csv";
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
            List<Vehicle> vehicles = carShowroom.getListOfVehicles();
            for(Vehicle vehicle : vehicles) {
                writeCar(vehicle, bufferedWriter);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void writeCar(Vehicle vehicle, BufferedWriter bufferedWriter) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(vehicle.getBrand()).append(";");
        stringBuffer.append(vehicle.getModel()).append(";");
        stringBuffer.append(vehicle.getProdYear()).append(";");
        stringBuffer.append(vehicle.getEngineCapacity()).append(";");
        stringBuffer.append(vehicle.getProgress()).append(";");
        stringBuffer.append(vehicle.getPrice()).append(";");
        bufferedWriter.write(bufferedWriter.toString());
        bufferedWriter.newLine();
    }

    public void saveVehiclesCart(List<Vehicle> vehicles) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(cartFile);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
            for (Vehicle vehicle : vehicles) {
                writeCar(vehicle, bufferedWriter);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Vehicle> readCartFromFile(List<Vehicle> vehicles) {
        List<Vehicle> vehicleList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(cartFile));
            String row;
            while((row = bufferedReader.readLine()) != null) {
                String[] arr = row.split(";");
                String brand = arr[0];
                String model = arr[1];
                int prodYear = Integer.parseInt(arr[2]);
                double engineCapacity = Double.parseDouble(arr[3]);
                double progress = Double.parseDouble(arr[4]);
                double price = Double.parseDouble(arr[5]);

                for (Vehicle vehicle : vehicles) {
                    if(vehicle.getBrand().equals(brand) &&
                            vehicle.getModel().equals(model) &&
                            vehicle.getProdYear() == prodYear &&
                            vehicle.getEngineCapacity() == engineCapacity &&
                            vehicle.getProgress() == progress &&
                            vehicle.getPrice() == price)
                    {
                        vehicleList.add(vehicle);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicleList;
    }

    public List<Vehicle> readCarShowroom(CarShowroom carShowroom) {
        final String fileName = carShowroom.getCarCenterName()+".csv";
        List<Vehicle> vehiclesList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String row;
            while((row=bufferedReader.readLine()) != null) {
                String[] arr = row.split(";");
                String brand = arr[0];
                String model = arr[1];
                int prodYear = Integer.parseInt(arr[2]);
                double engineCapacity = Double.parseDouble(arr[3]);
                double progress = Double.parseDouble(arr[4]);
                double price = Double.parseDouble(arr[5]);
                Vehicle vehicle = new Vehicle(brand, model, ItemCondition.NEW, price, prodYear, progress, engineCapacity);
                vehicle.setCarShowroom(carShowroom);
                vehiclesList.add(vehicle);
            }


        } catch(IOException e) {
            e.printStackTrace();
        }
        return vehiclesList;
    }

}
