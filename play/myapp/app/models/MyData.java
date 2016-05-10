package models;

import javax.persistence.*;

import com.avaje.ebean.*;
import play.data.validation.*;

@Entity
public class MyData extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    public String mail;
    public String tel;

    public static Finder<Long, MyData> find =
        new Finder<Long, MyData>(Long.class, MyData.class);
}
