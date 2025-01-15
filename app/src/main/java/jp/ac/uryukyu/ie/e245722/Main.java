package jp.ac.uryukyu.ie.e245722;
import java.util.ArrayList;

public class Main {
    
    ArrayList<Character> order = new ArrayList<>();
    
    Main() {
        Character Player = new Player("RIki", 3);
        Character Enemy = new Enemy("kio", 3);

        getOrder().add(Player);
        getOrder().add(Enemy);
    }

    //死亡判定
    boolean isAlive(Character Character){
        if (Character.getLife() > 0 ){
            return true;
        }else{
            return false;
        }
    }

    //全キャラクタのステータスを表示（テスト用）
    void showStatus() { 
        for(var ch : getOrder()) {
            ch.showStatus();
        }
    }

    //１ターン実行する
    void battle() { 
        for(Character ch : getOrder()) {
            ch.act(getOrder());
        }
    }
    
    public static void main(String[] args) {  //Main
        var master = new Main();
   
        for(var i=0; i<3; i++) {
            master.showStatus();
            master.battle();
         }
    } 

    public ArrayList<Character> getOrder() {return order;}
}

