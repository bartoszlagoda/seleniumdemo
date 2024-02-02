package com.seleniumdemo.cucumberpackage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddTasksStepdefsTest {

    @And("Drukowanie na ekranie zadan za pomoca listy") // Lekcja 42
    public void drukowanieNaEkranieZadanZaPomocaListy(DataTable dataTable) {
        List<String> tasks = dataTable.asList();
        tasks.forEach(System.out::println);
    }

    @And("Drukowanie na ekranie zadan za pomoca mapy") // Lekcja 43
    public void drukowanieNaEkranieZadanZaPomocaMapy(DataTable dataTable) {
        Map<String,String> tasks = dataTable.asMap();
        // wyciaganie kluczy z mapy
        Set<String> keys = tasks.keySet();
        keys.forEach(key -> {
            System.out.println(key);
            System.out.println(tasks.get(key));
        });
    }

    @And("Drukowanie na ekranie zadan za pomoca jawnego podawania mapy") // Lekcja 43
    public void drukowanieNaEkranieZadanZaPomocaJawnegoPodawaniaMapy(Map<String,String> tasks) {
        Set<String> keys = tasks.keySet();
        keys.forEach(key -> {
            System.out.println(key);
            System.out.println(tasks.get(key));
        });
    }

    @And("Wprowadzamy zadania do wykonania") // Lekcja 45
    public void wprowadzamyZadaniaDoWykonania(List<Task> tasks){
        tasks.forEach(System.out::println);
    }
    @DataTableType // Lekcja 45
    public Task handleTask(Map<String,String> table){
        return new Task(table.get("name"),table.get("value"),table.get("status"));
    }
}
