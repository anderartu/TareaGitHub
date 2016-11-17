package py.edu.facitec.github;

/**
 * Created by user on 03/11/2016.
 */
public class Repository {
    private String name;
    private String descripcion;
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "name='" + name + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
