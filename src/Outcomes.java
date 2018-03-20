import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by omar_swidan on 20/03/18.
 */
public class Outcomes {

    private List<String> sourceFile=new ArrayList<>();
    private Map<String, String> opTable=new HashMap<>();
    private int LOCCR;
    private String startAdd="";
    private List<String> interFile=new ArrayList<>();
    private Map<String,String> symbTable=new HashMap<>();

    public Map<String, String> getOpTable() {
        return opTable;
    }

    public int getLOCCR() {
        return LOCCR;
    }

    public String getStartAdd() {
        return startAdd;
    }

    public List<String> getInterFile() {
        return interFile;
    }

    public Map<String, String> getSymbTable() {
        return symbTable;
    }

    public List<String> getSourceFile() {
        return sourceFile;
    }

    public Outcomes setSourceFile(List<String> sourceFile) {
        this.sourceFile = sourceFile;
        return this;
    }

    public Outcomes setOpTable(Map<String, String> opTable) {
        this.opTable = opTable;
        return this;
    }

    public Outcomes setLOCCR(int LOCCR) {
        this.LOCCR = LOCCR;
        return this;
    }

    public Outcomes setStartAdd(String startAdd) {
        this.startAdd = startAdd;
        return this;
    }

    public Outcomes setInterFile(List<String> interFile) {
        this.interFile = interFile;
        return this;
    }

    public Outcomes setSymbTable(Map<String, String> symbTable) {
        this.symbTable = symbTable;
        return this;
    }
}
