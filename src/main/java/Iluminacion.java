import javax.media.j3d.AmbientLight;
import javax.media.j3d.Background;
import javax.media.j3d.PointLight;

public interface Iluminacion {
    Background createBackground();
    PointLight createPointLight();
    AmbientLight createAmbientLight();
}
