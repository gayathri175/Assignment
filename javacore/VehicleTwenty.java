package practice1;


abstract class BaseVehicle {
 abstract void startEngine();
 abstract void stopEngine();
}

class MyCar extends BaseVehicle {
 @Override
 void startEngine() {
     System.out.println("MyCar engine started with a key ignition.");
 }

 @Override
 void stopEngine() {
     System.out.println("MyCar engine stopped by turning off the key.");
 }
}


class MyMotorcycle extends BaseVehicle {
 @Override
 void startEngine() {
     System.out.println("MyMotorcycle engine started with a kick or self-start.");
 }

 @Override
 void stopEngine() {
     System.out.println("MyMotorcycle engine stopped by turning off the switch.");
 }
}


public class VehicleTwenty {
 public static void main(String[] args) {
     BaseVehicle car = new MyCar();
     BaseVehicle bike = new MyMotorcycle(); 

     System.out.println("---- Car ----");
     car.startEngine();
     car.stopEngine();

     System.out.println("\n---- Motorcycle ----");
     bike.startEngine();
     bike.stopEngine();
 }
}
/*--- Car ----
MyCar engine started with a key ignition.
MyCar engine stopped by turning off the key.

---- Motorcycle ----
MyMotorcycle engine started with a kick or self-start.
MyMotorcycle engine stopped by turning off the switch.*/
