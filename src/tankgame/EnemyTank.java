package tankgame;

import java.util.Vector;

public class EnemyTank extends Tank{
    public EnemyTank(int x, int y) {
        super(x, y);
    }
     Vector<Shot> shots =new Vector<>();
    public boolean isLive = true;
}
