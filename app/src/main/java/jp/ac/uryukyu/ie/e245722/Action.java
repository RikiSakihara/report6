package jp.ac.uryukyu.ie.e245722;

public class Action {
    private String name;
    private int Cost;
    private int CanBarrier; //0ならバリア可能,1ならバリア不可
    private int damage;

    //技設定
    public Action(String name , int Cost , int CanBarrier , int damage){
        this.name = name;
        this.Cost = Cost;
        this.CanBarrier = CanBarrier;
        this.damage = damage;
    }

    //自分のターンで行ったこと
    public void turn(Character perfomer , Character target){
        System.out.println(perfomer.getName() + ":" + getName() );
        
    }

    public String getName(){ return name; }
    public int getCost() {return Cost; }
    public int getCanBarrier(){ return CanBarrier; }
    public int getDamage() { return damage; }
}
