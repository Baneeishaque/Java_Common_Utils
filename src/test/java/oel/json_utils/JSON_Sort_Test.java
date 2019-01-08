package oel.json_utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JSON_Sort_Test {

    @Test
    public void test_sort_JSON_array_by_integer_field() {

        JSONArray JSON_array=new JSONArray();

        JSONObject JSON_object=new JSONObject();
        JSON_object.put("No.","2");
        JSON_array.put(JSON_object);

        JSON_object=new JSONObject();
        JSON_object.put("No.","5");
        JSON_array.put(JSON_object);

        JSON_object=new JSONObject();
        JSON_object.put("No.","7");
        JSON_array.put(JSON_object);

        assertEquals(JSON_array, JSON_Utils.sort_JSON_array_by_integer_field("[{\"No.\":\"5\"},{\"No.\":\"2\"},{\"No.\":\"7\"}]","No."));
    }

    @Test
    public void test_sort_JSON_array_by_date_field() {

        JSONArray JSON_array=new JSONArray();

        JSONObject JSON_object=new JSONObject();
        JSON_object.put("Date","15-09-2017");
        JSON_array.put(JSON_object);

        JSON_object=new JSONObject();
        JSON_object.put("Date","22-10-2018");
        JSON_array.put(JSON_object);

        JSON_object=new JSONObject();
        JSON_object.put("Date","01-01-2019");
        JSON_array.put(JSON_object);

        assertEquals(JSON_array, JSON_Utils.sort_JSON_array_by_date_field("[{\"Date\":\"22-10-2018\"},{\"Date\":\"15-09-2017\"},{\"Date\":\"01-01-2019\"}]","dd-MM-YYYY","Date"));
    }

    @Test
    public void test_print_json_array() {

        JSONArray JSON_array=new JSONArray();

        JSONObject JSON_object=new JSONObject();
        JSON_object.put("No.","2");
        JSON_array.put(JSON_object);

        JSON_object=new JSONObject();
        JSON_object.put("No.","5");
        JSON_array.put(JSON_object);

        JSON_object=new JSONObject();
        JSON_object.put("No.","7");
        JSON_array.put(JSON_object);

        JSON_Utils.print_json_array(JSON_array);
    }
}
