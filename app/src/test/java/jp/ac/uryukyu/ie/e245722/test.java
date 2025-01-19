package jp.ac.uryukyu.ie.e245722;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class test {
    void TestChackmethod(Character Player ,int PlayerComand , Character Enemy , int EnemyComand ){

        System.out.println("---------------");//見やすくするため

        //turnactionメソッドの簡略化
        boolean judgeX = Player.getAction().get(PlayerComand).canAttack(Player);
        boolean judgeY = Enemy.getAction().get(EnemyComand).canAttack(Enemy);
        Player.getAction().get(PlayerComand).act(Player);
        Enemy.getAction().get(EnemyComand).act(Enemy);
        
        Player.isAttackBarrier(Enemy , judgeX , judgeY);
        Enemy.isAttackBarrier(Player , judgeY , judgeY);
    }

    @Test
    void Test(){
        int Life = 10;
        Player Player = new Player("demoPlayer", Life);
        Enemy Enemy = new Enemy("demoEnemy", Life);
        Player.Charge(100);
        Enemy.Charge(100);

        TestChackmethod(Player, 2, Enemy, 0);
        assertEquals(Player.getLife(), Life);
        assertEquals(Enemy.getLife(), Life);

    }
}
