package automation.util;

import automation.Params.ParamInput;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

/**
 * This is to read test data from Jason file. TestNG will pass the test data to test case by DataProvider annotation
 */
public class JasonDataProvider {
    static String fileLocation = "./resources/";
    static HashMap<String, String> map;
    @DataProvider(name="JasonReader")
    public static Object[][] readFile(Method m) {
        String testname = m.getName();
        String dataFile = fileLocation +testname+".json";

        Gson gson = new Gson();
        ParamInput params=null;
        BufferedReader br = null;
        try {

            br = new BufferedReader(
                    new FileReader(dataFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //convert the json string back to object

        Type listType = new TypeToken<List<ParamInput>>() {}.getType();
        List<ParamInput> list = gson.fromJson(br, listType);
        int size = list.size();
        Object[][] data = new Object[size][1];
        int i=0;
        for(ParamInput pi : list){
            data[i][0] = list.get(i);
            i++;
        }


        return data;

    }
}
