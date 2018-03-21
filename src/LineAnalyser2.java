import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by omar_swidan on 20/03/18.
 */
public class LineAnalyser2 {

    private Outcomes outcomes;
    private List<String> objectProg;
    public LineAnalyser2(Outcomes outcomes) {
        this.outcomes = outcomes;
        objectProg=outcomes.getObjectProg();
        objectProg=new ArrayList<>();
    }

    public void analyse(){

        int i=0;
        String []s=outcomes.getInterFile().get(i).split("\\s");
        writeHeader(s[1]);
        i++;
        s=outcomes.getInterFile().get(i).split("\\s");



    }
    public void writeHeader(String s){
        StringBuilder sb=new StringBuilder();
        sb.append("H").append(" ").append(s).append(" ").
                append(Integer.parseInt(outcomes.getStartAdd())).
                append(" ").append(outcomes.getLOCCR()-
                Integer.parseInt(outcomes.getStartAdd())).append("\n");



    }
}
