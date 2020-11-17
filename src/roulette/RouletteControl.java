package roulette;
import java.util.Random;
import java.util.Stack;

public class RouletteControl {

    public static Stack loadChamber() {
        Stack chamber = new Stack();
        int bullet = (int) Math.floor(Math.random() * 6);
        System.out.println(bullet);

        for (int i = 0; i < 6; i++) {
            if (i == bullet)
                chamber.push(new Bullet(0));
            else
                chamber.push(new Bullet(1));
        }

        return chamber;
    }




}
