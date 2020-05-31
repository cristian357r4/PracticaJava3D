import com.sun.j3d.utils.geometry.ColorCube;

import javax.media.j3d.*;

public class SimpleDynamicFixedCube {
    public static void main(String[] args) {
        final MyPanel myPanel = new MyPanel();
        myPanel.setBranchGroup(new CreateSceneGraph() {
            public BranchGroup createSceneGraph() {
                TransformGroup objectTransformGroup, spinTransformGroup;

                BranchGroup root = new BranchGroup();

                objectTransformGroup = myPanel.setTransformGroup(new Transformaciones() {
                    public TransformGroup setTransformGroup() {
                        Transform3D scale = new Transform3D();
                        TransformGroup transformGroup = new TransformGroup(scale);
                        transformGroup.addChild(new ColorCube(0.4));
                        return transformGroup;
                    }

                    public TransformGroup createInterpolatorSpin() {
                        return null;
                    }

                    public TransformGroup createScaleTransform() {
                        return null;
                    }
                });

                spinTransformGroup = myPanel.setInterpolator(new Transformaciones() {
                    public TransformGroup setTransformGroup() {
                        return null;
                    }

                    public TransformGroup createInterpolatorSpin() {
                        TransformGroup objectSpin;
                        Alpha rotationAlpha;
                        RotationInterpolator interpolator;
                        BoundingSphere bounds;

                        objectSpin = new TransformGroup();
                        rotationAlpha = new Alpha(-1, 4000);
                        bounds = new BoundingSphere();
                        interpolator = new RotationInterpolator(rotationAlpha, objectSpin);

                        objectSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
                        interpolator.setSchedulingBounds(bounds);
                        objectSpin.addChild(interpolator);

                        return objectSpin;

                    }

                    public TransformGroup createScaleTransform() {
                        return null;
                    }
                });

                spinTransformGroup.addChild(objectTransformGroup);


                root.addChild(spinTransformGroup);

                return root;

            }

        });


        myPanel.inicializar();
        new SnippetFrame(myPanel, "Programa Ejemplo");

    }


}
