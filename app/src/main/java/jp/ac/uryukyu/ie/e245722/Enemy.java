package jp.ac.uryukyu.ie.e245722;

//import java.util.ArrayList;
//import java.util.Random;

public class Enemy extends Character{
    Enemy(String name, int Life) {
        super(name , Life);
        
        //アクションは固定
        actions.add(new Action("バリア"  , 0 , 1  ,0));
        actions.add(new Action("チャージ" , 1, 0, 0));
        actions.add(new Action("かめはめ波" , (-2), 0, 1));
        actions.add(new Action("元気玉", (-5), 0, 2));
    }

    void act(Character targets) {
        if (getChrageCount() > 2){
            getAction().get(2).act(this);
        }else{
            getAction().get(1).act(this);
        }
    }
 
}
