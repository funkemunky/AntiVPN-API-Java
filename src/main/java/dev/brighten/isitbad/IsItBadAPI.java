package dev.brighten.isitbad;

import dev.brighten.isitbad.structures.FailedResponse;
import dev.brighten.isitbad.structures.IpInformation;
import dev.brighten.isitbad.utils.Result;
import dev.brighten.isitbad.utils.json.JSONException;
import dev.brighten.isitbad.utils.json.JSONObject;
import dev.brighten.isitbad.utils.json.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class IsItBadAPI {

    private static final String API_ENDPOINT = "https://funkemunky.cc/vpn?ip=%s";
    public static Result<IpInformation, FailedResponse> getIpInformation(String ip) {
        try {
            URL url = new URL(String.format(API_ENDPOINT, ip));

            JSONObject result = JsonReader.readJsonFromUrl(String.format(API_ENDPOINT, ip));

            if(!result.getBoolean("success")) {
                return new Result.Err<>(new FailedResponse(false, result.getString("reason")));
            }

            return new Result.Ok<>(new IpInformation(
                    result.getInt("accuracyRadius"),
                    result.getString("method"),
                    result.getInt("queriesLeft"),
                    result.getString("city"),
                    result.getString("ip"),
                    result.getString("isp"),
                    result.getDouble("latitude"),
                    result.getDouble("longitude"),
                    result.getString("timeZone"),
                    result.getLong("lastAccess"),
                    result.getString("network"),
                    result.getBoolean("proxy"),
                    result.getString("countryCode"),
                    result.getBoolean("success"),
                    result.getString("organization"),
                    result.getBoolean("cached"),
                    result.getString("countryName"),
                    result.getString("asn")
            ));
        } catch (MalformedURLException e) {
            return new Result.Err<>(new FailedResponse(false, "Invalid IP address."));
        } catch (IOException e) {
            return new Result.Err<>(new FailedResponse(false, "Failed to connect to API."));
        } catch (JSONException e) {
            return new Result.Err<>(new FailedResponse(false, "Failed to parse JSON response."));
        }
    }
}
