package com.seleniumdemo.cucumberpackage;

public class Task {

    private String name;
    private String values;
    private String status;

    public Task(String name, String values, String status) {
        this.name = name;
        this.values = values;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", values='" + values + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
