package com.ram.controller;

//import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ram.exception.LobNotfoundException;
import com.ram.model.Lob;
import com.ram.response.ResponseData;
import com.ram.service.LobService;

@RestController
public class LobServiceController
{
	@Autowired
	private LobService lobService;
	
	@RequestMapping(value = "/lobs", method = RequestMethod.POST)
	public ResponseEntity<Object> createLob(@Valid @RequestBody Lob lob)
	{
		try {
				lob = lobService.createLob(lob);
				return ResponseData.generateResponse("Lob is created successfully with Psaf_sys_id = " + lob.getPsaf_sys_id(),HttpStatus.CREATED);
		
			}catch(Exception e) {
			
				return ResponseData.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS);
		}
		
		
	}

	@RequestMapping(value = "/lobs", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateLob(@RequestBody Lob lob)
	{
		lob = lobService.updateLob(lob);
		try{
			lobService.updateLob(lob);
			return ResponseData.generateResponse("Lob is updated successsfully= " + lob.getPsaf_sys_id(), HttpStatus.OK);
		}catch(Exception e){
			throw new LobNotfoundException("Not found Lob");
		}

	}

//	@RequestMapping(value = "/lobs/{psaf_sys_id}", method = RequestMethod.GET)
//	public ResponseEntity<Object> getLob(@PathVariable("psaf_sys_id") int psaf_sys_id)
//	{
//		boolean isLobExist = lobService.isLobExist(psaf_sys_id);
//		if (isLobExist)
//		{
//			Lob lob = lobService.getLob(psaf_sys_id);
//			return ResponseData.generateResponse("Successfully retrieved Data!", HttpStatus.OK,lob);
//		}
//		else
//		{
//			throw new LobNotfoundException("Not found Lob with Psaf_sys_id = " + psaf_sys_id);
//		}
//
//	}
//
//	@RequestMapping(value = "/lobs", method = RequestMethod.GET)
//	public ResponseEntity<Object> getLobs()
//	{
//		try {	
//				List<Lob> lobList = lobService.getLobs();
//				return ResponseData.generateResponse("Successfully retrieved Data!", HttpStatus.OK,lobList);
//		
//			}catch(Exception e)
//			{
//				return  ResponseData.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
//			}
//	}
//	
//
//	@RequestMapping(value = "/lobs/{psaf_sys_id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Object> deleteLob(@PathVariable("psaf_sys_id") int psaf_sys_id)
//	{
//		boolean isLobExist = lobService.isLobExist(psaf_sys_id);
//		if (isLobExist)
//		{
//			lobService.deleteLob(psaf_sys_id);
//			return  ResponseData.generateResponse("Lob is deleted successsfully", HttpStatus.OK,isLobExist);
//		}
//		else
//		{
//			throw new LobNotfoundException("Not found Lob with Psaf_sys_id = " + psaf_sys_id);
//		}
//
//	}

}
