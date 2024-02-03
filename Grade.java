import java.lang.*;
import java.util.Scanner;

public class Grade{
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		System.out.println("Welcome "+ name +" !");
        System.out.println("Enter the number of subjects: ");
        int subjects = sc.nextInt();
        int total=0;
        int[] marks = new int[subjects];
        for(int i=0; i<subjects; i++){
            int submark;
            do{
            System.out.println("Enter the marks in subject "+(i+1)+" out of 100: ");
            while (!sc.hasNextInt()) {
                    System.out.println("Invalid input format. Please enter a valid mark for subject " + (i + 1) + " out of 100 (in integer format): ");
                    sc.next();
                }
            submark = sc.nextInt();
            if(submark < 0)
                System.out.println("Please enter a valid mark for subject "+(i+1)+" out of 100 (>= 0): ");
            } while(submark<0);
            marks[i] = submark;
            total+=marks[i];
        }
        double perc = (double)total/subjects;
        char grade = grade_calc(perc);
        System.out.println("***************************"+"Report Card"+"***************************");
        System.out.println("Student Name: "+name);
        System.out.println("Total Marks: "+total);
        System.out.println("Average Percentage: "+perc);
        System.out.println("Grade: "+grade);
        System.out.println("***************************"+"***********"+"***************************");
        
    }
    private static char grade_calc(double perc){
        if(perc>=90)
			return 'A';
		else if(perc>=80)
			return 'B';
		else if(perc>=70)
			return 'C';
		else if(perc>=60)
			return 'D';
		else if(perc>=40)
			return 'E';
		else
			return 'F';
    }
}
