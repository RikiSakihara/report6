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
        double probability = Math.random();
        boolean judge;

        if(getChargeCount() < 3){
            if (probability < 0.85){
                judge = JudgeAction(1, performer);
            }else{
                judge = JudgeAction(0, performer);
            }    
        }else if(getChargeCount() <5){
            if (probability < 0.7){
                judge = JudgeAction(2, performer);
            }else if(probability < 0.9){
                judge = JudgeAction(1, performer);
            }else{
                judge = JudgeAction(0, performer);
            }
        }else{
            if (probability < 0.75){
                judge = JudgeAction(3, performer);
            }else if(probability < 0.9){
                judge = JudgeAction(2, performer);
            }else if(probability < 0.95){
                judge = JudgeAction(1, performer);
            }else{
                judge = JudgeAction(0, performer);
            }
        }
        return judge;
    }

    //judge&Action
    public boolean JudgeAction(int Action , Character performer){
        boolean Judge = getAction().get(Action).canAttack(performer);
        getAction().get(Action).act(performer);
        return Judge;
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
