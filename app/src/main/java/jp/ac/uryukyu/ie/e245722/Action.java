package jp.ac.uryukyu.ie.e245722;

//これは一旦OK
public class Action {
    private String name;
    private int Cost;
    private int BarrierScore;
    private int AttackScore; //AttackScore > CanBarrier　なら攻撃通るs

    //技設定
    Action(String name , int Cost , int BarrierScore , int AttackScore){
        this.name = name;
        this.Cost = Cost;
        this.BarrierScore = BarrierScore;
        this.AttackScore = AttackScore;
    }

    //行動(一旦行動を整理)
    void act(Character performer){
        System.out.printf("%sの行動:%s\n" , performer.getName() , getName());
        performer.Chrage(getCost());
        performer.addBarrierScore(getBarrierScore());
        performer.addAttackScore(getAttackScore());
    }
    
    public String getName(){ return name; }
    public int getCost() {return Cost; }
    public int getBarrierScore(){ return BarrierScore; }
    public int getAttackScore() {return AttackScore;}
}
