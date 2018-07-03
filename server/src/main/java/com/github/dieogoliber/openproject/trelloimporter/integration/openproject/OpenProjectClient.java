package com.github.dieogoliber.openproject.trelloimporter.integration.openproject;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model.Backlog;
import com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model.Link;
import com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model.Project;
import com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model.WorkPackage;
import com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model.WorkPackageType;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.TypeRef;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;

@Component
public class OpenProjectClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OpenProjectClient.class);
	
	static {
		Configuration.setDefaults(new Configuration.Defaults() {

		    private final JsonProvider jsonProvider = new JacksonJsonProvider();
		    private final MappingProvider mappingProvider = new JacksonMappingProvider();
		      
		    @Override
		    public JsonProvider jsonProvider() {
		        return jsonProvider;
		    }

		    @Override
		    public MappingProvider mappingProvider() {
		        return mappingProvider;
		    }
		    
		    @Override
		    public Set<Option> options() {
		        return EnumSet.noneOf(Option.class);
		    }
		});
	}
	
	private RestTemplate restTemplate;
	
	private OpenProjectApiInfo apiInfo;

	@Autowired
	public OpenProjectClient(@Qualifier("openProjectRestTemplate") RestTemplate restTemplate, OpenProjectApiInfo apiInfo) {
		super();
		this.restTemplate = restTemplate;
		this.apiInfo = apiInfo;
	}
	
	public boolean testOpenProjectApi(String token) {
		
		UriComponents components = UriComponentsBuilder.fromUriString(apiInfo.getBaseUrl()).build();
		
		ResponseEntity<?> response = restTemplate.exchange(
			components.toUriString(), HttpMethod.GET, 
			new HttpEntity<Object>(createAuthHeaders(token)), Object.class);
		
		if (response.getStatusCode().equals(HttpStatus.OK)) {
			return true;
		}
		
		return false;
	}
	
	private HttpHeaders createAuthHeaders(String token) {
		
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("Authorization", "Basic " + Base64.getEncoder().encodeToString(("apikey:" + token).getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Internal error... This system does not support UTF-8 encoding: ", e);
		}
		return headers;
	}
	
	public List<Project> getProjects(String token) {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiInfo.getBaseUrl()).path("/projects");
		
		String uri = builder.build().toUriString();

		LOGGER.info("Target URI {}", uri);

		ResponseEntity<String> response = this.restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<Object>(createAuthHeaders(token)),
			String.class);
		
		TypeRef<List<Project>> typeRef = new TypeRef<List<Project>>() {};
		List<Project> projects = JsonPath.parse(response.getBody()).read("$._embedded.elements", typeRef);
		
		return projects;
	}
	
	public List<WorkPackage> getWorkPackagesFromProject(String token, Project project) {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiInfo.getBaseUrl()).path("/projects/{id}/work_packages");

		Map<String, String> params = new HashMap<>();
		params.put("id", project.getId());
		
		String uri = builder.build().expand(params).toUriString();

		LOGGER.info("Target URI {}", uri);

		ResponseEntity<String> response = this.restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<Object>(createAuthHeaders(token)),
			String.class);
		
		TypeRef<List<WorkPackage>> typeRef = new TypeRef<List<WorkPackage>>() {};
		List<WorkPackage> projects = JsonPath.parse(response.getBody()).read("$._embedded.elements", typeRef);
		
		return projects;
	}
	
	public List<Backlog> getBacklogsFromProject(String token, Project project) {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiInfo.getBaseUrl()).path("/projects/{id}/versions");

		Map<String, String> params = new HashMap<>();
		params.put("id", project.getId());
		
		String uri = builder.build().expand(params).toUriString();

		LOGGER.info("Target URI {}", uri);

		ResponseEntity<String> response = this.restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<Object>(createAuthHeaders(token)),
			String.class);
		
		TypeRef<List<Backlog>> typeRef = new TypeRef<List<Backlog>>() {};
		List<Backlog> backlogs = JsonPath.parse(response.getBody()).read("$._embedded.elements", typeRef);
		
		return backlogs;
	}
	
	public List<WorkPackageType> getTypesFromProject(String token, Project project) {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiInfo.getBaseUrl()).path("/projects/{id}/types");

		Map<String, String> params = new HashMap<>();
		params.put("id", project.getId());
		
		String uri = builder.build().expand(params).toUriString();

		LOGGER.info("Target URI {}", uri);

		ResponseEntity<String> response = this.restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<Object>(createAuthHeaders(token)),
			String.class);
		
		TypeRef<List<WorkPackageType>> typeRef = new TypeRef<List<WorkPackageType>>() {};
		List<WorkPackageType> wpTypes = JsonPath.parse(response.getBody()).read("$._embedded.elements", typeRef);
		
		return wpTypes;
	}
	
	public static void main(String[] args) {
		String token = "8769ee8d44e178134706871de5ebccdc33abfcf9a056a291b499fcd139278679";
		System.out.println(token);
		
		OpenProjectApiInfo apiInfo = new OpenProjectApiInfo("http://localhost:8080", "/api/v3");
		
		RestTemplate restTemplate = new RestTemplateBuilder().setConnectTimeout(3000).setReadTimeout(3000).build();
		
		OpenProjectClient client = new OpenProjectClient(restTemplate, apiInfo);
		
		for (Project proj: client.getProjects(token)) {
			System.out.printf("Project (id,name): (%s,%s)\n", proj.getId(), proj.getName());
			for (WorkPackage wp : client.getWorkPackagesFromProject(token, proj)) {
				System.out.printf("WorkPackage: (%d,%d,%s,%s)\n", wp.getId(), wp.getLockVersion(), wp.getSubject(), wp.getDescription().getRaw());
			}
			for (Backlog b : client.getBacklogsFromProject(token, proj)) {
				System.out.printf("Backlog: (%d,%s,%s,%s)\n", b.getId(), b.getName(), b.getDescription().getRaw(), b.getStatus());
				for (Entry<String,Link> links : b.getLinks().getEntries()) {
					Link link = links.getValue();
					System.out.printf("Backlog Link %s: title => %s, href => %s, method => %s\n", links.getKey(), link.getTitle(), link.getHref(), link.getMethod());
				}
			}
			for (WorkPackageType t : client.getTypesFromProject(token, proj)) {
				System.out.printf("Type: (%d,%s,%s)\n", t.getId(), t.getName(), t.getColor());
			}
			for (Entry<String,Link> links : proj.getLinks().getEntries()) {
				Link link = links.getValue();
				System.out.printf("Project Link %s: title => %s, href => %s, method => %s\n", links.getKey(), link.getTitle(), link.getHref(), link.getMethod());
			}
		}
		
	}

	

}
