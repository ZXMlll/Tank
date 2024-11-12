package tankgame;

public class Bomd {
    int x;
    int y;
    int live = 9;
    boolean isLive = true;

    public Bomd(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void lifeDown(){
        if (live>0){
            --live;
        }
        else
            isLive = false;
    }
}
