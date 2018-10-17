import ideaeclipse.DuckDuckGoAPI4j.Search;
import ideaeclipse.JsonUtilities.Json;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Search json = new Search("mcdonalds");
        //Prints wiki link
        System.out.println(json.getLink());
        //Prints wiki basic description
        System.out.println(json.getDescription());
    }
}
