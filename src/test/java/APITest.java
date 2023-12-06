import dev.brighten.isitbad.IsItBadAPI;
import dev.brighten.isitbad.structures.FailedResponse;
import dev.brighten.isitbad.structures.IpInformation;
import dev.brighten.isitbad.utils.Result;
import org.junit.jupiter.api.Test;

public class APITest {

    @Test
    void apiTest() {
        Result<IpInformation, FailedResponse> apiResult =  IsItBadAPI.getIpInformation("192.168.1.1");

        assert apiResult instanceof Result.Ok;

        IpInformation result = ((Result.Ok<IpInformation, FailedResponse>) apiResult).getValue();

        assert result.getIp().equals("192.168.1.1");
    }

    @Test
    void incorrectArgumentTest() {
        Result<IpInformation, FailedResponse> apiResult = IsItBadAPI.getIpInformation("thisisabadarg");

        assert apiResult instanceof Result.Err;

        FailedResponse result = ((Result.Err<IpInformation, FailedResponse>) apiResult).getError();

        assert !result.isSuccess();
    }

}
