package com.cdx.coco.ws.facade.version;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
public class VersionFacadeImpl implements VersionFacade{

	@Inject
	private VersionService versionService;
	
	@Context
	private SecurityContext security;
	
	@Override
	public String getVersion() {
		final String version = versionService.getVersion();
		return version == null ? "local" : version;
	}
}