
package com.ysfaltn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class SeleniumProj { 
    public static void main(String[] args) {  
        WebDriver driver = new FirefoxDriver(); 
        
        //It connects to Facebook.com
        driver.get("http://www.facebook.com/");
        
        //User name and password are entered
        driver.findElement(By.id("email")).sendKeys("xxxx");
        driver.findElement(By.id("pass")).sendKeys("xxxx");
        driver.findElement(By.id("u_0_l")).click();
        
        //Go to https://www.facebook.com/login.php?login_attempt=1 If you go to page n11.com
        if(!driver.getCurrentUrl().equals("https://www.facebook.com/login.php?login_attempt=1")){
            connectN11();
        }
    }
    /**
     * In n11.com transactions
     */
    private static void connectN11(){
        WebDriver driver = new FirefoxDriver();
        
        //It connects to n11.com 
        driver.get("http://www.n11.com/");
         
        //Log in and click the Find button 
        List<WebElement> findLink = driver.findElements(By.tagName("a"));
        for(WebElement element: findLink){
            String title = element.getAttribute("title"); 
            if(title.equals("Giriş Yap")){
                driver.get(element.getAttribute("href"));
                break;
            }
        }   
       
        System.out.println(driver.getCurrentUrl());
        
        //Sign in page, enter the user name and password and clicks on loginbuton
        driver.findElement(By.id("email")).sendKeys("altuny71@gmail.com");
        driver.findElement(By.id("password")).sendKeys("q1w2e3");
        driver.findElement(By.id("loginButton")).click();
          
        System.out.println(driver.getCurrentUrl());
        
        //Is written instead of searching samsung
        WebElement query = driver.findElement(By.id("productSearchInput"));
        query.sendKeys("Samsung");
        
        //Search button is clicked
        driver.findElement(By.id("btnSearch")).click();
         
        System.out.println(driver.getCurrentUrl());
        
        //Clicking the link is located on page 2 and
        List<WebElement> allSuggestions = driver.findElements(By.className("pageLink")); 
        for (WebElement suggestion : allSuggestions) { 
            if(suggestion.getText().equals("2") && !suggestion.getText().isEmpty()){
                driver.get(suggestion.getAttribute("href"));
                break;
            }
        }
        
        System.out.println(driver.getCurrentUrl());
        
        //2 pages of results are clicked on 3 products
        List<WebElement> resultDiv = driver.findElements(By.className("catalogItem"));
        int count = 0;
        for (WebElement suggestion : resultDiv) { 
            if(count == 2){
                suggestion.findElement(By.className("itemContainer")).click();
                break;
            }
            count ++;
        }
        
        //get to watch button is clicked
        driver.findElement(By.xpath("//a[@class='button big white inicon monitoring buyerWatchButton ']")).click();
        
        //I'd watch button is clicked
        driver.findElement(By.xpath("//a[@title='İzlediklerim' and @rel='nofollow']")).click();
       
        System.out.println(driver.getCurrentUrl());
        
        //last watched items are removed
        List<WebElement> recordList =  driver.findElements(By.xpath("//a[@class='removeSelectedProduct']"));
        int size = recordList.size();
        System.out.print(size);
        count = 0;
        for (WebElement suggestion : recordList) { 
            count ++;
            if(count == size){
                suggestion.click();
            }  
        }
    }
}
