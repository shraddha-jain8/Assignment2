import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.path.json.JsonPath;

public class Apiassignment {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String currentDir = System.getProperty("user.dir");
		//System.out.println(currentDir);
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://swapi.dev/");
		driver.findElement(By.id("interactive")).sendKeys("people");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		String response = driver.findElement(By.xpath("//pre[@id='interactive_output']")).toString();
		
		//Verify that the total number of people where height is greater than 200 matches the expected count (10 at the time this was assigned)
		String response1 =base.basic();
		JsonPath js = new JsonPath(response1);
	    int Count = js.getInt("count");
	    System.out.println(Count);
		
	    Array[] intArray = new Array[9];
	    String [] b= new String []  {"Luke Skywalker","C-3PO","R2-D2","Darth Vader","Leia Organa","Owen Lars","Beru Whitesun lars","R5-D4","Biggs Darklighter","Obi-Wan Kenobi"};
	    List<String> list = Arrays.asList(b);
	    
	  


	    	//	Verify that the total number of people checked equals the expected count (82 at the time)
		 int resultCount =  js.getInt("results.size()");
		 System.out.println(resultCount);
		 ArrayList<String> a=new ArrayList<String>();
		
		  /* 	Verify that the 10 individuals returned are:
		   		Darth Vader. Chewbacca, Roos Tarpals, Rugor Nass, Yarael Poof, Lama Su, Tuan Wu, Grievous, Tarfful, Tion Medon*/
	   for(int i=0;i<resultCount;i++)
	     {
		   String value = js.get("results["+i+"].name").toString();
		    System.out.println(value);
	      a.add(value);
	 }
	   System.out.println(a);
	   System.out.println(list);
	  if(a.equals(list))
   	 {
       System.out.println("");
   	 }
	  
	
   int counter = 0;
	/*Verify that the total number of people where height is greater than
	200 matches the expected count (10 at the time this was assigned)*/
	
	for(int j=0;j<resultCount;j++)
    {
	   int value1height = js.getInt("results["+j+"].height");
	   System.out.println(value1height);
     if (value1height > 200)
     {
    	 counter++;
    	 
     }
    }
	  System.out.println("height greater than 200 is " + counter);
}
	
}

