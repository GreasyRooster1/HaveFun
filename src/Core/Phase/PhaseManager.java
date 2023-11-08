package Core.Phase;

import static Core.Utils.ArrayUtils.append;
import Phase.*;

public class PhaseManager {
    public static Phase[] phases = {};
    static int cOrder = 0;
    static int currentPhase = 0;
    public static boolean safe = true;
    static void registerPhases(){
        addPhase(new IntroPhase());
        addPhase(new SmallFacePhase());
        addPhase(new FlashFacePhase());
        addPhase(new IdiotPhase1());
        addPhase(new SnakePhase());
        addPhase(new PosterPhase());
        addPhase(new FinalePhase());
    }

    public static void begin() {
        registerPhases();
        phases[currentPhase].begin(currentPhase);
    }
    static void addPhase(Phase p){
        p.order = cOrder;
        cOrder++;
        phases = append(phases,p);
    }
}
