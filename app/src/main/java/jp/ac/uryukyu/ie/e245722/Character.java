package jp.ac.uryukyu.ie.e245722;

import java.util.ArrayList;

public abstract class Character {

    private String Name;
    private int ChargeCount ;
    private int Life ;
    private int BarrierScore;
    private int AttackScore;

    //アクション
    private ArrayList<Action> actions = new ArrayList<>();

    Character(String Name , int Life ){
        this.Name = Name;
        this.Life = Life;
        this.ChargeCount = 0;
        this.BarrierScore = 0;
        this.AttackScore = 0;
    }

    //できるアクションのリスト
    void addAction(Action action){
        actions.add(action);
    }


    //現在の状況を書き出し
    public void showStatus() {
        System.out.printf("%s:charge %d , Life: %d\n", getName(), getChargeCount() , getLife());
    }

    //攻撃＆防御
    public void isAttackBarrier( Character Enemy , boolean Playerjudge , boolean Enemyjudge){
        if( Playerjudge == true && getAttackScore() > Enemy.getBarrierScore() && getAttackScore() > Enemy.getAttackScore() || Playerjudge ==true && Enemyjudge ==false && getAttackScore() > 0){
            System.out.printf("%s:攻撃成功！\n" , getName());
            Enemy.LifeDecrease(1);
        }else if(Playerjudge == true && getAttackScore() > 0 && Enemy.getAttackScore() == 0 || Playerjudge == true && getAttackScore() > 0 && getAttackScore() == Enemy.getAttackScore()){
            System.out.printf("%sの攻撃は防がれた...\n" , getName());
        }else if(Playerjudge == true && getAttackScore() > 0 && getAttackScore() < Enemy.getAttackScore()){
            System.out.printf("%s:攻撃失敗...\n" , getName());
        }else if(Playerjudge == false && getAttackScore() > 0){
            System.out.printf("%s:chargeが足りない...\n", getName());
        }else{
        }
    }

    //Chargeする
    public void Charge(int Charge){
        if(ChargeCount + Charge >= 0){
            ChargeCount += Charge;
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

    //それぞれの行動を描く
    public abstract boolean trurnaction(Character target);

    //getterメソッド
    public String getName(){ return Name; }
    public int getChargeCount() { return ChargeCount; }
    public int getLife() {return Life; }
    public ArrayList<Action> getAction(){return actions;}
    public int getBarrierScore() {return BarrierScore;}
    public int getAttackScore() {return AttackScore;}
}
