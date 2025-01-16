package jp.ac.uryukyu.ie.e245722;
import java.util.ArrayList;

public class GameMaster {
    
    ArrayList<Character> order = new ArrayList<>();
    
    GameMaster() {
        Player Player = new Player("RIki", 3);
        Enemy Enemy = new Enemy("kio", 3);

        getOrder().add(Player);
        getOrder().add(Enemy);
    }

    //死亡判定
    boolean isAlive(){
        boolean x ;
        boolean y ;
        x = (getOrder().get(0)).isAlive();
        y = (getOrder().get(1)).isAlive();
        if (x == false || y == false){
            return false;
        }else{
            return true;
        }
    }

    //攻撃判定
    

    //全キャラクタのステータスを表示（テスト用）
    void showStatus() { 
        for(var ch : getOrder()) {
            ch.showStatus();//このshowStatusはCharacterだよ
        }
    }

    //１ターン実行する
    void battle() { //１ターン実行する
        for(Character ch : getOrder()) {
            ch.act(getOrder());
        }
    }
    
    

    public ArrayList<Character> getOrder() {return order;}
}

