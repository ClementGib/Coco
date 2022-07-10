package com.cdx.coco.client.facade.courses;

import javax.ws.rs.core.Response;

public class CoursesFacadeImpl implements CoursesFacade{

	@Override
	public Response findAll() {
		return Response.ok().build();
	}

}
