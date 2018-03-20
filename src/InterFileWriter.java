import java.io.*;
import java.util.List;

/**
 * Created by omar_swidan on 20/03/18.
 */
public class InterFileWriter {

    private List<String> interFile;

    public InterFileWriter(List<String> interFile) {
        this.interFile = interFile;
    }

    public void write() throws IOException {

    PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter("/home/omar_swidan/IdeaProjects/SICAssembler/InterFile")));


        for (String s :
                interFile) {
            writer.print(s);
        }
        writer.close();

    }
}
