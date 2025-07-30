package practice1;

abstract class Person {
 abstract void eat();
 abstract void exercise();
}


class Athlete extends Person {
 @Override
 void eat() {
     System.out.println("Athlete eats a high-protein and balanced diet.");
 }

 @Override
 void exercise() {
     System.out.println("Athlete exercises daily with intense workouts and cardio.");
 }
}


class LazyPerson extends Person {
 @Override
 void eat() {
     System.out.println("Lazy person eats fast food and snacks all day.");
 }

 @Override
 void exercise() {
     System.out.println("Lazy person avoids exercise and prefers to rest or sleep.");
 }
}


public class PersonTestTwentyOne {
 public static void main(String[] args) {
     Person athlete = new Athlete();
     Person lazy = new LazyPerson();

     System.out.println("---- Athlete ----");
     athlete.eat();
     athlete.exercise();

     System.out.println("\n---- Lazy Person ----");
     lazy.eat();
     lazy.exercise();
 }
}
/*---- Athlete ----
Athlete eats a high-protein and balanced diet.
Athlete exercises daily with intense workouts and cardio.

---- Lazy Person ----
Lazy person eats fast food and snacks all day.
Lazy person avoids exercise and prefers to rest or sleep.*/
