package sg.edu.nus.iss.cicddemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sg.edu.nus.iss.cicddemo.controller.DataController;

@SpringBootTest
class DataControllerTest {

    @Autowired
    private DataController dataController;

    @Test
    void healthCheckReturnsExpectedMessage() {
        assertEquals("HEALTH CHECK OK!", dataController.healthCheck());
    }

    @Test
    void versionReturnsExpectedMessage() {
        assertEquals("The actual version is 1.0.0", dataController.version());
    }

    @Test
    void nationsContainsTenItemsWithExpectedFields() {
        JsonNode nations = dataController.getRandomNations();
        assertEquals(10, nations.size());
        assertEquals(4, nations.get(0).size());
    }

    @Test
    void currenciesContainsTwentyItemsWithExpectedFields() {
        JsonNode currencies = dataController.getRandomCurrencies();
        assertEquals(20, currencies.size());
        assertEquals(2, currencies.get(0).size());
    }
}
