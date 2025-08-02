package JavaBackend.HomeWork4.TemplateMethodExample;
    //Конкретный класс
public class ChessGame extends Game{
    //Конкретный класс переопределяет некоторые (или все) шаги алгоритма.
    //Конкретные классы не переопределяют сам шаблонный метод.

    @Override
    protected void initialize() {
        System.out.println("Инициализация: игра в шахматы");
    }

    @Override
    protected void startGame() {
        System.out.println("Начало игры: игра в шахматы");
    }
}
