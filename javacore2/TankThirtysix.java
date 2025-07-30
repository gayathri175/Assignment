package practice2;

class Tank {
    private boolean isEmpty = true;

    public void fillTank() {
        if (!isEmpty) {
            System.out.println("Tank is already full!");
        } else {
            isEmpty = false;
            System.out.println("Tank is filled.");
        }
    }

    public void releaseTank() {
        if (isEmpty) {
            System.out.println("Tank is already empty!");
        } else {
            isEmpty = true;
            System.out.println("Tank is emptied.");
        }
    }

    @Override
    @SuppressWarnings("removal")
    protected void finalize() throws Throwable {
        if (!isEmpty) {
            System.out.println("Error: Tank was not released before garbage collection!");
        } else {
            System.out.println("Tank was properly released before cleanup.");
        }
        super.finalize();
    }
}

public class TankThirtysix {
    public static void main(String[] args) {
        System.out.println("Scenario 1: Proper cleanup");
        Tank t1 = new Tank();
        t1.fillTank();
        t1.releaseTank();
        t1 = null;
        System.gc();

        System.out.println("\nScenario 2: Improper cleanup");
        Tank t2 = new Tank();
        t2.fillTank();
        t2 = null;
        System.gc();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/*Scenario 1: Proper cleanup
Tank is filled.
Tank is emptied.

Scenario 2: Improper cleanup
Tank was properly released before cleanup.
Tank is filled.
Error: Tank was not released before garbage collection!*/