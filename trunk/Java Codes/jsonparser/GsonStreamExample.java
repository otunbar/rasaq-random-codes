package labs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.stream.JsonReader;

public class GsonStreamExample {
	public static void main(String[] args) {

		try {

			String finalOutput = "";
			JsonReader reader = new JsonReader(new FileReader("yelpdata.txt"));

			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				while (reader.hasNext()) {

					String name = reader.nextName();
                    
					if(name.equals("votes")){
						continue;
					}
					
					else if (name.equals("latitude")) {

						finalOutput += reader.nextString() + "\n";

					} else if (name.equals("longitude")) {

						finalOutput += reader.nextString() + ",";

					} else if (name.equals("city")) {

						finalOutput += reader.nextString() + ",";
					} else if (name.equals("state")) {

						finalOutput += reader.nextString() + ",";
					} else {
						reader.skipValue(); // avoid some unhandle events
					}

				}
				
				reader.endObject();
			}
			reader.endArray();
			reader.close();

			System.out.print(finalOutput);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}