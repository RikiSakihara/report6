package jp.ac.uryukyu.ie.e245722;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandSelector {
    private ArrayList<String> commands;
    private Scanner scanner;

    CommandSelector() {
        scanner = new Scanner(System.in);
        commands = new ArrayList<>();
    }

    //コマンド追加
    void addCommand(String command_name) {
        getCommands().add(command_name);
    }

    //コマンド初期化
    void clearCommands() {
        getCommands().clear();
    }

    //promptを表示した上で，ユーザの選択を待つ
    int waitForUsersCommand(String prompt) {
        var index = 0;
        System.out.println(prompt);
        for(var command : getCommands()) { //選択肢をprint
            System.out.println(index + ":" + command);
            index += 1;
        }

        //標準入力から数値を入力
        while(true) {
            int target_index = scanner.nextInt();

            if (target_index >= 0 && target_index < getCommands().size()) {
                return target_index;
            }
        }        
    }

    public ArrayList<String> getCommands() { return commands ;}
    public Scanner getScanner() { return scanner; }

}