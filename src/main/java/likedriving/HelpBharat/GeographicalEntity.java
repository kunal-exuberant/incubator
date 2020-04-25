package likedriving.HelpBharat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Inject;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class GeographicalEntity implements GeoSupportFunctions{
    protected Integer id;
    protected String name;
    protected GeographicalEntityType entityType;
    protected GeographicalEntityType belongsTo;

    @Inject
    @JsonIgnore
    private StorageManager storageManager;

    public GeographicalEntity(Integer id, String name, GeographicalEntityType entityType, GeographicalEntityType belongsTo){
        this.id = id;
        this.name = name;
        this.entityType = entityType;
        this.belongsTo = belongsTo;
    }


    @Override
    public void add() {
        storageManager.add(this);
    }

    @Override
    public void remove() {
        storageManager.remove(this);
    }
}
