package JavaBackend.HomeWork4.VisitorExample;

public class EatVisitor implements Visitor{
    @Override
    public void visitCat(Cat cat) {
        System.out.println("Кот ест кошачий корм");
    }

    @Override
    public void visitDog(Dog dog) {
        System.out.println("Собака ест собачий корм");
    }
}
