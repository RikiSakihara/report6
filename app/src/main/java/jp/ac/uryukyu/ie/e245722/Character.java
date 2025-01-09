package jp.ac.uryukyu.ie.e245722;

import java.util.ArrayList;

public abstract class Character {

    private String Name;
    private int ChrageCount ;
    private int Life ;

    //コマンド
    ArrayList<Action> actions = new ArrayList<>();

    Character(String Name , int Life ){
        this.Name = Name;
        this.Life = Life;
        this.ChrageCount = 0;
    }

    //できるアクションのリスト
    void addAction(Action action){
        actions.add(action);
    }


    //現在の状況を書き出し
    void showStatus() {
        System.out.printf("%s:charge %d  \n", getName(), getChrageCount());
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

    abstract void act(ArrayList<Character> targets);

    //getterメソッド
    public String getName(){ return Name; }
    public int getChrageCount() { return ChrageCount; }
    public int getLife() {return Life; }
}
