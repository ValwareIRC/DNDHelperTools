package dnd.service;

import com.google.gson.Gson;
import dnd.model.Data;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Loader {
    final static String FILE = "rumors.json";

    Gson gson = new Gson();

    public Data load() throws IOException {
        try(InputStream stream = this.getClass().getClassLoader().getResourceAsStream(FILE);){
            String text = IOUtils.toString(stream, Charset.defaultCharset());
            return gson.fromJson(text, Data.class);
        }

    }
}
