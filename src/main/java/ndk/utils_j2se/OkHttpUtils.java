package ndk.utils_j2se;

import java.io.IOException;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {

    //Not Compatible with android
    // one instance, reuse
    private static final OkHttpClient httpClient = new OkHttpClient();

    static String performHttpGet(String getUrlWithParameters) {

        Request request = new Request.Builder().url(getUrlWithParameters).build();
        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException(response.toString());
            return Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {

            e.printStackTrace();
        }
        return "";
    }
}
