
/**
 * Readquestion reads in questions and does the scoring. For more, see the readme.txt file.
 *
 * Colin Biddle
 * colinbiddle at protonmail dot com
 * v1.0.090818
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class ReadQuestion //The encapsulated class that reads in the questions and does the scoring
{
    private String key;
    private int correctPoints, totalPoints, questionsAsked, correctQuestionsAsked, questionValue;
    private File[] questionList;
    private ArrayList<String> categories = new ArrayList<>();
    
    public ReadQuestion() throws Exception {
        File directory = new File("Data/Questions");
        questionList = directory.listFiles();
        
        //This loop is designed to check the categories of the questions that are stored in the local Data/Questions folder
        //All question files should be named using the format "category#.txt"
        //The names of the files are all stored in the questionList File array
        //The loop finds the categories in the file name, if that category isn't already in the categories ArrayList, it adds it
        for (int i = 0; i < questionList.length; i++) { 
            String temp = questionList[i].getName(); //When the loop finds the next file in questionList, it stores it as a String with the reference "temp"
            for (int k = 0; k < temp.length(); k++) {
                if (Character.isDigit(temp.charAt(k))) {
                    questionValue = k; //questionValue is used to find the index where the question number is in the filename
                }
            }
            //If the question file has been saved in the proper format ("category#.txt"), then everything before questionValue is the category name
            String newTemp = temp.substring(0, questionValue); //questionValue is used to build newTemp
            
            if (!categories.contains(newTemp)) {
                categories.add(newTemp);
            }
        }
    }
    
    public void runCategory() throws Exception {
        StringBuilder temp = new StringBuilder(getCategories());
        temp.deleteCharAt(0);
        temp.deleteCharAt(temp.length() - 1);
        
        while (temp.length() > 0) { 
            System.out.println("Pick a category: " + temp);
            Scanner keyboard = new Scanner(System.in);
            String category = keyboard.nextLine();
        
            while(!categories.contains(category)) {
                System.out.println("Enter a valid category from the list: " + temp);
                category = keyboard.nextLine();
            }
        
        
            for (int i = 1; i <= 5; i++) {
                File file = new File("Data/Questions/" + category + i + ".txt");
                Scanner readIn = new Scanner(file);
                if (file.exists() && readIn.hasNext()) {
                    System.out.println("This question is worth " + i + " points.");
                    System.out.println(readIn.nextLine());
                    System.out.println(readIn.nextLine());
                    String answer = keyboard.nextLine();
                    key = readIn.nextLine();
                 
                 
                    if (answer.equalsIgnoreCase(key)) {
                        System.out.println("Correct\n");
                        questionsAsked++;
                        correctQuestionsAsked++;
                        correctPoints += i;
                        totalPoints += i;
                    } else {
                        System.out.println("Incorrect. The correct answer is: " + key + "\n");
                        questionsAsked++;
                        totalPoints += i;
                    }  

            }
        }
    
        
        categories.remove(category);
        temp = new StringBuilder(getCategories());
        temp.deleteCharAt(0);
        temp.deleteCharAt(temp.length() - 1);
    }
}

    
    public void setQuestionList() {
        File directory = new File("Data/Questions");
        questionList = directory.listFiles();
    }
    
    public File[] getQuestionList() {
        return questionList;
    }
    
    public void setCategories() {
        setQuestionList();

        for (int i = 0; i < questionList.length; i++) {
            String temp = questionList[i].getName();
            for (int k = 0; k < temp.length(); k++) {
                if (Character.isDigit(temp.charAt(k))) {
                    questionValue = k; //questionValue is used to find the index where the question number is in the filename
                }
            }
            String newTemp = temp.substring(0, questionValue); //questionValue used to build newTemp
            if (!categories.contains(newTemp)) {
                categories.add(newTemp);
            }
        }
    }
    
    public String getCategories() {
        return categories.toString();
    }
    
    public String getKey() {
        return key;
    }
    
    public void setQuestionValue(int i) {
        questionValue = i;
    }
    
    public int getQuestionValue() {
        return questionValue;
    }
    
    public int getQuestionsAsked() {
        return questionsAsked;
    }
    
    public int getCorrectQuestionsAsked() {
        return correctQuestionsAsked;
    }
    
    public int getTotalPoints() {
        return totalPoints;
    }
    
    public int getCorrectPoints() {
        return correctPoints;
    }
    
    //Mutator methods for points and questions intentionally left out to discourage cheating
    
    public void displayGrade() {
        System.out.println("You correctly answered " + getCorrectQuestionsAsked() + " out of " + getQuestionsAsked() + " questions.");
        System.out.println("You scored " + getCorrectPoints() + " out of " + getTotalPoints() + " points.");
    }
    
    public double calculateGrade() {
        return (double)(getCorrectPoints()) / getTotalPoints();
    }

    
}
