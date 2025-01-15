package jp.ac.uryukyu.ie.e245722;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Character{
    Enemy(String name, int Life) {
        super(name , Life);
        
        //アクションは固定
        actions.add(new Action("バリア" , 0 , 1 ,0));
        actions.add(new Action("チャージ", 1, 0, 0));
        actions.add(new Action("かめはめ波", -2, 0, 1));
        actions.add(new Action("元気玉", -5, 1, 1));
    }

    void act(ArrayList<Character> targets) {

        //選択肢を用意する

        //actionsにいろいろ入れる・・・
        var rand = new Random(); //修正必要あり
        // Randonクラスのインスタンスを生成した時点で特定のシード値が使われる。つまり同じ値が得られる。（最初の数字はランダムではなくなる）
        
        int index = rand.nextInt(getAction().size()); //ランダムに選択されたインデクス
        var selected_action = getAction().get(index);
        selected_action.act(this, targets.get(0));
    }
 
}
