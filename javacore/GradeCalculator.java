package practice1;

public class GradeCalculator {

	public static void main(String[] args) {
		int totalStudents = 90;     
        //  here 50% students got AA so
        int totalGradeA = totalStudents * 50 / 100; //90*50/100
        int boysGradeA = 20;

        int girlsGradeA = totalGradeA - boysGradeA;
          System.out.println("Total number of girls who got grade A: " + girlsGradeA);
    }
}

//total are 90 here45 are boys and gradeaboys are 20 and totalgirls are45 gradeagirls

	  
/*Total number of girls who got grade A: 25*/	       
		
		
	
