package jp.ac.uryukyu.ie.e245722;
import java.util.ArrayList;

public class GameMaster {

    ArrayList<Character> order = new ArrayList<>();
    
    void showStatus() { //全キャラクタのステータスを表示（テスト用）
        for(var ch : getOrder()) {
            ch.showStatus();
        }
    }

    //actわからん　保留
    void battle() { //１ターン実行する
        for(var ch : getOrder()) {
            ch.act(getOrder());
        }
    }
    public static void main(String[] args) {  //Main
        var master = new GameMaster();
   
        for(var i=0; i<3; i++) {
            master.showStatus();
            master.battle();
         }
    } 
 

    public ArrayList<Character> getOrder() {return order;}
}

