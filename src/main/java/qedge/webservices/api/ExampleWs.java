package qedge.webservices.api;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import qedge.services.configuration.ConfigurationService;
import qedge.webservices.api.beans.Test;

@Path("/example")
@Api("Manage exemple web-services")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class ExampleWs {

	private final ConfigurationService configurationService;
	
	@Inject
	public ExampleWs(ConfigurationService configurationService) {
		this.configurationService = configurationService;
	}

	@GET
	@Path("/test/{name}")
	@ApiOperation("Example web-service")
	public Test test(@ApiParam(required = true) @PathParam("name") String name) {
		return new Test("hello " + name + "\n" + configurationService.hello());
	}
	
}
