import java.util.*;

/**
 * Created by omar_swidan on 19/03/18.
 */
public class LineAnalyser {

    private Outcomes outcomes;
   private boolean errorFlag=false;

    public LineAnalyser(Outcomes outcomes) {
         this.outcomes=outcomes;
    }

    public void analyse(){

        String[] s=outcomes.getSourceFile().get(0).split("\\s");
        analyseFirstLine(s);

        analyseLines();


    }

    public void analyseFirstLine(String[] s){

        if (s[1].compareToIgnoreCase("start") == 0) {
            outcomes.setStartAdd( s[2]);

           outcomes.setLOCCR( Integer.parseInt(s[2],16));

            addToInterList(outcomes.getLOCCR(),s);

        } else outcomes.setLOCCR(0);

    }
    public void analyseLines(){

        int i=1;
        String[] s=outcomes.getSourceFile().get(i).split("\\s");

        while (s[0].compareTo("END")!=0){


            if (checkComment(outcomes.getSourceFile().get(i)))
            {
                i++;
                continue;
            }

           if (s.length==3)if (outcomes.getSymbTable().get(s[0]) == null) {
                outcomes.getSymbTable().put(s[0], Integer.toHexString(outcomes.getLOCCR()));
            }else {
                    System.out.println("duplicate symbol at "+outcomes.getLOCCR());
                    errorFlag=true;
                    i++;
                    continue;
            }
            addToInterList(outcomes.getLOCCR(),s);
            dealWithOpCode(s);
            i++;
            s= outcomes.getSourceFile().get(i).split("\\s");
        }
        addToInterList(-1,s);

        Set<String> set= outcomes.getSymbTable().keySet();
        for (String t :
                set) {
            System.out.println(t+" "+outcomes.getSymbTable().get(t));
        }


    }
    public boolean checkComment(String s){

        if(s.startsWith(".")) {
            outcomes.getInterFile().addAll(Arrays.asList(s));
            outcomes.getInterFile().add("\n");
            return true;
        }
        return false;
    }
    public void dealWithOpCode(String[] s){

        String opCode=s.length==3?s[1]:s[0];
        String operand=s.length==3?s[2]:s[1];


        int LOCCR=outcomes.getLOCCR();
        if (outcomes.getOpTable().get(opCode)!=null||opCode.compareTo("WORD")==0) {
            LOCCR+= 3;

        } else if (opCode.compareTo("RESW")==0) {
            LOCCR += 3 * Integer.parseInt(operand,16);
        } else if(opCode.compareTo("RESB")==0) {
            LOCCR += Integer.parseInt(operand,16);

        } else if (opCode.compareTo("BYTE")==0) {
            LOCCR += operand.length();
        } else{
            errorFlag=true;
            System.out.println(opCode+" "+operand);
            System.out.println("invalid opcode");
        }
        outcomes.setLOCCR(LOCCR);

    }
    public void addToInterList(int LOCCR,String []s){
        StringBuilder sb=new StringBuilder();
        if (LOCCR!=-1)sb.append(Integer.toHexString(LOCCR));

        for (String t: s)
            sb.append(" ").append(t);
        sb.append("\n");
       outcomes.getInterFile().add(sb.toString());

    }
}
