package tankgame;

import java.io.*;
import java.util.Vector;

public class Recorder {
    private static int allEnemyTankNum = 0;
    private static Vector<EnemyTank> enemyTanks = null;
    static Vector<Node> nodes = new Vector<>();
    private static BufferedReader reader = null;


    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    public void AllEnemyTankNum() {
        ++allEnemyTankNum;
    }

    private static BufferedWriter bw = null;
    private static String recordFile = "d:\\myRecord.txt";

    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum + "\n");
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive) {
                    String record = enemyTank.getX() + "\t" + enemyTank.getY() + "\t" + enemyTank.getDirect() + "\t";
                    bw.write(record + "\t\n");
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static Vector<Node> getNodes() {
        try {
            reader = new BufferedReader(new FileReader(recordFile));
            allEnemyTankNum = Integer.parseInt(reader.readLine());
            String s = "";
            while ((s = reader.readLine()) != null) {
                String[] xyz = s.split("\t");
                Node node = new Node(Integer.parseInt(xyz[0]), Integer.parseInt(xyz[1]),
                        Integer.parseInt(xyz[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        return nodes;
    }


}
