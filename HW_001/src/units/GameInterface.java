package units;

import java.util.ArrayList;

public interface GameInterface {

    void getInfo();

    void step(ArrayList<Unit> enemy);
    void step();
}
