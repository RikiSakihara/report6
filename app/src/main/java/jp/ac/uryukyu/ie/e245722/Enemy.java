package jp.ac.uryukyu.ie.e245722;

public class Enemy extends Character{
    
    public Enemy(String name, int Life) {
        super(name , Life);
        
        //アクションは固定
        getAction().add(new Action("バリア" , 0 , 1 ,0));
        getAction().add(new Action("チャージ", 1, 0, 0));
        getAction().add(new Action("かめはめ波", -2, 0, 1));
        getAction().add(new Action("元気玉", -5, 0, 2));
    }

    public boolean trurnaction(Character performer) {
        /* 
        if (getChrageCount() > 2){
            getAction().get(2).act(performer);
        }else{
            getAction().get(1).act(performer);
        }
        */

        boolean judge = getAction().get(2).canAttack(performer);
        getAction().get(2).act(performer);
        
        return judge;
    }

    //生死判別
    public boolean isAlive(){
        if (getLife() > 0){
            return true;
        }else{
            System.out.println("君の勝ち!!");
            return false;
        }
    }
}
