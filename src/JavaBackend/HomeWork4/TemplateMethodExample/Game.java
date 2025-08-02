package JavaBackend.HomeWork4.TemplateMethodExample;

    //абстрактный базовый класс
abstract class Game {
    //Абстрактный класс определяет шаги алгоритма и содержит шаблонный метод, состоящий из вызовов этих шагов.
    //Шаги могут быть как абстрактными, так и содержать реализацию по умолчанию.
    //Шаблонный метод
    public final void play() {
        initialize();
        startGame();
        endGame();
    }

    protected abstract void initialize();

    protected abstract void startGame();

    //реализация по умолчанию
    protected void endGame() {
        System.out.println("Игра окончена");
    }
}
