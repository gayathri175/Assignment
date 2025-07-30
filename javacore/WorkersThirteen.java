package practice1;


abstract class WorkerQNO13 {
    protected String name;
    protected double salaryRate;

    public WorkerQNO13(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }

    public abstract double pay(int hours);

    public void displayPay(int hours) {
        System.out.println("Name: " + name + ", Pay: ₹" + pay(hours));
    }
}

class DailyWorkerQNO13 extends WorkerQNO13 {

    public DailyWorkerQNO13(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double pay(int hours) {
        return salaryRate * hours;
    }
}

class SalariedWorkerQNO13 extends WorkerQNO13 {

    public SalariedWorkerQNO13(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double pay(int hours) {
        return salaryRate * 40; // fixed 40 hours payment
    }
}

public class WorkersThirteen{

    public static void main(String[] args) {
        WorkerQNO13 dailyWorker = new DailyWorkerQNO13("pandu", 150); 
        WorkerQNO13 salariedWorker = new SalariedWorkerQNO13("honey", 200); 

        System.out.println("---- Daily Worker Pay (worked 38 hours) ----");
        dailyWorker.displayPay(38);

        System.out.println("---- Salaried Worker Pay (worked 38 hours) ----");
        salariedWorker.displayPay(38);

        System.out.println("---- Salaried Worker Pay (worked 45 hours) ----");
        salariedWorker.displayPay(45); 
    }
}
/*---- Daily Worker Pay (worked 38 hours) ----
Name: pandu, Pay: ₹5700.0
---- Salaried Worker Pay (worked 38 hours) ----
Name: honey, Pay: ₹8000.0
---- Salaried Worker Pay (worked 45 hours) ----
Name: honey, Pay: ₹8000.0
*/