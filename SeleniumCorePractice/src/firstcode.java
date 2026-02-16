import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstcode {
	
	
    public static void main(String[] args) {
    	
    	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\WEL COME\\Desktop\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox");
        driver.manage().window().maximize();
        //driver.get("https://adbtest.service-now.com /login.do");
       
        try {
        	Thread.sleep(5000);
        }
          catch (InterruptedException s) {
        	  s.printStackTrace();
        	  
          }
        

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
       
       
        driver.quit();
    }
    
    
}
