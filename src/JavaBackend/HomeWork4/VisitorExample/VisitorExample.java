package JavaBackend.HomeWork4.VisitorExample;

public class VisitorExample {
    public static void main(String[] args) {
        //Паттерн "Посетитель" - поведенческий паттерн.
        //Позволяет добавлять в программу новые операции, не изменяя классы объектов,
        //над которыми эти операции могут выполняться

        Animal cat = new Cat();
        Animal dog = new Dog();

        Visitor soundVisitor = new SoundVisitor();
        Visitor actionVisitor = new ActionVisitor();

        System.out.println("Звуки и действия животных:");
        cat.accept(soundVisitor);
        cat.accept(actionVisitor);
        System.out.println();

        dog.accept(soundVisitor);
        dog.accept(actionVisitor);
        System.out.println();

        System.out.println("Добавил \"посетителей\" для сна и еды");
        Visitor eatVisitor = new EatVisitor();
        Visitor sleepVisitor = new SleepVisitor();

        System.out.println("Животные едят:");
        dog.accept(eatVisitor);
        cat.accept(eatVisitor);
        System.out.println();

        System.out.println("Животные спят:");
        dog.accept(sleepVisitor);
        cat.accept(sleepVisitor);
    }
}
