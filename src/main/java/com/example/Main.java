package com.example;

public class Main {
    public static void main(String[] args) throws Exception {
        Predator felinePredator = new Feline();

        Cat cat = new Cat(felinePredator);
        System.out.println("Кошка говорит: " + cat.getSound());
        System.out.println("Кошка ест: " + cat.getFood());


        Feline feline = new Feline();
        System.out.println("\nСемейство животного: " + feline.getFamily());
        System.out.println("Пища хищника: " + feline.eatMeat());
        System.out.println("Количество котят у хищника: " + feline.getKittens(3));
        System.out.println("Количество котят у хищника по умолчанию: " + feline.getKittens());

        // Пример использования Lion
        Lion lion = new Lion("Самец", felinePredator);
        System.out.println("\nКоличество котят у льва: " + lion.getKittens());
        System.out.println("Есть ли грива у льва?: " + (lion.doesHaveMane() ? "Да" : "Нет"));
        System.out.println("Есть ли грива у львицы?: " + (lion.doesHaveMane() ? "Нет" : "Да"));


        AlexTheLion alex = new AlexTheLion(felinePredator);
        System.out.println("\nИмя льва: Алекс");
        System.out.println("Друзья льва: " + alex.getFriends());
        System.out.println("Место проживания: " + alex.getPlaceOfLiving());
        System.out.println("Есть ли грива у Алекса? " + (alex.doesHaveMane() ? "Да" : "Нет"));
        System.out.println("Количество котят у Алекса: " + alex.getKittens());
        System.out.println("Еда Алекса: " + alex.getFood());
    }
}
