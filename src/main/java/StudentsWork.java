import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

    public class StudentsWork {
        public static void main(String[] args) throws IOException, ParseException {
            StudentsWork studentsWork = new StudentsWork();
            StudentsWork.startStudentsWork();
        }
public static void startStudentsWork() throws IOException, ParseException {
    String filePath = "./src/main/resources/quiz.json";
    JSONParser jsonParser=new JSONParser();
    JSONArray jsonArray=(JSONArray) jsonParser.parse(new FileReader(filePath));
    Random random=new Random();
    JSONObject jsonObject=new JSONObject();
    Scanner scanner=new Scanner(System.in);
    int marks=0;
    for(int i=0; i<10;i++){
        int randomIndex = random.nextInt(jsonArray.size());
       JSONObject QuestionObj = (JSONObject) jsonArray.get(randomIndex);
       System.out.println("Question "+(i+1)+": "+QuestionObj.get("Question"));
        System.out.println("1. " +QuestionObj.get("Option 1"));
        System.out.println("2. " +QuestionObj.get("Option 2"));
        System.out.println("3. " +QuestionObj.get("Option 3"));
        System.out.println("4. " +QuestionObj.get("Option 4"));
        System.out.println("Your Answer: ");
        int answer=scanner.nextInt();
        int actualAnswer = ((Long) QuestionObj.get("AnswerKey")).intValue();
        if(answer==actualAnswer){
            marks++;
        }
}
    if(marks>=8){
        System.out.println("Excellent! You have got "+marks+" out of 10");
    } else if(marks>=5) {
        System.out.println("Good. You have got " + marks + " out of 10");
    }
     else if (marks>=2) {
        System.out.println("Very poor! You have got "+marks+" out of 10");
    }
    else{
        System.out.println("Very sorry you are failed. You have got "+marks+" out of 10");
    }
}

}

