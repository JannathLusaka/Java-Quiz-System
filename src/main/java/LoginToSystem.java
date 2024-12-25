import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LoginToSystem {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("System:> Enter your name: ");
        String userName = scanner.next();
        System.out.println("System:> Enter password: ");
        int userPass = scanner.nextInt();
        String result = ReadJsonFile(userName, String.valueOf((int) userPass));
        if (result.equals("admin")) {
            System.out.println("Welcome admin! Please create new questions in the question bank.");
            new AdminWorks().startAdminWork();
        } else if (result.equals("student")) {
            System.out.println("Welcome lusaka to the quiz! We will throw you 10 questions." +
                    " Each MCQ mark is 1 and no negative marking. " +
                    "Are you ready? Press 's' to start.");
            new StudentsWork().startStudentsWork();

        } else {
            System.out.println("invalid");
        }
    }


    public static String ReadJsonFile(String userName, String userPass) throws IOException, ParseException {
        String filePath = "./src/main/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(filePath));
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String savedName = (String) jsonObject.get("username");
            String savedPass = (String) jsonObject.get("password");
            if (savedName.equals(userName) && (savedPass.equals(userPass))) {
                String role = (String) jsonObject.get("role");
                return (role);
            }
        }
        return "invalid";

    }
}









