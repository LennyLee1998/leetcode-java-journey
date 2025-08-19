package String;

import java.util.HashMap;

public class Test {
  public static final HashMap<String, String> map = new HashMap<>();
  public static void main(String[] args) {
    map.put("0", "I am a women");
  }

  public static void add(String key, String value) {
    map.put(key, value);
  }
  public static String get(String key) {
    return map.get(key);
  }


}
