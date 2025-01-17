package jp.ac.uryukyu.ie.e245722;

//import java.util.ArrayList;

public class Player extends Character {
    
    Player(String Name, int Life){
        super( Name ,Life );

        //アクションは固定
        actions.add(new Action("バリア" , 0 , 1 ,0));
        actions.add(new Action("チャージ", 1, 0, 0));
        actions.add(new Action("かめはめ波", -2, 0, 1));
        actions.add(new Action("元気玉", -5, 0, 2));

    }

    void act(Character targets) {
        getAction().get(1).act(this);
    }
}
