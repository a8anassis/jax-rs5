package gr.aueb.cf.jaxpro.rest;

import gr.aueb.cf.jaxpro.dto.TeacherInsertDTO;
import gr.aueb.cf.jaxpro.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.jaxpro.model.Teacher;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import javax.swing.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/hello")
public class HelloRestController {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @GET
    @Path("/say-hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return "Hello Coding Factory!!";
    }

    @GET
    @Path("/get-hello-res")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHelloRes() {
        //return Response.ok("Hello Coding Factory again!!!!").build();
        return Response
                .status(Response.Status.OK)
                .entity("Hello World!!")
                .build();
    }

    @GET
    @Path("/get-teacher")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeacher() {
        Teacher teacher = new Teacher(1L, "SSN123", "Athana", "Androutsos");
        TeacherReadOnlyDTO readOnlyDTO = teacher.toReadOnlyDTO();
        return Response.status(Response.Status.OK).entity(readOnlyDTO).build();
    }

    @GET
    @Path("/teachers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeachers(@QueryParam("lastname") String lastname) {
        List<Teacher> teacherList = List.of();
//                new Teacher(1L, "SSN123", "Athana", "Androutsos"),
//                new Teacher(2L, "SSN234", "Nick", "Androutsos"));

        if (teacherList.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Teacher not Found").build();
        }

        List<TeacherReadOnlyDTO> teacherReadOnlyDTOS = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            teacherReadOnlyDTOS.add(teacher.toReadOnlyDTO());
        }

        return Response.status(Response.Status.OK).entity(teacherReadOnlyDTOS).build();
    }


    @POST
    @Path("/teachers")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTeacher(TeacherInsertDTO dto, @Context UriInfo uriInfo) {
        Set<ConstraintViolation<TeacherInsertDTO>> violations = validator.validate(dto);

        if (!violations.isEmpty()) {
            List<String> errors = new ArrayList<>();

            for (ConstraintViolation<TeacherInsertDTO> violation : violations) {
                errors.add(violation.getMessage());
            }

            return  Response.status(Response.Status.BAD_REQUEST).entity(errors).build();
        }

        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        URI uri = uriBuilder.path("10").build();
    return Response.status(Response.Status.OK).location(uri).build();
    }

}
