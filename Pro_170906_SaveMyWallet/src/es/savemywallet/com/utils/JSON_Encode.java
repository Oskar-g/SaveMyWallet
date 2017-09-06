package es.savemywallet.com.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON_Encode {
	
	public static String parse(Object obj) {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "error";
		
		try {
			jsonInString = mapper.writeValueAsString(obj);
//			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonInString;
	}
}
