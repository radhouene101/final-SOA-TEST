package ressources;


import Business.EtudiantBusiness;
import Business.StageBusiness;
import Entities.Etudiant;
import Entities.Stage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("stages")
public class StageRessources {
    private static StageBusiness SB = new StageBusiness();
    public static EtudiantBusiness EtudiantMetier = new EtudiantBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentStage(){
        if(SB.getAllStages().size() != 0){
            return Response.status(Response.Status.OK).entity(SB.getAllStages()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("La liste est vide").build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void ajoutstage(Stage S){
       try {
           SB.addStage(S);
       }
       catch (Exception e){
           System.out.println("errrrrrr"+ e.getMessage());
       }
    }
    @Path("{id}")
    @DELETE
    public  void rmSTG(@PathParam(value = "id") int id){
        try {
            SB.deleteStage(id);
        }
        catch (Exception e){
            System.out.println("error in rù stage" + e.getMessage());
        }
    }
    //@Path("update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateRdv(Stage S){
        try {
            SB.updateStage(S);
        }catch (Exception e){
            System.out.println("error in update" + e.getMessage());
        }

    }
   /* @GET
    @Path("/etudiants")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsByStageId(@QueryParam("stageId") int stageId) {
        List<Etudiant> students = SB.getStudentsForStage(stageId);

        if (students != null && !students.isEmpty()) {
            return Response.status(Response.Status.OK).entity(students).build();
        } else {
            // Handle empty list scenario gracefully
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Aucun étudiant trouvé pour le stage d'identifiant " + stageId)
                    .build();
        }
    }*/
}
