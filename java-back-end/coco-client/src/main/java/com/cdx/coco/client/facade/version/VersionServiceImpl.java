package com.cdx.coco.client.facade.version;

import javax.ejb.Stateless;

@Stateless
public class VersionServiceImpl implements VersionService{

	@Override
	public String getVersion() {
		return this.getClass().getPackage().getImplementationVersion();
	}

}