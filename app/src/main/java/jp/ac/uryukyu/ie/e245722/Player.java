package jp.ac.uryukyu.ie.e245722;

import java.util.ArrayList;

public class Player extends Character {
    
    Player(String Name, int Life){
        super( Name ,Life );
    }

    @Override
    void act(ArrayList<Character> targets) {
        CommandSelector command_selector = new CommandSelector();
        
       //選択肢を用意する
        for(var action: actions) {
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

        
        //executeの代替案を考えないといけないよ
        actions.get(command_number).execute(this, targets.get(target_number));
        //           ^ユーザが選択したアクション番号                 ^選択したターゲット番号
    }



}
