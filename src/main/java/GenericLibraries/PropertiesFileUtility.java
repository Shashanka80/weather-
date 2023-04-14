package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility 
{
private Properties property;

/**
 * this class contain 
 * 
 */
public void propertyfileInitiaization(String filepath) {
	FileInputStream fil=null;
	
	try {
		fil=new FileInputStream(filepath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	property=new Properties();
	try {
		property.load(fil);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/**
 * 
 */
public String fetchproperty(String key) {
return property.getProperty(key);
}
}