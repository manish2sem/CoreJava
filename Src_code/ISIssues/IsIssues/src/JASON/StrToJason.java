package JASON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StrToJason {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		strToJason();

	}
	
	private static void strToJason() throws JSONException{
		
		String message;
		JSONObject json = new JSONObject();
		json.put("name", "student");

		JSONArray array = new JSONArray();
		JSONObject item = new JSONObject();
		item.put("information", "test");
		item.put("id", 3);
		item.put("name", "course1");
		array.put(item);
		json.put("course", array);
		
		json.put("id", "Student-id");

		message = json.toString();
		
		System.out.println("JASON String : "+message);
		
		
	}

}
