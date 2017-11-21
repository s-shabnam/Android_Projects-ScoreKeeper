package com.sushseqi.android.scorekeeper;

/**
 * Created by MKHO on 21/11/17.
 */

public class PlayerImpl implements IPlayer {


    //Score unit
    private final float scoreUnit = 1;
    private final String name;
    private int attackNumber;
    private float score;


    public int getAttackNumber() {
        return attackNumber;
    }

    public void setAttackNumber(int attackNumber) {
        this.attackNumber = attackNumber;
    }


    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;

    }

    public void addScoreUnit() {
        this.setScore(this.getScore() + scoreUnit);

    }
    public String getName() {
        return name;

    }

    public PlayerImpl(String name){
        this.name = name;
    }

    @Override
    public void init() {
        this.setScore(0);
        this.setAttackNumber(0);
    }

    @Override
    public void markDrawGame() {
        this.setScore(this.getScore()+scoreUnit/2);
    }

    @Override
    public void attack() {
        this.setAttackNumber(getAttackNumber()+1);
    }

}
