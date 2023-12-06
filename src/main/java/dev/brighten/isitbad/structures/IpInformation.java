package dev.brighten.isitbad.structures;

/*
#[derive(Serialize, Deserialize, Debug)]
pub struct IpInformation {
    #[serde(rename = "accuracyRadius")]
    pub accuracy_radius: i32,
    pub method: String,
    #[serde(rename = "queriesLeft")]
    pub queries_left: i32,
    pub city: String,
    pub ip: String,
    pub isp: String,
    pub latitude: f64,
    pub longitude: f64,
    #[serde(rename = "timeZone")]
    pub time_zone: String,
    #[serde(rename = "lastAccess")]
    pub last_access: i64,
    pub network: String,
    pub proxy: bool,
    #[serde(rename = "countryCode")]
    pub country_code: String,
    pub success: bool,
    pub organization: String,
    pub cached: bool,
    #[serde(rename = "countryName")]
    pub country_name: String,
    pub asn: String
}

 */
public class IpInformation {
    private final int accuracyRadius;
    private final String method;
    private final int queriesLeft;
    private final String city;
    private final String ip;
    private final String isp;
    private final double latitude;
    private final double longitude;
    private final String timeZone;
    private final long lastAccess;
    private final String network;
    private final boolean proxy;
    private final String countryCode;
    private final boolean success;
    private final String organization;
    private final boolean cached;
    private final String countryName;
    private final String asn;

    public IpInformation(int accuracyRadius, String method, int queriesLeft, String city, String ip, 
                         String isp, double latitude, double longitude, String timeZone, long lastAccess, 
                         String network, boolean proxy, String countryCode, boolean success, String organization,
                         boolean cached, String countryName, String asn) {
        this.accuracyRadius = accuracyRadius;
        this.method = method;
        this.queriesLeft = queriesLeft;
        this.city = city;
        this.ip = ip;
        this.isp = isp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeZone = timeZone;
        this.lastAccess = lastAccess;
        this.network = network;
        this.proxy = proxy;
        this.countryCode = countryCode;
        this.success = success;
        this.organization = organization;
        this.cached = cached;
        this.countryName = countryName;
        this.asn = asn;
    }

    public int getAccuracyRadius() {
        return accuracyRadius;
    }

    public String getMethod() {
        return method;
    }

    public int getQueriesLeft() {
        return queriesLeft;
    }

    public String getCity() {
        return city;
    }

    public String getIp() {
        return ip;
    }

    public String getIsp() {
        return isp;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public long getLastAccess() {
        return lastAccess;
    }

    public String getNetwork() {
        return network;
    }

    public boolean isProxy() {
        return proxy;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getOrganization() {
        return organization;
    }

    public boolean isCached() {
        return cached;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getAsn() {
        return asn;
    }
}
