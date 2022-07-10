package com.cdx.coco.client.facade.version;

//TODO Deprecated
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VersionFacadeImplTest {
	
	@Mock
	private VersionService versionService;
	
	@InjectMocks
	private VersionFacade facade = new VersionFacadeImpl();
	
	@Test
	public void getVersion_return_current_version_when_exists() {
		String currentVersion = "0.0.1-SNAPSHOT";
		
		when(versionService.getVersion()).thenReturn(currentVersion);
		
		String version = facade.getVersion();
		assertThat(version, is(currentVersion));
		
		verify(versionService).getVersion();
		verifyNoMoreInteractions(versionService);
	}
	
	@Test
	public void getVersion_return_local_keyword_when_its_local_environment() {
		when(versionService.getVersion()).thenReturn(null);
		
		assertThat(facade.getVersion(), is("local"));
		
		verify(versionService).getVersion();
		verifyNoMoreInteractions(versionService);
	}
}