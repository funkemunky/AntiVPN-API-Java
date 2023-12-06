package dev.brighten.isitbad;

import dev.brighten.isitbad.structures.FailedResponse;
import dev.brighten.isitbad.structures.IpInformation;
import dev.brighten.isitbad.utils.Result;
import dev.brighten.isitbad.utils.UrlUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;

public class IsItBadAPI {

    private static final String API_ENDPOINT = "https://funkemunky.cc/vpn?ip=%s";

    public static Result<IpInformation, FailedResponse> getIpInformation(InetAddress address) {
        return getIpInformation(address.getHostAddress());
    }

    public static Result<IpInformation, FailedResponse> getIpInformation(String ip) {
        try {
            String rawJson = UrlUtils.readResponseFromURL(String.format(API_ENDPOINT, ip));

            JSONObject result = new JSONObject(rawJson);

            if(!result.getBoolean("success")) {
                return new Result.Err<>(new FailedResponse(false, result.getString("failureReason")));
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
            return new Result.Err<>(new FailedResponse(false, "Invalid IP address: " + e.getMessage()));
        } catch (IOException e) {
            return new Result.Err<>(new FailedResponse(false, "Failed to connect to API: " + e.getMessage()));
        }
    }
}
