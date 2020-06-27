package ndk.utils_j2se;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TextLocalUtils {

    //Not Compatible with android
    public static boolean sendSMS(String API_KEY, String mobileNumber, String message) {

        try {

            String response = OkHttpUtils.performHttpGet("https://api.textlocal.in/send/?" + "apikey=" + URLEncoder.encode(API_KEY, "UTF-8") + "&numbers=" + URLEncoder.encode(mobileNumber, "UTF-8") + "&message=" + URLEncoder.encode(message, "UTF-8") + "&sender=" + URLEncoder.encode("TXTLCL", "UTF-8"));

            if (!response.equals("")) {

                JSONObject jsonObject = new JSONObject(response);
                if (jsonObject.getString("status").equals("success")) {

                    return true;
                }
            }

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
        return false;
    }
}
