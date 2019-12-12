package theDiningPhilosophers;

import java.util.concurrent.ConcurrentHashMap;
//9ms solution , beat 90%
public class DiningPhilosophers {
    private static ConcurrentHashMap<Integer, Boolean> map = new ConcurrentHashMap<>();
    static{
        map.put(0, false);
        map.put(1, false);
        map.put(2, false);
        map.put(3, false);
        map.put(4, false);
    }
    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFolkId = philosopher-1;
        int rightFolkId = philosopher+1;
        if(leftFolkId<0){
            leftFolkId=4;
        }
        if(rightFolkId>4){
            rightFolkId=0;
        }

        while(map.get(leftFolkId) || map.get(rightFolkId)){
            Thread.sleep(1);
        }
        synchronized (this){
            pickLeftFork.run();
            map.put(leftFolkId,true);
            pickRightFork.run();
            map.put(rightFolkId,true);
        }
        eat.run();
        putLeftFork.run();
        map.put(leftFolkId,false);
        putRightFork.run();
        map.put(rightFolkId,false);
    }
}
