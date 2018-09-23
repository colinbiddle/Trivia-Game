
/**
 * KeepScore creates a ReadQuestion object and creates a certificate if the user scores above a 66%. For more, see the readme.txt file.
 *
 * Colin Biddle
 * colinbiddle at protonmail dot com
 * v1.0.090818
 */
import java.util.Scanner;
import java.util.Date;
import java.io.PrintWriter;
import java.io.*;

public class KeepScore
{
    private String name;
    
    
    public KeepScore() throws Exception{
        ReadQuestion myExam = new ReadQuestion();
        Scanner keyboard = new Scanner(System.in);

            try {
                myExam.runCategory();
            } catch (Exception e) {
                System.out.println("Something went wrong. I know its a hard test, but are you sure you aren't trying to cheat?");
            }
       
            myExam.displayGrade();
            double temp = myExam.calculateGrade();
            if (temp >= 0.66) {
                System.out.println("Enter your name: ");
                name = keyboard.nextLine();
                
                BufferedOutputStream myCertificate = new BufferedOutputStream(new FileOutputStream("Data/Certificates/" + name + ".txt"));
                PrintWriter createCertificate = new PrintWriter(myCertificate);
    
                //Congratulating on the screen
                System.out.println("***********************");
                System.out.println("***********************");
                System.out.println("****CONGRATULATIONS****");
                System.out.printf("%12s", name);
                System.out.println(" ");
                System.out.println("***********************");
                System.out.println("***********************\n\n");
                System.out.println("You correctly answered " + myExam.getCorrectQuestionsAsked() + " out of " + myExam.getQuestionsAsked() + " questions.");
                System.out.println("You scored " + myExam.getCorrectPoints() + " out of " + myExam.getTotalPoints() + " points.\n");
                System.out.println("You can find a copy of your certificate here: " + "Data/Certificates/" + name + ".txt");
                
                //Creating the certificate
                createCertificate.println("***********************");
                createCertificate.println("***********************");
                createCertificate.println("****CONGRATULATIONS****");
                createCertificate.printf("%12s", name);
                createCertificate.println("\n");
                createCertificate.println("***********************");
                createCertificate.println("***********************\n\n");
                createCertificate.println("You correctly answered " + myExam.getCorrectQuestionsAsked() + " out of " + myExam.getQuestionsAsked() + " questions.");
                createCertificate.println("Completed on: " + new Date());
                createCertificate.close();
            }
        
    }
    

    
    
}


