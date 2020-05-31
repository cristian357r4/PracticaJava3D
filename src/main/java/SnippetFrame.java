import javax.swing.*;
import java.awt.*;

public class SnippetFrame extends JFrame{
    public SnippetFrame(JPanel myPanel, String tituloVentana) {
        setTitle(tituloVentana);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(myPanel);
        setVisible(true);
    }
}
