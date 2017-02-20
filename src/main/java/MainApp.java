import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.time.Duration;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Arkanoid II");
        primaryStage.getIcons().add(new Image(getClass().getResource("/icon.png").toString()));

        Canvas canvas = new Canvas(1024, 512);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image background = new Image(getClass().getResource("/backgrounds/farback.gif").toString());



        final Duration oneFrameAmt = Duration.ofMillis(1000 / 60);




        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                gc.drawImage(background, 0, 0);

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

            }
        }.start();

        primaryStage.show();
    }
}
