package ndk.utils_j2se;

public class TextLocalUtilsWrapper {

    private static String API_KEY;

    public TextLocalUtilsWrapper(String API_KEY) {

        TextLocalUtilsWrapper.API_KEY = API_KEY;
    }

    public static boolean sendSMS(String mobileNumber, String message) {

        return TextLocalUtils.sendSMS(API_KEY, "", "");
    }


}
