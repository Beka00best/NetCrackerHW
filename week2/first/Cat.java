package week2.first;

public class Cat implements Voice{
    @Override
    public void voice() {
        System.out.println("Мяу");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.voice();
        Voice voice = new Dog();
        voice.voice();
        Voice voice1 = new Cow();
        voice1.voice();
    }
}
