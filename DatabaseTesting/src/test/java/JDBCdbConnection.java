import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class JDBCdbConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";
		
		//Creating connection to mysql server from java
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qatdb", "root", "KavyaDB@2712");
		//Creating statement on the connection to execute queries
		Statement  statement = con.createStatement();
		ResultSet rs = statement.executeQuery("Select * from ShoppingTestData where Testcase = 'Purchase'");
		//The resultset points at base index by default, have to point to 1st index where retrieved records be present
		if(rs.next()) {
			WebDriver driver  = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/client");
			driver.findElement(By.id("userEmail")).sendKeys(rs.getString("Email"));
			driver.findElement(By.id("userPassword")).sendKeys(rs.getString("Password"));
			driver.findElement(By.id("login")).click();		
		}
	}

}
