package com.example;

import java.util.List;

public interface Predator {

    List<String> eatMeat() throws Exception;

    List<String> getFood(String animalKind) throws Exception;

    int getKittens();

}
