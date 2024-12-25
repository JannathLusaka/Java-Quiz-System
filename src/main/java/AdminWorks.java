import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;


public class AdminWorks {
public static void main(String[] args) throws IOException, ParseException {
    AdminWorks adminWorks = new AdminWorks();
    adminWorks.startAdminWork();
}

    public void startAdminWork() throws IOException, ParseException {
        String filePath = "./src/main/resources/quiz.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray= new JSONArray();
            jsonArray = (JSONArray) jsonParser.parse(new FileReader(filePath));

        Scanner scanner = new Scanner(System.in);

            while (true) {
                JSONObject jsonObject = new JSONObject();
                System.out.println("System:> Input your question " + (jsonArray.size() + 1));
                String question = scanner.nextLine();
                jsonObject.put("Question", question);

                for (int j = 0; j < 4; j++) {
                    System.out.println("Input option " + (j + 1) + ": ");
                    String option = scanner.nextLine();
                    jsonObject.put("Option " + (j + 1), option);
                }

                System.out.println("What is the answer key? (Enter 1-4): ");
                int answerKey = scanner.nextInt();
                scanner.nextLine();
                jsonObject.put("AnswerKey", answerKey);

                jsonArray.add(jsonObject);

                FileWriter writer = new FileWriter(filePath);
                writer.write(jsonArray.toJSONString());
                writer.flush();
                writer.close();

                System.out.println("System:> Saved successfully! Do you want to add more questions? (press s for start and q for quit)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("q")) {
                    break;
                }
            }
        }

    }

