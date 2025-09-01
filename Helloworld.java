import java.util.*;
import java.math.BigInteger;
import org.json.JSONObject;

public class Helloworld {
    public static void main(String[] args) throws Exception {
        
        String content = new String(java.nio.file.Files.readAllBytes(
                java.nio.file.Paths.get("json/input.json"))); 
        JSONObject json = new JSONObject(content);

        int n = json.getJSONObject("keys").getInt("n");
        int k = json.getJSONObject("keys").getInt("k");

        System.out.println("Total roots (n): " + n);
        System.out.println("Required roots (k): " + k);

        
        for (String key : json.keySet()) {
            if (!key.equals("keys")) {
                JSONObject root = json.getJSONObject(key);
                int base = root.getInt("base");
                String value = root.getString("value");

                BigInteger decimalValue = new BigInteger(value, base);
                System.out.println("Root " + key + " (base " + base + "): " + decimalValue);
            }
        }
    }
}
