package selenium.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDatatoMap() throws IOException {
		//Convert Json data to String
		String stringContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\selenium\\Data\\PurchaseOrder.json"),StandardCharsets.UTF_8);
		
		//convert string to hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>>  data = mapper.readValue(stringContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}

}
