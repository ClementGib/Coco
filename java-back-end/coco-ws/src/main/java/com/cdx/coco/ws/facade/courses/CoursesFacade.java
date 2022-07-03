package com.cdx.coco.ws.facade.courses;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tags;

@Tags
@Path("courses")
public interface CoursesFacade {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(summary = "Get all courses",
			description = "REST Endpoint that returns all courses")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200",description = "Provides entry names and weights matching query parameters as properties in a json",
		                 content = @Content(schema = @Schema(implementation = Map.class))),
		    @ApiResponse(responseCode = "400", description = "One of the query parameters has a bad value"),
		    @ApiResponse(responseCode = "500", description = "")
		})
	Response findAll();
}
