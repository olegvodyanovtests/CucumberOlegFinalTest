package api;

import static config.ConfigFile.K;
import static config.ConfigFile.SITE;
import static io.restassured.RestAssured.*;

public class WeatherApi {
    private static final String CURRENT = "current";

    public static int getResultCode(String city) {
        return given().queryParam("access_key", K)
                .queryParam("query", city)
                .when().get(SITE + CURRENT).statusCode();
    }
}
