package resource;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace01;
import pojo.Location01;


public class TestDataBuild01 {
	
public AddPlace01 AddPlacePayLoad(String language, String Address, String name) {
	AddPlace01 p =new AddPlace01();
	p.setAccuracy(50);
	p.setAddress(Address);
	p.setLanguage(language);
	p.setPhone_number("(+91) 983 893 3937");
	p.setWebsite("https://rahulshettyacademy.com");
	p.setName(name);
	List<String> myList =new ArrayList<String>();
	myList.add("shoe park");
	myList.add("shop");
	p.setTypes(myList);
	Location01 l =new Location01();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	p.setLocation(l);
	return p;
}

}
	

