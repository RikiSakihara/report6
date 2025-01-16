package jp.ac.uryukyu.ie.e245722;

import java.util.ArrayList;

public abstract class Character {

    private String Name;
    private int ChrageCount ;
    private int Life ;
    private int Barrier;
    private int AttackScore;

    //アクション
    ArrayList<Action> actions = new ArrayList<>();

    Character(String Name , int Life ){
        this.Name = Name;
        this.Life = Life;
        this.ChrageCount = 0;
        this.Barrier = 0;
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
        System.out.println("Charge数 :" + ChrageCount);
    }


    //Life減少
    public void LifeDecrease(int damage){
        Life -= damage;
        System.out.println( (getLife() + 1) + "→" + getLife());
    }

    //バリア 加算＆初期化
    public void addBarrierCount(int CanBarrier){
        if (CanBarrier == 0){
            Barrier = 0;
        }else{
            Barrier += CanBarrier;
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

    
    abstract void act(ArrayList<Character> targets); //サブクラスで定義する

    //getterメソッド
    public String getName(){ return Name; }
    public int getChrageCount() { return ChrageCount; }
    public int getLife() {return Life; }
    public ArrayList<Action> getAction(){return actions;}
    public int getBarrier() {return Barrier;}
    public int getAttackScore() {return AttackScore;}
}
