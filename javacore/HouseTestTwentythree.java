package practice1;
public class HouseTestTwentythree {

    static class Hall {
        public void showMessage() {
            System.out.println("This is the first room while entering the house");
        }
    }

    static class Kitchen {
        public void showAppliances() {
            String[] appliances = {"Fridge", "Microwave", "Oven", "Mixer"};

            System.out.println("Appliances:");
            for (String appliance : appliances) {
                System.out.println(appliance);
            }

           
            String[] copiedAppliances = new String[appliances.length];
            System.arraycopy(appliances, 0, copiedAppliances, 0, appliances.length);

            System.out.println("Copied appliances:");
            for (String item : copiedAppliances) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        Hall hall = new Hall();
        hall.showMessage();

        Kitchen kitchen = new Kitchen();
        kitchen.showAppliances();
    }
}
/*This is the first room while entering the house
Appliances:
Fridge
Microwave
Oven
Mixer
Copied appliances:
Fridge
Microwave
Oven
Mixer
*/
