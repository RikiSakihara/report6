package jp.ac.uryukyu.ie.e245722;

import java.util.ArrayList;

public class Player extends Character {
    
    Player(String Name, int Life){
        super( Name ,Life );

        //アクションは固定
        actions.add(new Action("バリア" , 0 , 1 ,0));
        actions.add(new Action("チャージ", 1, 0, 0));
        actions.add(new Action("かめはめ波", -2, 0, 1));
        actions.add(new Action("元気玉", -5, 1, 1));

    }

    void act(ArrayList<Character> targets) {
        var command_selector = new CommandSelector();
        
       //選択肢を用意する
        for(var action: getAction()) {
            command_selector.addCommand(action.getName());
        }
       //ユーザの選択を待つ
        var command_number = command_selector.waitForUsersCommand("コマンド？");

       //ターゲットも同様に入力
        command_selector.clearCommands();
        for(var target: targets) {
            command_selector.addCommand(target.getName());
        }
        var target_number = command_selector.waitForUsersCommand("ターゲット？");

        //これがスキャンしている
        getAction().get(command_number).act(this, targets.get(target_number));
        //           ^ユーザが選択したアクション番号                 ^選択したターゲット番号
    }

    



}
