package jp.ac.uryukyu.ie.e245722;

import java.util.ArrayList;

public abstract class Character {

    private String Name;
    private int ChrageCount ;
    private int Life ;
    private int BarrierScore;
    private int AttackScore;

    //アクション
    private ArrayList<Action> actions = new ArrayList<>();

    Character(String Name , int Life ){
        this.Name = Name;
        this.Life = Life;
        this.ChrageCount = 0;
        this.BarrierScore = 0;
        this.AttackScore = 0;
    }

    //できるアクションのリスト
    void addAction(Action action){
        actions.add(action);
    }


    //現在の状況を書き出し
    void showStatus() {
        System.out.printf("%s:charge %d , Life: %d\n", getName(), getChrageCount() , getLife());
    }

    //攻撃＆防御
    void isAttackBarrier( Character Enemy , boolean judge){
        if( judge == true && getAttackScore() > Enemy.getBarrierScore() ){
            System.out.println("攻撃成功！");
            Enemy.LifeDecrease(1);
        }else if(judge ==true && getAttackScore() > 0){
            System.out.printf("%sの攻撃は防がれた...\n" , getName());
        }else if(judge == false && getAttackScore() > 0){
            System.out.println("chargeが足りない...");
        }else{
        }
    }
    
    
    //生存確認(美しくないなぁ)
    boolean isAlive(Character Enemy){
        if (getLife() == 0 || Enemy.getLife() == 0){
            if(getLife() == 0){
                System.out.println("ゲームオーバー");
            }else{
                System.out.printf("%sの勝ち!" , getName());
            }
            return false;
        }else{
            return true;
        }
    }
    

    //Chargeする
    public void Chrage(int Chrage){
        if(ChrageCount + Chrage >= 0){
            ChrageCount += Chrage;
        }else{
        }
        ;
    }

    //Life減少
    public void LifeDecrease(int damage){
        Life -= damage;
        System.out.printf( "%sのLife:" +(getLife() + 1) + "→" + getLife() + "\n", getName());
    }

    //バリア 加算＆初期化
    public void addBarrierScore(int CanBarrier){
        if (BarrierScore > 0){
            BarrierScore = 0;
            BarrierScore += CanBarrier;
        }else{
            BarrierScore += CanBarrier;
        }
    }

    //攻撃　加算＆初期化
    public void addAttackScore(int Score){
        if (AttackScore > 0){
            AttackScore =0;
            AttackScore += Score;
        }else{
            AttackScore += Score;
        }
    }

    //それぞれの行動を描く(サブクラスだよ)
    abstract boolean trurnaction(Character target);

    //getterメソッド
    public String getName(){ return Name; }
    public int getChrageCount() { return ChrageCount; }
    public int getLife() {return Life; }
    public ArrayList<Action> getAction(){return actions;}
    public int getBarrierScore() {return BarrierScore;}
    public int getAttackScore() {return AttackScore;}
}
