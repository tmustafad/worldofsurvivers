package com.turkmen.survivor.ui;

public enum Command {
    REGISTER(1, "Register"),
    START(2, "start"),
    PAUSE(3, "pause"),
    RESUME(4, "resume"),
    STATS(5, "stats"),
    HELP(6, "help"),
    EXIT(0, "exit");

    private final int code;
    private final String text;

    Command(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getCode() {
        return this.code;
    }
}
