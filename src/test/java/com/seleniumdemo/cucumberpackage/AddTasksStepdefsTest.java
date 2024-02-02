package com.seleniumdemo.cucumberpackage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddTasksStepdefsTest {

//    @And("Wprowadzamy zadania do wykonania")
//    public void wprowadzamyZadaniaDoWykonania(Map<String,String> tasks) {
////        List<String> tasks = dataTable.asList();
////        Map<String,String> tasks = dataTable.asMap();
//        // wyciaganie kluczy z mapy
//        Set<String> keys = tasks.keySet();
//        keys.forEach(key -> {
//                System.out.println(key);
//                System.out.println(tasks.get(key));
//    });
////        tasks.forEach(System.out::println);
//    }

    @And("Wprowadzamy zadania do wykonania")
    public void wprowadzamyZadaniaDoWykonania(List<Task> tasks){
        tasks.forEach(System.out::println);
    }
    @DataTableType
    public Task handleTask(Map<String,String> table){
        return new Task(table.get("name"),table.get("value"),table.get("status"));
    }
}
