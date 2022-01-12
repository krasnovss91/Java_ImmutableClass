package com.company;

import java.util.ArrayList;
import java.util.Objects;

final class Plane {// как сделать иммутабельный класс. Он должен быть final
    //Это класс, изображающий самолёт, и у него одно поле- места
    final ArrayList<String> passegerNames = new ArrayList<>();//и все его поля final

    public Plane(ArrayList<String> passegers) {//в классе не должно быть сеттеров
        passegerNames.add(String.valueOf(passegers));//Альтернатива- через конструктор
    }

    public ArrayList<String> getPassegerNames() {
        return passegerNames;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Objects.equals(passegerNames, plane.passegerNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passegerNames);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "passegerNames=" + passegerNames +
                '}';
    }


}

public class Main {

    public static void main(String[] args) {
        // write your code here
        String passeger1 = "Ivan";
        String passeger2 = "Petr";
        String passeger3 = "Alexey";

        ArrayList<String> passegers = new ArrayList<>();//создадим список пассажиров и добавим в него людей
        passegers.add(passeger1);
        passegers.add(passeger2);
        passegers.add(passeger3);

        Plane plane = new Plane(passegers);//загрузим наш список пассажиров в самолёт при его создании

        System.out.println(plane.getPassegerNames());

        String passeger4 = "Dzhamil'";
        passegers.add(passeger4);

        System.out.println(plane.getPassegerNames());

        ArrayList<String> result = new ArrayList<>();

        result.addAll(plane.getPassegerNames());
        result.add("Boris");

        System.out.println(plane.getPassegerNames());
    }
}
