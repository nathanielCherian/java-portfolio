package roulette;
import java.util.Stack;

public class RouletteControl {

    public static Stack loadChamber() {
        Stack chamber = new Stack();
        int bullet = (int) Math.random() * (6);

        for (int i = 0; i < 6; i++) {
            if (i == bullet)
                chamber.push(new Bullet(0));
            else
                chamber.push(new Bullet(1));
        }

        return chamber;
    }




}
