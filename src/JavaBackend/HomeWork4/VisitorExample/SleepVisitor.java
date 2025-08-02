package JavaBackend.HomeWork4.VisitorExample;

public class SleepVisitor implements Visitor{

    @Override
    public void visitCat(Cat cat) {
        System.out.println("Кот спит в тепле на диване");
    }

    @Override
    public void visitDog(Dog dog) {
        System.out.println("Собака спит на лежанке возле кровати");
    }
}
