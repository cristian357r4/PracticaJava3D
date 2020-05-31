import com.sun.j3d.utils.geometry.Box;

import javax.media.j3d.*;

public class SimpleLightedColoredCubePrimitive {
    BoundingSphere bounding = new BoundingSphere();
    public static void main(String[] args) {
        new SimpleLightedColoredCubePrimitive();
    }

    public SimpleLightedColoredCubePrimitive() {
        final MyPanel myPanel = new MyPanel();

        myPanel.setBranchGroup(new CreateSceneGraph() {
            public BranchGroup createSceneGraph() {
                BranchGroup root = new BranchGroup();
                Background background = myPanel.setBackground(new Iluminacion() {
                    public Background createBackground() {
                        Background background = new Background(0.6f, 0.6f, 1.0f);
                        background.setApplicationBounds(bounding);        // marcar su zona de influencia de acuerdo al objeto bounding
                        return background;
                    }

                    public PointLight createPointLight() {
                        return null;
                    }

                    public AmbientLight createAmbientLight() {
                        return null;
                    }
                });
                Appearance appearance = new Appearance();
                appearance.setMaterial(new Material());
                Box box = new Box(0.3f, 0.3f, 0.3f, appearance);
                root.addChild(background);
                root.addChild(box);

                return root;

            }
        });

        myPanel.inicializar();
        new SnippetFrame(myPanel, "Programa Ejemplo");
    }
}
