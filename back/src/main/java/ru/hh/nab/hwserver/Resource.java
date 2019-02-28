package ru.hh.nab.hwserver;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import ru.hh.nab.hwserver.storage.Storage;
import ru.hh.nab.hwserver.storage.DTO;


@Path("/")
public class Resource {

    private Storage storage = new Storage();

    /* добавление нового элемента */
    @POST
    @Path("/new")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response addNewItem(String request) {
        Gson requestData = new Gson();
        ToDoItem toDo = requestData.fromJson(request, ToDoItem.class);
        DTO newItem = new DTO(Integer.parseInt(toDo.getId()));
        newItem.setText(toDo.getText());
        newItem.setDone(toDo.getDone());
        this.storage.addItem(Integer.toString(newItem.getId()), newItem);
        return Response.status(Response.Status.OK).build();
    }

    /* удаление элемента по id */
    @GET
    @Path("/remove")
    public Response removeItem(@QueryParam("id") int id) {
        storage.removeItem(Integer.toString(id));
        return Response.status(Response.Status.OK).build();
    }

    /* редактирование статуса элемента (готовность done) */
    @GET
    @Path("/switch")
    public Response switchItem(@QueryParam("id") int id) {
        DTO item = storage.getItem(Integer.toString(id));
        if (item.getDone()) {item.setDone("false");}
        else {item.setDone("true");}
        return Response.status(Response.Status.OK).build();
    }

}
