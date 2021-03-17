package ndk.utils_j2se;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class JSON_Utils {

    private static List<JSONObject> sort_JSON_array_by_date_field(List<JSONObject> JSON_array_list, SimpleDateFormat desired_date_format, String key_field) {

        JSON_array_list.sort((first_JSON_object, second_JSON_object) -> {

            int compare = 0;

            try {
                Date keyA = desired_date_format.parse(first_JSON_object.getString(key_field));
                Date keyB = desired_date_format.parse(second_JSON_object.getString(key_field));
                compare = keyA.compareTo(keyB);

            } catch (JSONException | ParseException e) {

                e.printStackTrace();
            }
            return compare;
        });

        return JSON_array_list;
    }

    public static JSONArray sort_JSON_array_by_date_field(String JSON_array, String desired_date_format, String key_field) {

        return sort_JSON_array_by_date_field(JSON_array, new SimpleDateFormat(desired_date_format), key_field);
    }

    private static JSONArray sort_JSON_array_by_date_field(String JSON_array, SimpleDateFormat desired_date_format, String key_field) {

        return JSON_object_list_to_JSON_array(sort_JSON_array_by_date_field(JSON_array_to_JSON_object_list(JSON_array), desired_date_format, key_field));
    }

    private static List<JSONObject> JSON_array_to_JSON_object_list(String JSON_array) {

        JSONArray array_JSON = new JSONArray(JSON_array);
        List<JSONObject> JSON_object_list = new ArrayList<>();

        for (int i = 0; i < array_JSON.length(); i++)
            JSON_object_list.add(array_JSON.getJSONObject(i));

        return JSON_object_list;
    }

    private static JSONArray JSON_object_list_to_JSON_array(List<JSONObject> JSON_object_list) {

        JSONArray JSON_array = new JSONArray();
        for (JSONObject json_object : JSON_object_list) {

            JSON_array.put(json_object);
        }
        return JSON_array;
    }

    public static void print_json_array(JSONArray JSON_array) {

        for (int i = 0; i < JSON_array.length(); i++) {

            JSONObject innerObj = JSON_array.getJSONObject(i);
            for (Iterator it = innerObj.keys(); it.hasNext(); ) {

                String key = (String) it.next();
                System.out.println(key + ":" + innerObj.get(key));
            }
            System.out.println("---------------------------------");
        }
    }

    private static List<JSONObject> sort_JSON_array_by_integer_field(List<JSONObject> JSON_array_list, String key_field) {

        JSON_array_list.sort((first_json_object, second_json_object) -> {

            int compare = 0;

            try {
                int first_json_object_key_value = first_json_object.getInt(key_field);
                int second_json_object_key_value = second_json_object.getInt(key_field);
                compare = Integer.compare(first_json_object_key_value, second_json_object_key_value);

            } catch (JSONException e) {

                e.printStackTrace();
            }
            return compare;
        });

        return JSON_array_list;
    }

    public static JSONArray sort_JSON_array_by_integer_field(String JSON_array, String key_field) {

        return JSON_object_list_to_JSON_array(sort_JSON_array_by_integer_field(JSON_array_to_JSON_object_list(JSON_array), key_field));
    }
}
