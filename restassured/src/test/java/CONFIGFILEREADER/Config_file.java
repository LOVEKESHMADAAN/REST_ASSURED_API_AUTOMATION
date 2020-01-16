package CONFIGFILEREADER;



	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.Map;

	public class Config_file {
		public static String getConfigValue(String value)  {
			Map<String, String> config = new HashMap<String, String>();
			try {
				BufferedReader file = new BufferedReader(new FileReader(new File("configfile.config")));
				String line = "";
				while((line = file.readLine()) != null) {
					config.put(line.split("=")[0], line.split("=")[1]);
				}
				
			}
			catch(FileNotFoundException e) {
				System.out.println("requirement.config file not found");
			}
			catch(IOException e) {
				System.out.println("IOException occured");
			}
			System.out.println("value from config  is "+config.get(value));
			return config.get(value);
		}
	}



