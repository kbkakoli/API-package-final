package stepDefinitionpack;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace01;
import pojo.Location01;
import resource.Utils01;
//import resources.APIResources;
 
//import resources.Utils;



 public class stepDefinitionClass01 extends Utils01{
	RequestSpecification res;
	ResponseSpecification resspec ;
	Response response;
    resource.TestDataBuild01 data =new resource.TestDataBuild01();
    @Given("Add place Payload with {String} {String} {String}")

 public void add_place_payload_with(String name,String language,String Address) throws IOException {
	
	 res=given().spec(requestSpecification())
	.body(data.AddPlacePayLoad(name, language, Address));

	
}
@When("user calls {string} with Post http request")
public void user_calls_with_post_http_request(String string) {
  
resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
response =res.when().post("/maps/api/place/add/json").
 then().spec(resspec).extract().response();

}
@Then("API call got success with status code {int}")
public void api_call_got_success_with_status_code(Integer int1) {
assertEquals (response.getStatusCode(),200);
}
@Then("{string} in response body is {string}")
public void in_response_body_is_ok(String keyValue, String Expectedvalue) {
   
  String resp=response.asString();
  JsonPath js=new JsonPath(resp);
  assertEquals(js.get(keyValue).toString(),Expectedvalue);
  
}





}


	
