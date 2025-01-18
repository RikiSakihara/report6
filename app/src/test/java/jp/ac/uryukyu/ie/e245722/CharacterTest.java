package jp.ac.uryukyu.ie.e245722;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    /*
     * Character内のisAttackBarrierクラスが想定通りに動くかどうかの確認
     * 検証手順
     * (1)PlayerとEnemyを準備する。この時 ChargeCountはそれぞれ0とする。またLifeは10とする。
     * (2)Player：かめはめ波　,　Enemy：チャージ　と行動するようにする。
     * 　　→Playerの攻撃が失敗する　かつ　PlayerのChargeCountが0のままであることを期待
     * (3)PlayerのChargeCountを100に設定する。
     * (4)Player : かめはめ波　, Enemy:かめはめ波　と行動するようにする。
     * 　　→Playerの攻撃が成功することを期待
     * (5)EnemyのChargeCountを100にする。
     * (6)Player：元気玉　,　Enemy：かめはめ波　と行動するようにする。
     * 　　→EnemyのLifeのみが１減少していることを期待
     * (7)Player：かめはめ波　,Enemy：かめはめ波　と行動するようにする。
     * 　　→どちらもLifeが減少しないことを期待
     * (8)Player：かめはめ波　,　Enemy：バリア　と行動するようにする。
     *  　→どちらもLifeが減少しないことを期待
     */
    @Test
    void isAttackBarrierTest() {
        
        //(1)
        int Life = 10;
        Player Player = new Player("demoPlayer", Life);
        Enemy Enemy = new Enemy("demoEnemy", Life);

        //(2)
        TestChackmethod(Player, 2, Enemy, 0);
        assertEquals(Player.getLife() , Life);
        assertEquals(Player.getChargeCount(), 0);
        assertEquals(Enemy.getLife(), Life);

        //(3)
        Player.Charge(100);

        //(4)
        TestChackmethod(Player, 2, Enemy, 2);
        assertEquals(Player.getLife(), Life);
        assertEquals(Enemy.getLife(), Life-1);

        //(5)
        Enemy.Charge(100);

        //(6)
        TestChackmethod(Player, 3 , Enemy, 2 );
        assertEquals(Player.getLife() , Life);
        assertEquals(Enemy.getLife(), Life-2);

        //(7)
        TestChackmethod(Player, 2, Enemy, 2);
        assertEquals(Player.getLife() , Life);
        assertEquals(Enemy.getLife(), Life-2);

        //(8)
        TestChackmethod(Player, 2, Enemy, 0);
        assertEquals(Player.getLife() , Life);
        assertEquals(Enemy.getLife(), Life-2);
    }

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
}
