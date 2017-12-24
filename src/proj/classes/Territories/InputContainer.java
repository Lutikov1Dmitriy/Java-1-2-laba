package proj.classes.Territories;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputContainer {
    private BufferedReader reader;

    public InputContainer() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String inputFieldData(String inputQuestion) {
        System.out.println(inputQuestion + ": ");
        String answer = null;
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }
}
