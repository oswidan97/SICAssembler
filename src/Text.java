/**
 * Created by omar_swidan on 24/03/18.
 */
public class Text {
    private String startAdd;
    private String length;
    private String[] instructions;

    public String getStartAdd() {
        return startAdd;
    }

    public Text setStartAdd(String startAdd) {
        this.startAdd = startAdd;
        return this;
    }

    public String getLength() {
        return length;
    }

    public Text setLength(String length) {
        this.length = length;
        return this;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public Text setInstructions(String[] instructions) {
        this.instructions = instructions;
        return this;
    }
}
