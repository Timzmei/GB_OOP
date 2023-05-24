package units;

import java.util.ArrayList;

public interface GameInterface {

    String getInfo();

    void step(ArrayList<Unit> enemy);
    String introduce();
}
