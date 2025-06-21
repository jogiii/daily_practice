package chainofresponsibility;

public class DebugLogProcessor extends LogProcessor{

    DebugLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
        //TODO Auto-generated constructor stub
    }
    public void log(int level, String message){
        if(level == DEBUG){
            System.out.println("DEBUG "+message);
        }else{
            super.log(level, message);
        }
    }

}
