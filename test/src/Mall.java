import java.io.IOException;

/**
 * Created by single on 17/3/6.
 */
public class Mall {
    private Long id;

    private String name;

    Mall(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public void throwEx(){
        throw new IllegalStateException();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
