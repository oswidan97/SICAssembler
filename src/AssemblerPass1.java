import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by omar_swidan on 18/03/18.
 */
public class AssemblerPass1 {

    private List<String> sourceFile;
    private Map<String, String> opTable;
    private int LOCCR;
    private String startAdd="";


    public void pass() throws IOException {

        sourceFile = readSource();
        opTable=readOpTable();
        LineAnalyser analyser= new LineAnalyser(sourceFile,opTable);
       // System.out.println(Integer.parseInt("0C"));
        List<String> interFile= analyser.analyse();


        new InterFileWriter(interFile).write();
    }

    public List<String> readSource() throws IOException {

        Path path= Paths.get("/home/omar_swidan/IdeaProjects/SICAssembler/SourceCode");
        return Files.readAllLines(path);
    }
    public  Map<String,String> readOpTable() throws IOException {

        Path path=Paths.get("/home/omar_swidan/IdeaProjects/SICAssembler/Optable");
        return listToMap(Files.readAllLines(path));

    }
    public Map<String,String> listToMap(List<String> list){

        Map<String,String> map=new HashMap<>();
        for (String t :
                list) {
            String[] s = t.split("\\s");
            map.put(s[0],s[1]);

        }
        return map;
    }

    public static void main(String[] args) {
        try {
            new AssemblerPass1().pass();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
