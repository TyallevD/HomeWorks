package JavaBackend.HomeWork4.VisitorExample;

public class SoundVisitor implements Visitor {
    @Override
    public void visitCat(Cat cat) {
        System.out.println("Мяу");
    }

    @Override
    public void visitDog(Dog dog) {
        System.out.println("Гав");
    }
}
