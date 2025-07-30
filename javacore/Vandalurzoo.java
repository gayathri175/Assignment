package practice1;

class Lion {
    public boolean isVegetarian() { return false; }
    public boolean canClimb() { return false; }
    public String sound() { return "Roar"; }
}

class Tiger {
    public boolean isVegetarian() { return false; }
    public boolean canClimb() { return false; }
    public String sound() { return "Growl"; }
}

class Deer {
    public boolean isVegetarian() { return true; }
    public boolean canClimb() { return false; }
    public String sound() { return "Bleat"; }
}

class Monkey {
    public boolean isVegetarian() { return true; }
    public boolean canClimb() { return true; }
    public String sound() { return "Chatter"; }
}

class Elephant {
    public boolean isVegetarian() { return true; }
    public boolean canClimb() { return false; }
    public String sound() { return "Trumpet"; }
}

class Giraffe {
    public boolean isVegetarian() { return true; }
    public boolean canClimb() { return false; }
    public String sound() { return "Hum"; }
}

public class Vandalurzoo {

    public static void displayAnimal(String name, boolean veg, boolean climb, String sound) {
        System.out.println("Animal: " + name);
        System.out.println("Vegetarian: " + veg);
        System.out.println("Can Climb: " + climb);
        System.out.println("Sound: " + sound);
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        Lion lion = new Lion();
        Tiger tiger = new Tiger();
        Deer deer = new Deer();
        Monkey monkey = new Monkey();
        Elephant elephant = new Elephant();
        Giraffe giraffe = new Giraffe();

        displayAnimal("Lion", lion.isVegetarian(), lion.canClimb(), lion.sound());
        displayAnimal("Tiger", tiger.isVegetarian(), tiger.canClimb(), tiger.sound());
        displayAnimal("Deer", deer.isVegetarian(), deer.canClimb(), deer.sound());
        displayAnimal("Monkey", monkey.isVegetarian(), monkey.canClimb(), monkey.sound());
        displayAnimal("Elephant", elephant.isVegetarian(), elephant.canClimb(), elephant.sound());
        displayAnimal("Giraffe", giraffe.isVegetarian(), giraffe.canClimb(), giraffe.sound());
    }
}
/*Animal: Lion
Vegetarian: false
Can Climb: false
Sound: Roar
---------------------------
Animal: Tiger
Vegetarian: false
Can Climb: false
Sound: Growl
---------------------------
Animal: Deer
Vegetarian: true
Can Climb: false
Sound: Bleat
---------------------------
Animal: Monkey
Vegetarian: true
Can Climb: true
Sound: Chatter
---------------------------
Animal: Elephant
Vegetarian: true
Can Climb: false
Sound: Trumpet
---------------------------
Animal: Giraffe
Vegetarian: true
Can Climb: false
Sound: Hum
---------------------------
*/