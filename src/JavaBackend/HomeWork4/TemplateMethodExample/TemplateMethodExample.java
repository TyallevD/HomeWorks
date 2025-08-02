package JavaBackend.HomeWork4.TemplateMethodExample;

public class TemplateMethodExample {
    public static void main(String[] args) {
        Game footballGame = new FootballGame();
        footballGame.play();
        System.out.println();

        Game chessGame = new ChessGame();
        chessGame.play();
    }
}
