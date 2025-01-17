package jp.ac.uryukyu.ie.e245722;

import java.util.ArrayList;

public abstract class Character {

    private String Name;
    private int ChrageCount ;
    private int Life ;
    private int BarrierScore;
    private int AttackScore;

    //アクション
    ArrayList<Action> actions = new ArrayList<>();

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
        System.out.printf("%s:charge %d ,Life:%d\n", getName(), getChrageCount() , getLife());
    }

    //攻撃＆防御
    void isAttackBarrier( Character Enemy){

        if(getAttackScore() > Enemy.getBarrierScore() ){
            Enemy.LifeDecrease(1);
        }else if(getAttackScore() > 0){
            System.out.printf("%sの攻撃は失敗..." , getName());
        }else{
        }
    }
    
    //生存確認
    boolean isAlive(){
        if (getLife() == 0 ){
            return false;
        }else{
            return true;
        }
    }
    

    //Chargeする
    public void Chrage(int Chrage){
        ChrageCount += Chrage;
    }


    //Life減少
    public void LifeDecrease(int damage){
        Life -= damage;
        System.out.printf( "%sのLife:" +(getLife() + 1) + "→" + getLife() + "\n", getName());
    }

    //バリア 加算＆初期化
    public void addBarrierScore(int CanBarrier){
        if (CanBarrier == 0){
            BarrierScore = 0;
        }else{
            BarrierScore += CanBarrier;
        }
    }

    //攻撃　加算＆初期化
    public void addAttackScore(int Score){
        if (Score == 0){
            AttackScore =0;
        }else{
            AttackScore += Score;
        }
    }

    //それぞれの行動を描く(サブクラスだよ)
    abstract void act(Character target);

    //getterメソッド
    public String getName(){ return Name; }
    public int getChrageCount() { return ChrageCount; }
    public int getLife() {return Life; }
    public ArrayList<Action> getAction(){return actions;}
    public int getBarrierScore() {return BarrierScore;}
    public int getAttackScore() {return AttackScore;}
}
