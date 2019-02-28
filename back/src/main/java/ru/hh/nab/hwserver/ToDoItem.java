package ru.hh.nab.hwserver;

public class ToDoItem {

    /*
    Используется для первичной обработки входящих на сервер данных
    и последующей передаче их на DTO
     */

    private String id;
    private String text;
    private String done;

    public ToDoItem() {
    }

    public String getId() { return this.id; }

    public String getText() { return this.text; }

    public String getDone() { return this.done; }

    public void setId(String newId) { this.id = newId; }

    public void setText(String newText) { this.text = newText; }

    public void setDone(String newDone) { this.done = newDone; }
}
