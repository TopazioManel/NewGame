package org.bootcamp.academiadecodigo.hexallents.newgame;

import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.CharacterType;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.Enemy;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.EnemyType;
import org.bootcamp.academiadecodigo.hexallents.newgame.factory.CharacterFactory;
import org.bootcamp.academiadecodigo.hexallents.newgame.factory.EnemyFactory;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.CharacterGfx;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.EnemyGfx;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.Grid;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.GridGfx;

import java.lang.reflect.Field;

public class Game{

    private Grid grid;
    private EnemyFactory factory;
    private Enemy[] enemy;
    private EnemyGfx enemyGfx;
    private Character character;
    private CharacterGfx characterGfx;
    private CharacterFactory characterFactory;
    private Player player;

    public Game(){
        this.factory = new EnemyFactory();
        this.enemy = new Enemy[2];
        for (int i = 0; i < enemy.length; i++){
            enemy[i] = EnemyFactory.getNewEnemy();
        }
        this.characterFactory = new CharacterFactory();

        this.characterGfx = new CharacterGfx(CharacterType.CHARACTER_1);
        this.player = new Player();

    }


    public void init() throws InterruptedException {
        grid = new GridGfx();
        start();
        //characterGfx.draw();
        player.addEventListener();


    }

    public void start() throws InterruptedException {
        int i = 0;
        while (true) {
            Thread.sleep(300);
            moveEnemies();

            characterGfx.draw();
            if(i < enemy.length) {
                enemy[i].move();
                i++;
            }
        }
    }

    private void moveEnemies() throws InterruptedException {
        for (int i = 0; i < enemy.length; i++) {
            if (!enemy[i].isDead() && enemy[i].getXSpeed() < grid.getHeight() &&
                    enemy[i].getYSpeed() < grid.getWidth()) {
                enemy[i].move();
            }

        }
    }

    private void deleteCharacter(){


    }



}
