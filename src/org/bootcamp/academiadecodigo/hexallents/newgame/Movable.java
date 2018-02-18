package org.bootcamp.academiadecodigo.hexallents.newgame;

public interface Movable {

    void move(int distanceX, int distanceY);

    int getOffsetX();

    int getOffsetY();

    void delete();
}