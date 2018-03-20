import java.util.*;

/**
 * Created by omar_swidan on 19/03/18.
 */
public class LineAnalyser {

    private List<String> sourceFile;
    private List<String> interFile=new ArrayList<>();
    private Map<String,String> symbTable=new HashMap<>();
    private Map<String,String> opTable;
    private int LOCCR;
    private String startAdd="";
    private boolean errorFlag=false;

    public Map<String, String> getSymbTable() {
        return symbTable;
    }

    public LineAnalyser(List<String> sourceFile, Map<String, String> opTable) {
        this.sourceFile = sourceFile;
        this.opTable = opTable;
    }

    public List<String> analyse(){

        String[] s=sourceFile.get(0).split("\\s");
        analyseFirstLine(s);

        analyseLines();
        return interFile;

    }
    public void analyseFirstLine(String[] s){

        if (s[1].compareToIgnoreCase("start") == 0) {
            startAdd = s[2];
            LOCCR = Integer.parseInt(s[2],16);

            addToInterList(LOCCR,s);

        } else LOCCR = 0;

    }
    public void analyseLines(){

        int i=1;
        String[] s=sourceFile.get(i).split("\\s");

        while (s[0].compareTo("END")!=0){

           s= sourceFile.get(i).split("\\s");

            if (checkComment(sourceFile.get(i)))
            {
                i++;
                continue;
            }

           if (s.length==3)if (symbTable.get(s[0]) == null) {
                symbTable.put(s[0], Integer.toHexString(LOCCR));
            }else {
                    System.out.println("duplicate symbol at "+LOCCR);
                    errorFlag=true;
                    i++;
                    continue;
            }
            addToInterList(this.LOCCR,s);
            dealWithOpCode(s);
            i++;
        }

        Set<String> set= symbTable.keySet();
        for (String t :
                set) {
            System.out.println(t+" "+symbTable.get(t));
        }


    }
    public boolean checkComment(String s){

        if(s.startsWith(".")) {
            interFile.addAll(Arrays.asList(s));
            interFile.add("\n");
            return true;
        }
        return false;
    }
    public void dealWithOpCode(String[] s){

        String opCode=s.length==3?s[1]:s[0];
        String operand=s.length==3?s[2]:s[1];


        if (opTable.get(opCode)!=null||opCode.compareTo("WORD")==0) {
            LOCCR += 3;

        } else if (opCode.compareTo("RESW")==0) {
            LOCCR += 3 * Integer.parseInt(operand,16);
        } else if(opCode.compareTo("RESB")==0) {
            LOCCR += Integer.parseInt(operand,16);

        } else if (opCode.compareTo("BYTE")==0) {
            LOCCR += operand.length();
        } else
            errorFlag=true;

    }
    public void addToInterList(int LOCCR,String []s){
        StringBuilder sb=new StringBuilder();
        sb.append(Integer.toHexString(LOCCR));

        for (String t: s)
            sb.append(" ").append(t);
        sb.append("\n");
        interFile.add(sb.toString());

    }
}
