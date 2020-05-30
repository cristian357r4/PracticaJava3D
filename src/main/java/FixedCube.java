import com.sun.j3d.utils.geometry.ColorCube;

import javax.media.j3d.BranchGroup;

public class FixedCube{
    public static void main(String[] args) {
        new FixedCube();

    }

    public FixedCube(){
        MyPanel myPanel = new MyPanel();
        myPanel.setBranchGroup(new CreateSceneGraph() {
            public BranchGroup createSceneGraph() {
                BranchGroup root = new BranchGroup();

                root.addChild(new ColorCube(0.2));

                return root;

            }
        });


        myPanel.inicializar();
        new SnippetFrame(myPanel, "Programa Ejemplo");
    }
}
