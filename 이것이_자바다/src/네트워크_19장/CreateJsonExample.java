package 네트워크_19장;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonExample {

	public static void main(String[] args) {

		JSONObject root = new JSONObject();

		root.put("id", "winter");
		JSONObject tel = new JSONObject();

		tel.put("home", "02-123-1234");
		root.put("tel", tel);

		JSONArray skill = new JSONArray();

		skill.put("java");
		skill.put("spring");

		root.put("skill", skill);
		
		String json = root.toString();
		
		System.out.println(json);
	}

}
