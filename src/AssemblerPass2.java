import java.io.IOException;

/**
 * Created by omar_swidan on 20/03/18.
 */
public class AssemblerPass2 {


    private Outcomes outcomes;

    public AssemblerPass2(Outcomes outcomes) {
        this.outcomes = outcomes;
    }

    public void pass() throws IOException {

        new LineAnalyser2(outcomes).analyse();

    }

    public static void main(String[] args) {

    }
}
