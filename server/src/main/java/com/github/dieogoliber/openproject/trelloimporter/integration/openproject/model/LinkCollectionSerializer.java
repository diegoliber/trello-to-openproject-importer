package com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model;

import java.io.IOException;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LinkCollectionSerializer extends StdSerializer<LinkCollection>{

	public LinkCollectionSerializer() {
		this(null);
	}
	
	public LinkCollectionSerializer(Class<LinkCollection> t) {
		super(t);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3758411241437712155L;

	@Override
	public void serialize(LinkCollection value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		
		gen.writeStartObject();
		for(Entry<String,Link> entry : value.getEntries()) {
			gen.writeObjectField(entry.getKey(), entry.getValue());
		}
		gen.writeEndObject();
		
	}

}
