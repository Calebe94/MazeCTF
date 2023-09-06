package mazectf.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {

    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(path);
            if (inputStream != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = br.readLine()) != null)
                    builder.append(line).append("\n");

                br.close();
            } else {
                throw new RuntimeException("File not found: " + path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}

}
