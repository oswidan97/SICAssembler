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

        LineAssembler la=new LineAssembler();
        Text text=null;
        int instructionsCount=0;
        int i=0;
        String []s=outcomes.getInterFile().get(i).split("\\s");
        la.writeHeader(s[1],Integer.parseInt(s[0]),outcomes.getStartAdd());
        i++;
        String opCode,operand;
        s=outcomes.getInterFile().get(i).split("\\s");


        while (s[0].compareTo("END")!=0) {
            if(s[0].startsWith(".")){
                i++;
                continue;
            }
            opCode=s.length==3?s[2]:s[1];
            operand=s.length==4?s[3]:s[2];

            if (outcomes.getOpTable().get(opCode)!=null) {
                operand = dealWithOperand(operand, s.length);
                if (instructionsCount==0){
                    text=outcomes.getText();
                    la.testInit(s[0],text);
                }else if (instructionsCount<10){
                    la.assembleObjectCodeInst(text,Integer.parseInt(s[0]),
                            outcomes.getOpTable().get(opCode),operand);

                }



            }




             i++;
            s=outcomes.getInterFile().get(i).split("\\s");

        }

    }

    public String dealWithOperand(String operand,int n){

        if(n==4)
            if (outcomes.getSymbTable().get(operand) != null)
                operand = outcomes.getSymbTable().get(operand);
            else {
                operand = "0";
                System.out.println("undefined symbol");
            }

        return operand;
    }
}
