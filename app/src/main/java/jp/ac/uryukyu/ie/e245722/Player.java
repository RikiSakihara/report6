package jp.ac.uryukyu.ie.e245722;

//import java.util.ArrayList;

public class Player extends Character {
    
    Player(String Name, int Life){
        super( Name ,Life );


        //アクションは固定
        getAction().add(new Action("バリア" , 0 , 1 ,0));
        getAction().add(new Action("チャージ", 1, 0, 0));
        getAction().add(new Action("かめはめ波", -2, 0, 1));
        getAction().add(new Action("元気玉", -5, 0, 2));

    }

    boolean trurnaction(Character performer) {
        var command_selector = new CommandSelector();
        
       //選択肢を用意する
        for(var action: getAction()) {
            command_selector.addCommand(action.getName());
        }

       //ユーザの選択を待つ
        var command_number = command_selector.waitForUsersCommand("コマンド？");

        System.out.println("---------------");

        boolean judge = getAction().get(command_number).canAttack(performer);
        getAction().get(command_number).act(performer);
        
        return judge;
        
        
        
    }

}
