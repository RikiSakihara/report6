package jp.ac.uryukyu.ie.e245722;
//import java.util.ArrayList;

public class GameMaster {
    
    public static void main(String[] args) {  //Main
        Player Player = new Player("RIki", 3);
        Enemy Enemy = new Enemy("kio", 3);

        Player.showStatus();
        Enemy.showStatus();

        System.out.println("バトル開始!!");

        for  (int i = 0 ; i < 5 ; i++) {
            System.out.printf("%dターン目\n",i+1);
            
            Player.act(Enemy);
            Enemy.act(Player);

            Player.isAttackBarrier(Enemy);
            Enemy.isAttackBarrier(Player);

            Player.showStatus();
            Enemy.showStatus();
        }
    } 
}

