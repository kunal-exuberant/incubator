package likedriving.Glimpse.Resources;

import likedriving.Glimpse.DataStore.DataStore;
import likedriving.Glimpse.RequestModel;
import likedriving.Glimpse.models.Listing;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/destinations")
public class DestinationResource {

    DataStore dataStore;

    public DestinationResource(DataStore dataStore){
        this.dataStore = dataStore;
    }

    @GET
    public List<Listing>getDestinations(@Valid RequestModel requestModel){
        //dataStore.fetchResults(requestModel.getActivities());
        return new ArrayList<Listing>();
    }


}
