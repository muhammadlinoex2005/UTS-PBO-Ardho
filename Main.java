import java.util.Scanner;

class Animal {
    private String soundType;

    public Animal(String soundType) {
        this.soundType = soundType;
    }

    public void sound() {
        System.out.println(soundType);
    }
}

class Cat extends Animal {
    public Cat() {
        super("Meow");
    }
}


class Dog extends Animal {
    public Dog() {
        super("Woof Woof");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nama: Muhammad Ardho Rantisy");
        System.out.println("NPM: 2210631170082");
        System.out.println("Kelas: 3C Informatika\n");

        System.out.print("Enter animal type (Cat/Dog): ");
        String animalType = scanner.nextLine();

        Animal animal;

        if (animalType.equalsIgnoreCase("Cat")) {
            animal = new Cat();
        }
        else if (animalType.equalsIgnoreCase("Dog")) {
            animal = new Dog();
        }
        else {
            System.out.println("Invalid animal type");
            return;
        }

        System.out.print("The sound it makes: ");
        animal.sound();

        scanner.close();
    }
}