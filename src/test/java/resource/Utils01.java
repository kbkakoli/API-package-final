package resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

public class Utils01 {

	
	public RequestSpecification requestSpecification() throws IOException {
	RequestSpecification req;	
	PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));	
	RestAssured.baseURI="https://rahulshettyacademy.com";
	 req =new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
	.addFilter(RequestLoggingFilter.logRequestTo(log))	
	.addFilter(ResponseLoggingFilter.logResponseTo(log))
    .setContentType(ContentType.JSON).build();
	 return req;
		
	}
public static  String  getGlobalValue(String key) throws IOException {
Properties prop=new Properties();//creating an object of properties file but this file dont know where the file is +FIS (fis)know where the file is so we need to integrate prop+fis.
FileInputStream fis=new FileInputStream("C:\\Users\\total\\eclipse-workspace\\framework.framework\\src\\test\\java\\resource\\global01.properties");
prop.load(fis);
return prop.getProperty(key);

}
	
}
