
//Задание
//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
//методы. Реализовать в java.
//Создать множество ноутбуков.
//Написать метод, который будет запрашивать у пользователя критерий (или критерии)
//фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
//хранить в Map. Например:
//“Введите цифру, соответствующую необходимому критерию:
//1 - ОЗУ, 2 - Объем ЖД, 3 - Операционная система, 4 - Цвет …
//Далее нужно запросить минимальные значения для указанных критериев - сохранить
//параметры фильтрации можно также в Map.
//Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
//условиям.
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class finalWork {
class Noutbook {
    private String model;
    private int ram;
    private String os;
    private String color;

    public Noutbook(String model, int ram, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Noutbook{" +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Set<Noutbook> Noutbooks = new HashSet<>();
        Noutbooks.add(new Noutbook("Модель 1", 8,  "Windows 10", "Black"));
        Noutbooks.add(new Noutbook("Модель 2", 8,  "MacOS", "Grey"));
        Noutbooks.add(new Noutbook("Модель 3", 16, "Linux", "White"));

        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "Мощность процессора");
        criteria.put(2, "Операционная система");
        criteria.put(3, "Цвет");

        Map<String, Integer> filterParams = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
            System.out.println("Введите минимальные требования " + entry.getValue() + ":");
            int value = scanner.nextInt();
            filterParams.put(entry.getValue(), value);
        }

        Set<Noutbook> filterNout = new HashSet<>();
        for (Noutbook Noutbook : Noutbooks) {
            if (Noutbook.getRam() >= filterParams.get("Мощность процессора") &&
                    Noutbook.getOs().equals(filterParams.get("Операционная система")) &&
                    Noutbook.getColor().equals(filterParams.get("Цвет"))) {
                filterNout.add(Noutbook);
            }
        }
        
        System.out.println("\nВыбранные ноутбуки:");
        for (Noutbook Noutbook : filterNout) {
            System.out.println(Noutbook);
        }
    }
}
}