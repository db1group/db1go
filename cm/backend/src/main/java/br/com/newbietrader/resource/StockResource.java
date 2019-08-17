package br.com.newbietrader.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import br.com.newbietrader.dto.StockDTO;
import br.com.newbietrader.service.StockService;
import org.bson.types.ObjectId;


@Path("/stocks")
@Produces(MediaType.APPLICATION_JSON)
public class StockResource {

    @Inject
    private StockService stockService;

    @GET
    public List<StockDTO> findAll() {
        return stockService.findAll();
    }

    @POST
    public void save(StockDTO dto) {
        stockService.save(dto);
    }

    @GET
    @Path("/{id}")
    public StockDTO findOne(@PathParam("id") String id) {
        return stockService.findOne(new ObjectId(id));
    }

    @PUT
    @Path("/{id}")
    public void put(@PathParam("id") String id, StockDTO dto) {
        stockService.update(new ObjectId(id), dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        stockService.devele(new ObjectId(id));
    }

}
