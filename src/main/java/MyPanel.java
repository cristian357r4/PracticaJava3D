import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.Background;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.TransformGroup;
import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    BranchGroup root;
    SimpleUniverse simpleUniverse;
    GraphicsConfiguration graphicsConfiguration;
    Canvas3D canvas3D;
    BranchGroup branchGroup;
    private TransformGroup transformGroup;

    public void inicializar() {


        graphicsConfiguration = SimpleUniverse.getPreferredConfiguration();
        canvas3D = new Canvas3D(graphicsConfiguration);
        simpleUniverse = new SimpleUniverse(canvas3D);


        branchGroup = root;
        branchGroup.compile();

        simpleUniverse.getViewingPlatform().setNominalViewingTransform();
        simpleUniverse.addBranchGraph(branchGroup);

        setLayout(new BorderLayout());
        add(canvas3D, BorderLayout.CENTER);

    }

    public void setBranchGroup(CreateSceneGraph branchGroup) {

        this.root = branchGroup.createSceneGraph();
    }

    public TransformGroup setTransformGroup(Transformaciones transformGroup) {

        return transformGroup.setTransformGroup();
    }

    public TransformGroup setInterpolator(Transformaciones transformaciones) {
        return transformaciones.createInterpolatorSpin();
    }

    public Background setBackground(Iluminacion viewBranchIluminacion){
        return viewBranchIluminacion.createBackground();
    }
}
