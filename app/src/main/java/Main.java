import jp.ac.uryukyu.ie.e245722.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //スキャナー
        Scanner scanner = new Scanner(System.in);
        System.out.println("playerの名前を入力してね");
        String text = scanner.next();
        
        int i = 0;
        Player Player = new Player(text, 3);
        Enemy Enemy = new Enemy("Riki", 3);

        Player.showStatus();
        Enemy.showStatus();

        System.out.println("バトル開始!!");

        
        while ( Player.isAlive() == true && Enemy.isAlive() == true ) {

            System.out.printf("\n%dターン目\n",i+1);
            i += 1;
            
            boolean x = Player.trurnaction(Player);
            boolean y = Enemy.trurnaction(Enemy);

            Player.isAttackBarrier(Enemy , x , y);
            Enemy.isAttackBarrier(Player , y , x);

            Player.showStatus();
            Enemy.showStatus();

            System.out.println("---------------\n");//ターミナル上を見やすくしているだけ
        }
        
        scanner.close();
    } 

}
