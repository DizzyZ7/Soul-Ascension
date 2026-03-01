package com.dizzy.soulrpg.capability;

public class SoulData implements ISoulData {

    private int soul = 0;

    @Override
    public int getSoul() {
        return soul;
    }

    @Override
    public void setSoul(int value) {
        soul = value;
    }

    @Override
    public void addSoul(int amount) {
        soul += amount;
    }
}
