package com.caveweb;

/**
 * Created on 5/30/2016.
 */
class Greeting {
    private final long id;
    private final String content;

    protected Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public long getId() {
        return id;
    }
}
