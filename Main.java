import java.util.*;

class Notebook {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Notebook(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Тут создаю множества ноутбуков
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Lenovo", 8, 512, "Windows", "Black"));
        notebooks.add(new Notebook("HP", 16, 1024, "Windows", "Silver"));
        notebooks.add(new Notebook("Dell", 16, 512, "Linux", "Black"));

        // Метод для фильтрации ноутбуков
        filterNotebooks(notebooks);
    }

    public static void filterNotebooks(Set<Notebook> notebooks) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();

        // Ввод для критериев фильтрации
        System.out.println("Введите критерии фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.print("Выберите номер критерия: ");
        int criteria = scanner.nextInt();

        switch (criteria) {
            case 1:
                System.out.print("Введите минимальный объем ОЗУ: ");
                int minRam = scanner.nextInt();
                filters.put("ram", minRam);
                break;
            case 2:
                System.out.print("Введите минимальный объем ЖД: ");
                int minStorage = scanner.nextInt();
                filters.put("storage", minStorage);
                break;
            case 3:
                System.out.print("Введите операционную систему: ");
                String os = scanner.next();
                filters.put("os", os);
                break;
            case 4:
                System.out.print("Введите цвет: ");
                String color = scanner.next();
                filters.put("color", color);
                break;
            default:
                System.out.println("Неверный номер критерия");
                return;
        }

        // Фильтрация ноутбуков и вывод результатов
        for (Notebook notebook : notebooks) {
            boolean passFilter = true;
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                switch (entry.getKey()) {
                    case "ram":
                        if (notebook.getRam() < (int) entry.getValue()) {
                            passFilter = false;
                        }
                        break;
                    case "storage":
                        if (notebook.getStorage() < (int) entry.getValue()) {
                            passFilter = false;
                        }
                        break;
                    case "os":
                        if (!notebook.getOs().equalsIgnoreCase((String) entry.getValue())) {
                            passFilter = false;
                        }
                        break;
                    case "color":
                        if (!notebook.getColor().equalsIgnoreCase((String) entry.getValue())) {
                            passFilter = false;
                        }
                        break;
                }
            }
            if (passFilter) {
                System.out.println(notebook);
            }
        }
    }
}
