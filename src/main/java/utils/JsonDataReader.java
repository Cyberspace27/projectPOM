package utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {
	private static JsonNode rootNode;

    public static void loadData(String resourcePath) throws IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        String path = Paths.get(ClassLoader.getSystemResource(resourcePath).toURI()).toString();
        rootNode = mapper.readTree(new File(path));
    }

    public static String getValue(String section, String key) {
        return rootNode.path(section).path(key).asText();
    }
}

