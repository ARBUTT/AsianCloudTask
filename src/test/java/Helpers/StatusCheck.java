package Helpers;

import io.restassured.RestAssured;

public class StatusCheck {

  public int httpResponseCodeViaGet(String url) {
    return RestAssured.get(url).statusCode();
  }

  public int httpResponseCodeViaPost(String url) {
    return RestAssured.post(url).statusCode();
  }
 
}