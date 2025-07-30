package practice1;



//Base class
class MyVehicle17 {
 String color;
 int wheels;
 String model;

 public MyVehicle17(String color, int wheels, String model) {
     this.color = color;
     this.wheels = wheels;
     this.model = model;
 }

 public void displayInfo() {
     System.out.println("Model: " + model + ", Color: " + color + ", Wheels: " + wheels);
 }

 public void start() {
     System.out.println(model + " is starting.");
 }

 public void stop() {
     System.out.println(model + " is stopping.");
 }
}

//Truck class
class MyTruck17 extends MyVehicle17 {
 public MyTruck17(String color, int wheels, String model) {
     super(color, wheels, model);
 }

 @Override
 public void start() {
     System.out.println(model + " is starting with heavy load.");
 }

 @Override
 public void stop() {
     System.out.println(model + " is stopping slowly due to heavy weight.");
 }

 public void loadCargo() {
     System.out.println(model + " is loading cargo.");
 }
}

//Bus class
class MyBus17 extends MyVehicle17 {
 public MyBus17(String color, int wheels, String model) {
     super(color, wheels, model);
 }

 @Override
 public void start() {
     System.out.println(model + " is starting with passengers.");
 }

 @Override
 public void stop() {
     System.out.println(model + " is stopping at the bus stop.");
 }

 public void pickPassengers() {
     System.out.println(model + " is picking up passengers.");
 }
}

//Car class
class MyCar17 extends MyVehicle17 {
 public MyCar17(String color, int wheels, String model) {
     super(color, wheels, model);
 }

 @Override
 public void start() {
     System.out.println(model + " is starting with a smooth engine.");
 }

 @Override
 public void stop() {
     System.out.println(model + " is stopping with ABS brakes.");
 }

 public void playMusic() {
     System.out.println(model + " is playing music.");
 }
}

public class VehicleSeventeen {
 public static void main(String[] args) {
     MyTruck17 truck = new MyTruck17("Red", 6, "TATA HeavyTruck");
     MyBus17 bus = new MyBus17("Yellow", 4, "Volvo Bus");
     MyCar17 car = new MyCar17("Blue", 4, "Honda City");

     System.out.println("--- Truck ---");
     truck.displayInfo();
     truck.start();
     truck.loadCargo();
     truck.stop();

     System.out.println("\n--- Bus ---");
     bus.displayInfo();
     bus.start();
     bus.pickPassengers();
     bus.stop();

     System.out.println("\n--- Car ---");
     car.displayInfo();
     car.start();
     car.playMusic();
     car.stop();
 }
}
/*--- Truck ---
Model: TATA HeavyTruck, Color: Red, Wheels: 6
TATA HeavyTruck is starting with heavy load.
TATA HeavyTruck is loading cargo.
TATA HeavyTruck is stopping slowly due to heavy weight.

--- Bus ---
Model: Volvo Bus, Color: Yellow, Wheels: 4
Volvo Bus is starting with passengers.
Volvo Bus is picking up passengers.
Volvo Bus is stopping at the bus stop.

--- Car ---
Model: Honda City, Color: Blue, Wheels: 4
Honda City is starting with a smooth engine.
Honda City is playing music.
Honda City is stopping with ABS brakes.
*/
