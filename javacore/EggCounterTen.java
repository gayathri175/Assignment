package practice1;

public class EggCounterTen {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Please provide the number of eggs as a command line argument.");
            return;
        }

        int eggs = Integer.parseInt(args[0]);  //This method converts a String to an integer (int).

        int gross = eggs / 144;
        int remainingAfterGross = eggs % 144;

        int dozen = remainingAfterGross / 12;
        int remainingEggs = remainingAfterGross % 12;

        System.out.println("Your number of eggs is: " + gross + " gross, " +
                           dozen + " dozen, and " + remainingEggs + " eggs.");
    }
}
//here for setting command-line arguments go to runas and all give number which was given
/*Your number of eggs is: 9 gross, 3 dozen, and 10 eggs.*/