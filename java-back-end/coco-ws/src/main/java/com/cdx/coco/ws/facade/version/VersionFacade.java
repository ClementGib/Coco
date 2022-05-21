package com.cdx.coco.ws.facade.version;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tags;


@Path("/version")
@Tags
public interface VersionFacade {
    @GET
    @Produces(TEXT_PLAIN)
    @Operation(summary = "Coco application version", 
    responses = {
    		@ApiResponse(responseCode = "200",
    				description = "Version number",
    				content = @Content(mediaType = TEXT_PLAIN, schema = @Schema(implementation = String.class)))})
    String getVersion();
}