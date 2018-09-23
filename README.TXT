Colin Biddle
colinbiddle at protonmail dot com
v1.0.090818

PURPOSE OF PROJECT:
This program is a command line trivia game. 

HOW TO START THIS PROJECT:
From the command line, navigate to the folder where this README.txt file is saved. Execute
'java Trivia'. 

PSEUDOCODE:
ReadQuestion first searches the directory "Data/Questions" and finds all of the question 
files. The file names are then stored in a File[] array called questionList.
ReadQuestion then loops over each file in questionList to find the category name before the
question value number. If the category of the question is not already in the categories 
ArrayList, it is added. This same process can also be done by calling setCategories(), 
which also uses setQuestionList().

runCategory() will run through 5 questions in each of the available categories. When that 
category is done, it is removed from available categories in the categories ArrayList.
runCategory() reads in each line from the question file, prints out the question and 
choices, and compares the user's answer to the key. The number of questionsAsked is 
incremented and the totalPoints (the points that are available) increases the value of 
the question no matter what happens. If the user answered correctly, correctQuestionsAsked
increments and correctPoints also increases the value of the question.

displayGrade() displays the questionsAsked, correctQuestionsAsked, correctPoints, and 
totalPoints

calculateGrade() method returns the number of correctPoints/totalPoints. 

KeepScore creates a ReadQuestion object and calls the runCategory() method in a try-catch 
block. It then displays and calculates the grade. If the user scored better than 66%, they 
get a certificate.

The certificate prints on screen but also creates/writes to a .txt file with the user's 
name in the Data/Certificates directory. 

FinalProject creates a KeepScore object in a try-catch block.

OTHER COMMENTS:
It is worth noting that users can easily write their own questions for this game. To write 
a question, the user should create a ".txt" file with the question category saved as the 
file name followed by the number of points for that question. For example, a question
about cooking worth 1 point would be saved as "cooking1.txt". A question about math worth
3 points would be saved as "math3.txt", etc.

Within the .txt file, the first line should be the question, the second line are the answer
choices, and the final line is the correct answer (the "key"). 

Question files should be saved in the local Data/Questions folder.
