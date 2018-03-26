/**
 * Created by omar_swidan on 24/03/18.
 */
public class LineAssembler {

    public void writeHeader(String s,int LOCCR,String startAdd){
        StringBuilder sb=new StringBuilder();
        sb.append("H").append(" ").append(s).append(" ").
                append(Integer.parseInt(startAdd)).
                append(" ").append(LOCCR-
                Integer.parseInt(startAdd)).append("\n");

    }
    public void testInit(String startAdd,Text text){


    }

    public void assembleObjectCodeInst(Text text,int LOCCR,String opCode,String operand){





    }
}
