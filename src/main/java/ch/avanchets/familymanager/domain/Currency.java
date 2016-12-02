package ch.avanchets.familymanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by rafal on 09-Nov-16.
 */
@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    private String id;
    private String name;

    public Currency() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
