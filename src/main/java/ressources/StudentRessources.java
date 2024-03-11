package ressources;

import Business.EtudiantBusiness;
import Entities.Etudiant;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("etudiants")
public class StudentRessources {
    public static EtudiantBusiness EM = new EtudiantBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsByStageId(@QueryParam("stageId") int stageId) {
        List<Etudiant> students = EM.getStudentsByStageId(stageId);

        if(EM.getStudentsByStageId(stageId)!=null){
            return Response.status(Response.Status.FOUND).entity(EM.getStudentsByStageId(stageId)).build();
        }else return Response.status(Response.Status.NOT_FOUND).entity("Liste d'étudiants vide !!").build();
    }
}
