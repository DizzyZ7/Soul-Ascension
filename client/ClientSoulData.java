package com.dizzy.soulrpg.client;

public class ClientSoulData {
    private static int soul;

    public static void set(int value) {
        soul = value;
    }

    public static int get() {
        return soul;
    }
}
