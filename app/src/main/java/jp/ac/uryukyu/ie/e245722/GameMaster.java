package jp.ac.uryukyu.ie.e245722;
//import java.util.ArrayList;

public class GameMaster {
    
    //生存確認
    static boolean isAlive(Character performer , Character target){
        if (performer.getLife() == 0 || target.getLife() == 0){
            if(performer.getLife() == 0){
                System.out.println("ゲームオーバー");
            }else{
                System.out.printf("%sの勝ち!" , performer.getName());
            }
            return false;
        }else{
            return true;
        }
    }

    
    public static void main(String[] args) {  //Main

        int i = 0;
        Player Player = new Player("RIki", 3);
        Enemy Enemy = new Enemy("kio", 3);

        Player.showStatus();
        Enemy.showStatus();

        System.out.println("バトル開始!!");

        
        while ( isAlive(Player, Enemy) == true ) {

            System.out.printf("\n%dターン目\n",i+1);
            i += 1;
            
            boolean x = Player.trurnaction(Player);
            boolean y = Enemy.trurnaction(Enemy);

            Player.isAttackBarrier(Enemy , x);
            Enemy.isAttackBarrier(Player , y);

            Player.showStatus();
            Enemy.showStatus();

            System.out.println("---------------\n");//ターミナル上を見やすくしているだけ

            System.out.println(Player.getAttackScore()); 
            System.out.println(Enemy.getBarrierScore());
        }
    } 
}

