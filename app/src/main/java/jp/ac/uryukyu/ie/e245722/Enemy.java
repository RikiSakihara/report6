package jp.ac.uryukyu.ie.e245722;

//import java.util.ArrayList;
//import java.util.Random;

public class Enemy extends Character{
    Enemy(String name, int Life) {
        super(name , Life);
        
        //アクションは固定
        getAction().add(new Action("バリア" , 0 , 1 ,0));
        getAction().add(new Action("チャージ", 1, 0, 0));
        getAction().add(new Action("かめはめ波", -2, 0, 1));
        getAction().add(new Action("元気玉", -5, 0, 2));
    }

    boolean trurnaction(Character performer) {
        /* 
        if (getChrageCount() > 2){
            getAction().get(2).act(performer);
        }else{
            getAction().get(1).act(performer);
        }
        */

        boolean judge = getAction().get(0).canAttack(performer);
        getAction().get(0).act(performer);
        
        return judge;
    }
 
}
