package ru.hh.nab.hwserver.storage;

public class DTO{

    private int id;
    private String text;
    private boolean done;

    public DTO(int id) {
        this.id = id;
    }

    public int getId() { return this.id; }

    public String getText() { return this.text; }

    public boolean getDone() { return this.done; }

    // сеттера на id не предусмотрено, так как он может задаваться только один раз - при инициализации

    public void setText(String newText) { this.text = newText; }

    public void setDone(String newDone) {
        if (newDone.equals("true")) {this.done = true;}
        if (newDone.equals("false")) {this.done = false;}}
}
