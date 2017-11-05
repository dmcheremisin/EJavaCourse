package lesson150922;

import java.awt.*;

/**
 * Created by dmitr on 17.08.2017.
 */
public class Generalization {

    static class Window{ // monochrome

    }
    static class ColoredWindow extends Window {
        Color color;

    }
}
