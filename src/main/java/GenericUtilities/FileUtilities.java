package GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Reshma
 *
 */
public class FileUtilities {
	
	 // it is used to get common data from property file based on the key which you have specified at argument
	
public String getproperetykeyvalue(String key) throws Throwable {
FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFile.properties");
Properties prop=new Properties();
prop.load(fis);
String value=prop.getProperty(key);
return value;
}
}
