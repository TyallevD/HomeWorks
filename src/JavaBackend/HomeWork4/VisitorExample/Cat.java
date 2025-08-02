package JavaBackend.HomeWork4.VisitorExample;

public class Cat implements Animal{


    @Override
    public void accept(Visitor visitor) {
        visitor.visitCat(this);
    }
}
