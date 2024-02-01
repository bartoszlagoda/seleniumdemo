package com.seleniumdemo.cucumberpackage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class AddTasksStepdefsTest {

    @And("Wprowadzamy zadania do wykonania")
    public void wprowadzamyZadaniaDoWykonania(DataTable dataTable) {
        List<String> tasks = dataTable.asList();
        tasks.forEach(System.out::println);
    }
}
