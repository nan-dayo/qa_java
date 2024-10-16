package com.example;

import java.util.List;

public class AlexTheLion extends Lion{

    public AlexTheLion (Predator predator) throws Exception{
        super("Самец", predator);
    }

    public List<String> getFriends(){
        return List.of("Зебра Мартин", "бегемотиха Глория", "жираф Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }

}
