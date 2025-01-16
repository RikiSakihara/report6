package jp.ac.uryukyu.ie.e245722;

public class Main {
    public static void main(String[] args) {  //Main
        GameMaster master = new GameMaster();
   
        while (master.isAlive() == false ) {
            master.showStatus();
            master.battle();
        }
    } 
}
