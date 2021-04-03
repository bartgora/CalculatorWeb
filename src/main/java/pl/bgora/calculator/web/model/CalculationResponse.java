package pl.bgora.calculator.web.model;

public class CalculationResponse {

    private String input;
    private String result;

    public CalculationResponse(final String input, final String result) {
        this.input = input;
        this.result = result;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
