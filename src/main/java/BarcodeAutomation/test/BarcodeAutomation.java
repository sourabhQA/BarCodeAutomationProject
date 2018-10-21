package BarcodeAutomation.test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BarcodeAutomation {
	
	
	
 @Test	
 public void Barcode() throws IOException, NotFoundException {
	 
	 WebDriverManager.chromedriver().setup();
    WebDriver Driver = new ChromeDriver();
    Driver.get("https://www.barcodesinc.com/generator/index.php");
    Driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    
  String BarcodeURL =   Driver.findElement(By.xpath("//a[@class='barcode']//img")).getAttribute("src");
	 System.out.println(BarcodeURL);
	 URL url = new URL(BarcodeURL);
    BufferedImage bufferedmage = ImageIO.read(url);
   LuminanceSource  luminancesource   =new BufferedImageLuminanceSource(bufferedmage);
   BinaryBitmap binarybitmap = new BinaryBitmap(new HybridBinarizer(luminancesource));
   Result result = new MultiFormatReader().decode(binarybitmap);
	 System.out.println("Barcode text =" + result.getText());
	 
 }

}
