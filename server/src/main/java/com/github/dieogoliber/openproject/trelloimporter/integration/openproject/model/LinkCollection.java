package com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = LinkCollectionDeserializer.class)
@JsonSerialize(using = LinkCollectionSerializer.class)
public class LinkCollection {
	
	private Map<String,Link> links = new HashMap<>();
	
	public LinkCollection() {}
	
	public Link getLink(String name) {
		return links.get(name);
	}
	
	public Link setLink(String name, Link link) {
		return links.put(name, link);
	}

	public Set<Entry<String, Link>> getEntries() {
		return links.entrySet();
	}
	
	public Link getSelfLink() {
		return links.get("self");
	}
	

}
