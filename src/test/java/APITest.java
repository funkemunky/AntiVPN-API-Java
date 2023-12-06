import dev.brighten.isitbad.IsItBadAPI;
import dev.brighten.isitbad.structures.FailedResponse;
import dev.brighten.isitbad.structures.IpInformation;
import dev.brighten.isitbad.utils.Result;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class APITest {

    @Test
    void apiCorrectUsageTest() {
        Result<IpInformation, FailedResponse> apiResult =  IsItBadAPI.getIpInformation("192.168.1.1");

        assert apiResult instanceof Result.Ok;

        IpInformation result = ((Result.Ok<IpInformation, FailedResponse>) apiResult).getValue();

        assert result.getIp().equals("192.168.1.1");
    }

    @Test
    void apiInetAddressCorrectUsageTest() {
        InetAddress address;
        try {
            address = InetAddress.getByName("192.168.1.1");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        Result<IpInformation, FailedResponse> apiResult = IsItBadAPI.getIpInformation(address);

        assert apiResult instanceof Result.Ok;

        IpInformation result = ((Result.Ok<IpInformation, FailedResponse>) apiResult).getValue();

        assert result.getIp().equals("192.168.1.1");
    }

    @Test
    void apiTestUnwrappingFunctionality() {
        Result<IpInformation, FailedResponse> apiResult = IsItBadAPI.getIpInformation("192.168.1.1");

        IpInformation result = apiResult.unwrap();

        assert result.isSuccess();

        assert result.getIp().equals("192.168.1.1");
    }

    @Test
    void failureInducementTest() {
        Result<IpInformation, FailedResponse> apiResult = IsItBadAPI.getIpInformation("thisisabadarg");

        assert apiResult instanceof Result.Err;

        FailedResponse result = ((Result.Err<IpInformation, FailedResponse>) apiResult).getError();

        assert !result.isSuccess();
    }

}
