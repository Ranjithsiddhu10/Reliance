package utility;
import java.io.File;
import java.util.Properties;
import java.io.FileInputStream;


public class Readconfig {
      	Properties prop;
		public Readconfig()
		{
		File src=new File("./configuration files/config.properties");
		System.out.println("here testing");
		try {
			 FileInputStream fis=new FileInputStream(src);
		     prop =new Properties();
		     prop.load(fis);
		}catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
			}}
		
		public String getChromePath()
		{
		String chromepath=prop.getProperty("chromepath");
		return chromepath;
		}

		public String getbaseURL()
		{
			System.out.println("here url testing");
			String baseurl=prop.getProperty("baseurl");
			return baseurl;
			
		}
		
		public String getnumber()
		{
			String number=prop.getProperty("number");
			return number;
				
		}
		public String getsearchvalue()
		{
			String searchvalue=prop.getProperty("searchvalue");
			return searchvalue;
				
		}
}
		
		
	

