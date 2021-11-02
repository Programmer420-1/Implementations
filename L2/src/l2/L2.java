package l2;

import java.util.Random;
import java.util.Scanner;

public class L2 {
    public static void main(String[] args) {
        // Q1
        Scanner in = new Scanner(System.in);
        System.out.println("Q1");
        System.out.print("Enter temperature in Fahrenheit: ");
        double tempInF = in.nextDouble();
        double tempInC = (tempInF-32.0)/1.8;
        System.out.printf("%.2f in Fahrenheit is equivalent to %.2f in Celsius\n",tempInF,tempInC);
        System.out.println("\n");
        
        // Q2
        System.out.println("Q2");
        System.out.print("Enter the price of the car: ");
        double P = in.nextDouble();
        System.out.print("Enter the amount of down payment: ");
        double D = in.nextDouble();
        System.out.print("Enter the interest rate in %: ");
        double R = in.nextDouble();
        System.out.print("Enter the loan duration in year: ");
        double Y = in.nextDouble();
        double M = (P-D)*(1+R*Y/100.0)/(Y*12.0);
        System.out.printf("Monthly payment = %.2f\n",M);
        System.out.println("\n");
        
        // Q3
        System.out.println("Q3");
        Random r = new Random();
        int total = 0;
        int ran;
        for (int i = 0; i < 3 ; i++){
            ran = r.nextInt(41)+10;
            System.out.printf("Random number %d = %d\n",i+1,ran);
            total += ran;
        }
        double mean = total/3.0;
        System.out.printf("Average of the three random numbers generated: %.2f\n",mean);
        System.out.println("\n");
        
        // Q4
        System.out.println("Q4");
        System.out.print("Enter the number of seconds: ");
        int s = in.nextInt();
        if (s < 0){
            System.out.println("Time doesn't go in opposite direction. We don't do that here....");
        }
        else{
            int hour = s/3600;
            int minute = (s-hour*3600)/60;
            int seconds = s-hour*3600-minute*60;
            String _hour = hour>1?"hours":"hour";
            String _minute = minute>1?"minutes":"minute";
            String _second = seconds>1?"seconds":"second";
            System.out.printf("%d seconds is %d %s, %d %s and %d %s\n",s,hour,_hour,minute,_minute,seconds,_second);
        }
        System.out.println("\n");
        
        // Q5
        System.out.println("Q5");
        int rand = r.nextInt(10001);
        System.out.printf("Random number generated : %d\n",rand);
        int sum = 0;
        for(int i = 0; i < 5 ; i++){
            if (rand == 0)break;
            sum += rand%10;
            rand = (rand-(rand%10))/10;
        }
        System.out.printf("Sum of all digits in the random number = %d\n",sum);
        System.out.println("\n");  
        
        // Q6
        System.out.println("Q6");
        System.out.print("Enter the amount of water in gram: ");
        double m = in.nextDouble();
        System.out.print("Enter the initial temperature in Fahrenheit: ");
        double tempI = in.nextDouble();
        System.out.print("Enter the final temperature in Fahrenheit: ");
        double tempF = in.nextDouble();
        double E = m*(tempF-tempI)*4184;
        System.out.printf("Energy required = %e J\n",E);
        System.out.println("\n**********************\n     End of Lab 2     \n**********************\n");
    }
    
}
