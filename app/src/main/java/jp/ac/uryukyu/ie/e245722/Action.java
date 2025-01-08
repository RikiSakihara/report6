package jp.ac.uryukyu.ie.e245722;

public interface Action {
    String name();
    void execute(Character performer, Character target);
}
