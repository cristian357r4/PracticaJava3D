import com.sun.j3d.utils.geometry.ColorCube;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;

public class SimpleRotatedCube{

    public static void main(String[] args) {
        final MyPanel myPanel = new MyPanel();
        myPanel.setBranchGroup(new CreateSceneGraph() {
            public BranchGroup createSceneGraph() {
                TransformGroup transformGroup;

                BranchGroup root = new BranchGroup();

                transformGroup = myPanel.setTransformGroup(new Transformaciones() {
                    public TransformGroup setTransformGroup() {
                        TransformGroup transformGroup;

                        Transform3D rotate = new Transform3D();
                        Transform3D tempRotate = new Transform3D();
                        Transform3D scale = new Transform3D();

                        rotate.rotX(Math.PI/4.0d);
                        tempRotate.rotY(4*Math.PI/3.0d);
                        scale.setScale(0.7);
                        rotate.mul(tempRotate);
                        scale.mul(rotate);

                        transformGroup = new TransformGroup(scale);
                        return transformGroup;

                    }

                    public TransformGroup createInterpolatorSpin() {
                        return null;
                    }

                    public TransformGroup createScaleTransform() {
                        return null;
                    }
                });

                transformGroup.addChild(new ColorCube(0.4));

                root.addChild(transformGroup);

                return root;

            }

        });


        myPanel.inicializar();
        new SnippetFrame(myPanel, "Programa Ejemplo");

    }

}
