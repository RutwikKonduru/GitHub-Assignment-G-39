package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Certificate;
import com.demo.repository.CertificateRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CertificateController {

	@Autowired
	private CertificateRepository certificateRepository;
	
	@GetMapping("/certificates")
	public List<Certificate> getAllCertificates()
	{
		return certificateRepository.findAll();
	}
	
	@PostMapping("/certificates")
	public Certificate addCertificate(@RequestBody Certificate certificate)
	{
		return certificateRepository.save(certificate);
	}
	
	@DeleteMapping("/certificates/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCertificate(@PathVariable Long id){
		Certificate certificate = certificateRepository.findById(id).orElseThrow();
		
		certificateRepository.delete(certificate);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		System.out.Println("Hello, Good Bye!");
	}
	
}
