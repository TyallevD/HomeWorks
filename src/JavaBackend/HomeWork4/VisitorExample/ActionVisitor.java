package JavaBackend.HomeWork4.VisitorExample;

public class ActionVisitor implements Visitor {
    @Override
    public void visitCat(Cat cat) {
        System.out.println("Кот гуляет сам по себе");
    }

    @Override
    public void visitDog(Dog dog) {
        System.out.println("Собака гуляет с хозяином на улице");
    }
}
