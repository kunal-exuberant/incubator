package likedriving.HelpBharat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class YamlStorageManager extends StorageManager{

    private ObjectMapper objectMapper;
    private String storagePath = "/Users/kunal.singh1/projects/incubator/src/main/java/likedriving/HelpBharat/datastore/geographical-entity.yaml";

    public YamlStorageManager() throws JsonProcessingException {
        objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.findAndRegisterModules();
    }

    @Override
    public void add(GeographicalEntity geographicalEntity) {
        try {
            objectMapper.writeValue(new File(storagePath), geographicalEntity);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void append(List<State> geographicalEntities) {
        try {
            India india = objectMapper.readValue(new File(storagePath), India.class);
            List<State> states = india.getStates();
            states.addAll(geographicalEntities);
            india.setStates(states);
            objectMapper.writeValue(new File(storagePath), india);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void remove(GeographicalEntity geographicalEntity) {

    }
}
