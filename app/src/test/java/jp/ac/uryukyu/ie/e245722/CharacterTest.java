package jp.ac.uryukyu.ie.e245722;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    /*
     * Character内のisAttackBarrierクラスが想定通りに動くかどうかの確認
     * 検証手順
     * (1)PlayerとEnemyを準備する。この時 ChargeCountはそれぞれ0とする。またLifeは10とする。
     * (2)この時に,Player：かめはめ波　,　Enemy：チャージ　と行動するようにする。
     * 　　→Playerの攻撃が失敗する　かつ　PlayerのChargeCountが0のままであることを期待
     * (3)次に,Player,EnemyのChargeCountを100に設定し直す。
     * (4)Player：元気玉　,　Enemy：かめはめ波　と行動するようにする。
     * 　　→EnemyのLifeのみが１減少していることを期待
     * (5)Player：かめはめ波　,Enemy：かめはめ波　と行動するようにする。
     * 　　→どちらもLifeが減少しないことを期待
     * (6)Player：かめはめ波　,　Enemy：バリア　と行動するようにする。
     * 　　→どちらもLifeが減少しないことを期待
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
        Player.Chrage(100);
        Enemy.Chrage(100);

        //(4)
        TestChackmethod(Player, 3 , Enemy, 2 );
        assertEquals(Player.getLife() , Life);
        assertEquals(Enemy.getLife(), (int)(Life-1));

        //(5)
        TestChackmethod(Player, 2, Enemy, 2);
        assertEquals(Player.getLife() , Life);
        assertEquals(Enemy.getLife(), (int)(Life-1));

        //(6)
        TestChackmethod(Player, 2, Enemy, 0);
        assertEquals(Player.getLife() , Life);
        assertEquals(Enemy.getLife(), (int)(Life-1));
    }

    void TestChackmethod(Character Player ,int PlayerComand , Character Enemy , int EnemyComand ){

        System.out.println("---------------");//見やすくするため

        //turnactionメソッドの簡略化
        boolean judgeX = Player.getAction().get(PlayerComand).canAttack(Player);
        boolean judgeY = Enemy.getAction().get(EnemyComand).canAttack(Enemy);
        Player.getAction().get(PlayerComand).act(Player);
        Enemy.getAction().get(EnemyComand).act(Enemy);
        
        Player.isAttackBarrier(Enemy , judgeX);
        Enemy.isAttackBarrier(Player , judgeY);
    }
}
