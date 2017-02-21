package emag;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class newbalance {
	static String price;
	static String pret;
	static int price2;
	static int pret2;
	static ChromeDriver driver = new ChromeDriver();
	public static void main(String [] args) throws InterruptedException{
			driver.get("http://emag.ro");
			driver.findElement(By.id("emg-input-autosuggest")).sendKeys("ML574POG-10");
			driver.findElementByClassName("icon-i10-search").click();
			
			try{
				price = driver.findElementByCssSelector("#offer-price-stock > div.prices > span > span.money-int").getText();
				price2 = Integer.parseInt(price);
				System.out.println(price2);
				if(price2<350){
					sendEmail();
					driver.findElement(By.id(":nb")).sendKeys("Pretul lor este " + price2);
					driver.findElement(By.id(":lz")).click();
					driver.quit();
				} else {
					driver.quit();
				}
			} catch (Exception e){
				System.out.println("There is no reduce price");
				pret = driver.findElementByClassName("money-int").getText();
				System.out.println(pret);
				pret2 = Integer.parseInt(pret);
				if(pret2<300){
					sendEmail();
					driver.findElement(By.id(":nb")).sendKeys("Pretul lor este " + pret2);
					driver.findElement(By.id(":lz")).click();
					driver.quit();
				} else {
					driver.quit();
				}
			}		
	}
	public static void sendEmail() throws InterruptedException{
		driver.get("http://accounts.google.com");
		driver.findElement(By.id("Email")).sendKeys("");
		driver.findElement(By.id("next")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Passwd")).sendKeys("");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(1000);
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='z0']/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("vO")).sendKeys("");
		driver.findElement(By.className("aoT")).sendKeys("adidasi");
	}
}
