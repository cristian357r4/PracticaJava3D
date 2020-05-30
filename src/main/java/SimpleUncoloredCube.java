import com.sun.j3d.utils.geometry.Box;


import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;

public class SimpleUncoloredCube {
    public static void main(String[] args) {
        new SimpleUncoloredCube();

    }

    public SimpleUncoloredCube(){
        MyPanel myPanel = new MyPanel();
        myPanel.setBranchGroup(new CreateSceneGraph() {
            public BranchGroup createSceneGraph() {
                BranchGroup root = new BranchGroup();
                Appearance appearance = new Appearance();
                Box box = new Box(0.3f,0.3f,0.3f,appearance);

                root.addChild(box);

                return root;

            }
        });

        myPanel.inicializar();
        new SnippetFrame(myPanel, "Programa Ejemplo");
    }
}
