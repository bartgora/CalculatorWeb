import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import pl.bgora.calculator.web.rest.RestCalculatorController;
import pl.bgora.calculator.web.util.WebCalculatorDecorator;

@ExtendWith(SpringExtension.class)
@WebFluxTest(RestCalculatorController.class)
public class RestCalculatorControllerTest {

    private WebTestClient webClient;

    @Test
    public void testCalculate() throws Exception {
        webClient = WebTestClient.bindToController(new RestCalculatorController(new WebCalculatorDecorator())).build();
        webClient.get().uri("/calculate/1+1")
                .exchange()
                .expectBody().json("""
                {
                    input: 1+1,
                    result: 2.00
                }
                """
        );
    }

    @Test
    public void testCalculate0() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/calculate/0"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("{\"input\":\"0\",\"result\":\"0\"}"));
    }

    @Test
    public void testCalculateDiv() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/calculate/10div2"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("{\"input\":\"10div2\",\"result\":\"5.0\"}"));
    }

    @Test
    public void testMutiply() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/calculate/10*2"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("{\"input\":\"10*2\",\"result\":\"20.0\"}"));
    }

}
