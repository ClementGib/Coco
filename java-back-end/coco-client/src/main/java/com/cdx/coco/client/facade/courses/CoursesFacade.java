package com.cdx.coco.client.facade.courses;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tags;

@Tags
@Path("courses")
public interface CoursesFacade {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all courses without the details",
            description = "REST Endpoint that returns all courses without the course content")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "All the courses found without their content",
                         content = @Content(mediaType = MediaType.APPLICATION_JSON,
                         array = @ArraySchema(schema = @Schema(implementation = CoursePreviewDTO.class))))
        })
    Response findAll();
    
    
//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Operation(summary = "Get specific course",
//            description = "REST Endpoint that returns course from id")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200",description = "Course found from the id",
//                         content = @Content(schema = @Schema(implementation = Map.class))),
//            @ApiResponse(responseCode = "400", description = "Id does not match to any course"),
//        })
//    Response find();
}
