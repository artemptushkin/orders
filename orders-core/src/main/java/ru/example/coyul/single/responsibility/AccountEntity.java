package ru.example.coyul.single.responsibility;

public class AccountEntity {
    private String title;
    private boolean active;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isActive() {
        return active;
    }
}
