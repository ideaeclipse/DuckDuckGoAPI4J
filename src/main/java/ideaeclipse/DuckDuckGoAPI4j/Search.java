package ideaeclipse.DuckDuckGoAPI4j;

import ideaeclipse.JsonUtilities.Json;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.*;

public class Search {
    private final String searchParam;
    private final Json json;

    public Search(final String searchParam) throws IOException {
        this.searchParam = "https://api.duckduckgo.com/?q=" + searchParam.replaceAll(" ", "+") + "&format=json&no_html=1";
        this.json = search();
    }

    private Json search() throws IOException {
        return new Json(downloadStr(this.searchParam));
    }
    public String getLink(){
        return this.json.get("AbstractURL").toString();
    }
    public String getDescription(){
        return this.json.get("Abstract").toString();
    }

    private String downloadStr(String url) throws IOException {
        System.out.println(url);
        HttpsURLConnection con = (HttpsURLConnection) new URL(url).openConnection();
        con.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        con.setRequestProperty("accept-language", "en-US,en;q=0.9");
        con.setRequestProperty("user-agent", "Mozilla/5.0");

        InputStreamReader streamReader = new InputStreamReader(con.getInputStream());
        BufferedReader reader = new BufferedReader(streamReader);
        StringBuilder str = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null)
            str.append(line);
        reader.close();
        return str.toString();
    }
}
