package Utils;

import java.util.HashMap;
import java.util.Map;

public class Result {
    public static Map<String, Object> createResult(long code, String message, Map<String, Object> data) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("message", message);
        result.put("data", data);
        return result;
    }
}
