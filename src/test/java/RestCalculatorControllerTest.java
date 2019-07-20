import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.bgora.calculator.web.Main;
import pl.bgora.calculator.web.rest.RestCalculatorController;
import pl.bgora.calculator.web.util.WebCalculatorDecorator;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class RestCalculatorControllerTest {

    private MockMvc mvc;

    private WebCalculatorDecorator webCalculatorDecorator;

    @Before
    public void setup() {
        webCalculatorDecorator = new WebCalculatorDecorator();
        mvc = MockMvcBuilders.standaloneSetup(new RestCalculatorController(webCalculatorDecorator)).build();
    }

    @Test
    public void testCalculate() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculate/1+1"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"input\":\"1+1\",\"result\":\"2.0\"}"));
    }

    @Test
    public void testCalculate0() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculate/0"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"input\":\"0\",\"result\":\"0\"}"));
    }

    @Test
    public void testCalculateDiv() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculate/10div2"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"input\":\"10div2\",\"result\":\"5.0\"}"));
    }

    @Test
    public void testMutiply() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculate/10*2"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"input\":\"10*2\",\"result\":\"20.0\"}"));
    }

}
