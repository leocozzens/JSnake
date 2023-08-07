package game.utils;

// GUI packages
import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenManager {
    public static double[] getScreenDim() {
        double[] dimensions = new double[2];
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = defaultToolkit.getScreenSize();

        dimensions[0] = screenSize.getWidth();
        dimensions[1] = screenSize.getHeight();

        return dimensions;
    }
}