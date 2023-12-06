package dev.brighten.isitbad.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlUtils {

    public static String readResponseFromURL(String urlToRead) throws IOException {
        URL url = new URL(urlToRead);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        if(conn.getResponseCode() != 200) {
            throw new IOException("Failed to connect to URL: "
                    + urlToRead + " with response code: " + conn.getResponseCode());
        }

        BufferedReader breader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder builder = new StringBuilder();

        String line;
        while((line = breader.readLine()) != null) {
            builder.append(line);
        }

        breader.close();

        return builder.toString();
    }


}
