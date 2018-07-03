package com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LinkCollectionDeserializer extends StdDeserializer<LinkCollection>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7245270256662713987L;
	
	public LinkCollectionDeserializer() {
		this(null);
	}
	
	public LinkCollectionDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public LinkCollection deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		LinkCollection linkCol = new LinkCollection();
		JsonNode node = p.getCodec().readTree(p);
		
		ObjectMapper mapper = new ObjectMapper();
		
		for (Iterator<String> fieldIter = node.fieldNames(); fieldIter.hasNext();) {
			String field = fieldIter.next();
			JsonNode childNode = node.get(field);
			if (!childNode.isArray()) {
				Link link = mapper.treeToValue(childNode, Link.class);
				linkCol.setLink(field, link);
			}
			
		}
		
		return linkCol;
	}

}
