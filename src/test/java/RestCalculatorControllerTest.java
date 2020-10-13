import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import pl.bgora.calculator.web.Main;
import pl.bgora.calculator.web.rest.RestCalculatorController;
import pl.bgora.calculator.web.util.WebCalculatorDecorator;

@SpringBootTest(classes = Main.class)
public class RestCalculatorControllerTest {


    private WebTestClient webClient;

    @BeforeEach
    public void setup() {
        webClient = WebTestClient.bindToController(new RestCalculatorController(new WebCalculatorDecorator())).build();
    }

    @Test
    public void testCalculate() throws Exception {
        webClient.get().uri("/calculate/1+1")
                .exchange()
                .expectBody().json("""
                {
                    'input': '1+1',
                    'result': '2.00'
                }
                """
        );
    }

    @Test
    public void testCalculate0() throws Exception {
        webClient.get().uri("/calculate/0")
                .exchange()
                .expectBody().json("""
                {
                    'input': '0',
                    'result': '0.00'
                }
                """
        );
    }

    @Test
    public void testCalculateDiv() throws Exception {
        webClient.get().uri("/calculate/10div2")
                .exchange()
                .expectBody().json("""
                {
                    'input': '10div2',
                    'result': '5.00'
                }
                """
        );
    }

    @Test
    public void testMultiply() throws Exception {
        webClient.get().uri("/calculate/10*2")
                .exchange()
                .expectBody().json("""
                {
                    'input': '10*2',
                    'result': '20.00'
                }
                """
        );
    }

}
