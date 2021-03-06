import com.sun.j3d.utils.geometry.Box;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import java.awt.*;

public class SimpleLightedColoredCube{
    final BoundingSphere bounding;

    public MyPanel getMyPanel() {

        return myPanel;
    }

    final MyPanel myPanel = new MyPanel();
    public static void main(String[] args) {
        new SimpleLightedColoredCube();
    }

    public SimpleLightedColoredCube() {


        bounding = new BoundingSphere();
        myPanel.setBranchGroup(new CreateSceneGraph() {
            public BranchGroup createSceneGraph() {
                TransformGroup objectTransformGroup, spinTransformGroup;
                BranchGroup root = new BranchGroup();
                Background background = myPanel.setBackground(new Iluminacion() {
                    public Background createBackground() {
                        Background background = new Background();
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

                PointLight pointLight1 = myPanel.createPointLight(new Iluminacion() {
                    public Background createBackground() {
                        return null;
                    }

                    public PointLight createPointLight() {
                        PointLight light = new PointLight(
                                new Color3f(Color.green), new Point3f(3f,3f,3f), new Point3f(1f,0f,0f));
                        light.setInfluencingBounds(bounding);
                        return light;
                    }

                    public AmbientLight createAmbientLight() {
                        return null;
                    }
                });

                PointLight pointLight2 = myPanel.createPointLight(new Iluminacion() {
                    public Background createBackground() {
                        return null;
                    }

                    public PointLight createPointLight() {
                        PointLight light = new PointLight(
                                new Color3f(Color.orange), new Point3f(-2f,2f,2f), new Point3f(1f,0f,0f));
                        light.setInfluencingBounds(bounding);
                        return light;
                    }

                    public AmbientLight createAmbientLight() {
                        return null;
                    }
                });

                AmbientLight ambientLight = myPanel.createAmbientLight(new Iluminacion() {
                    public Background createBackground() {
                        return null;
                    }

                    public PointLight createPointLight() {
                        return null;
                    }

                    public AmbientLight createAmbientLight() {
                        AmbientLight light = new AmbientLight(true, new Color3f(Color.red));
                        BoundingSphere bounds;

                        light.setInfluencingBounds(bounding);
                        return light;

                    }
                });



                Appearance appearance = new Appearance();

                spinTransformGroup = myPanel.setTransformGroup(new Transformaciones() {

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

                    public TransformGroup setTransformGroup() {
                        return null;
                    }
                });



                appearance.setMaterial(new Material());

                Box box = new Box(0.3f, 0.3f, 0.3f, appearance);
                root.addChild(background);
                root.addChild(pointLight1);
                root.addChild(pointLight2);
                root.addChild(ambientLight);
                //spinTransformGroup.addChild(box);
                //root.addChild(spinTransformGroup);
                root.addChild(box);

                return root;

            }
        });

        myPanel.inicializar();

        new SnippetFrame(myPanel, "Programa Ejemplo");
    }
}
