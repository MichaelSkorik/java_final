import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

class Toy {
    int id;
    String name;
    int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }
}

public class java_final_project {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество игрушек:");
        int numToys = scanner.nextInt();

        int[] ids = new int[numToys];
        String[] names = new String[numToys];
        int[] weights = new int[numToys];

        for (int i = 0; i < numToys; i++) {
            System.out.println("Введите id для игрушки " + (i + 1) + ":");
            ids[i] = scanner.nextInt();

            System.out.println("Введите название для игрушки " + (i + 1) + ":");
            names[i] = scanner.next();

            System.out.println("Введите вес (в процентах) для игрушки " + (i + 1) + ":");
            weights[i] = scanner.nextInt();
        }

        PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> t2.weight - t1.weight);

        for (int i = 0; i < numToys; i++) {
            Toy toy = new Toy(ids[i], names[i], weights[i]);
            toyQueue.add(toy);
        }

        for (int i = 0; i < 10; i++) {
            Toy randomToy = getRandomToy(toyQueue);
            if (randomToy != null) {
                writeToLogFile("Get " + (i + 1) + ": " + randomToy.id);
            }
        }

        scanner.close();
    }

    private static Toy getRandomToy(PriorityQueue<Toy> toyQueue) {
        if (toyQueue.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomNum = random.nextInt(100); // Генерируем случайное число от 0 до 99

        int cumulativeWeight = 0;
        for (Toy toy : toyQueue) {
            cumulativeWeight += toy.weight;
            if (randomNum < cumulativeWeight) {
                return toy;
            }
        }

        return null;
    }

    private static void writeToLogFile(String data) {
        try (FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
