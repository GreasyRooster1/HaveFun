package Core.Phase;

public class Phase {
    public int order;
    private int duration=1;
    public void begin(int phase){
        onStart();
        try {
            Thread.sleep(duration);
        }catch (Exception e){
            System.out.println(e);
        }
        onEnd();
        PhaseManager.phases[phase+1].begin(phase+1);
    }
    public void onStart(){

    }
    public void onEnd(){

    }
    public void setDuration(int i){
        duration = i;
    }
    public int getDuration(){
        return duration;
    }
}
