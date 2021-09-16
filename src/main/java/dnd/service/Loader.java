package dnd.service;

import com.google.gson.Gson;
import dnd.model.Data;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Loader {

    Gson gson = new Gson();

    public Data load(String file) throws IOException {
        try(InputStream stream = this.getClass().getClassLoader().getResourceAsStream(file);){
            String text = IOUtils.toString(stream, Charset.defaultCharset());
            return gson.fromJson(text, Data.class);
        }

    }
}
