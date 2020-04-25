package likedriving.HelpBharat.unittests;

import com.fasterxml.jackson.core.JsonProcessingException;
import likedriving.HelpBharat.India;
import likedriving.HelpBharat.State;
import likedriving.HelpBharat.Village;
import likedriving.HelpBharat.YamlStorageManager;
import likedriving.design.TravelDestination.DataCrawler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;


public class YamlStorageManagerTest {

    private YamlStorageManager yamlStorageManager;
    private Village village;
    private India india;
    private State state;


    @Before
    public void setup(){
        try {
            yamlStorageManager = new YamlStorageManager();
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }

        village = Village.builder().id(100000).name("MyVillage").build();

        state = state.builder().id(2).name("Karnataka").build();



        india = India.builder()
                .id(1)
                .name("Bharat")
                .states(Arrays.asList(state))
                .build();
    }

    @Test
    public void addTest(){
        yamlStorageManager.add(india);
        Assert.assertTrue(true);
    }

    @Test
    public void appendTest() throws IOException {
        yamlStorageManager.append(DataCrawler.extractStatesWithDistricts());
    }
}
