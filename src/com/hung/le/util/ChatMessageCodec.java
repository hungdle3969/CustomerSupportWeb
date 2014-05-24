/**
 * 
 */
package com.hung.le.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hung.le.pojo.ChatMessage;

/**
 * @author admin
 * This class is a utility class used to encode and decode ChatMessages. The WebSocket API needs both these 
 * encoder and decoder so that the chat application can send and receive messages. It uses the Jackson Data
 * Processor to encode and decode the messages.
 */
public class ChatMessageCodec implements Encoder.BinaryStream<ChatMessage>, Decoder.BinaryStream<ChatMessage>{

	private static final Logger log = LogManager.getLogger();
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	static {
		MAPPER.findAndRegisterModules();
		MAPPER.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig endpointConfig) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * given an InputStream, it reads and deserializes the JSON ChatMessage
	 */
	@Override
	public ChatMessage decode(InputStream inputStream) throws DecodeException,
			IOException {
		try{
			return ChatMessageCodec.MAPPER.readValue(inputStream, ChatMessage.class);
		}
		catch(JsonParseException | JsonMappingException e){
			throw new DecodeException((ByteBuffer)null, e.getMessage(), e);
		}
		finally{
			log.exit();
		}
	}

	/*
	 * It takes a ChatMessage and an OutputStream, encodes the message by converting it
	 * to JSON, and writes it to the OutputStream
	 */
	@Override
	public void encode(ChatMessage chatMessage, OutputStream outputStream)
			throws EncodeException, IOException {

		log.entry();
		try{
			ChatMessageCodec.MAPPER.writeValue(outputStream, ChatMessage.class);
		}
		catch(JsonParseException | JsonMappingException e){
			throw new EncodeException((ByteBuffer)null, e.getMessage(), e);
		}
		finally{
			log.exit();
		}
	}

	

}
