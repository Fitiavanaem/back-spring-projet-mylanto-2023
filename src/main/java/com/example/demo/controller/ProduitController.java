package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Produit;
import com.example.demo.repository.ProduitRepository;

@CrossOrigin(origins =("http://localhost:19006"))
@RestController
@RequestMapping("/api/")
public class ProduitController {
	
	@Autowired
	private ProduitRepository produitrepository;

	@GetMapping("/produits")
	public List<Produit> getAllProducts(){
		
		return produitrepository.findAll();
	}
	@PostMapping("/produits")
	public Produit createEmployee(@RequestBody Produit produit) {
		return produitrepository.save(produit);
	}
			
	@GetMapping("/produit/{numProduit}")
	public ResponseEntity<Produit> getEmployeeById(@PathVariable String numProduit) {
			
		Produit produit=produitrepository.findById(numProduit)
		.orElseThrow(()-> new ResourceNotFoundException("Id introuvable:"+ numProduit));		
		return ResponseEntity.ok(produit);
	}
		
	@PutMapping("/produit/{numProduit}")
	public ResponseEntity<Produit> updateProduits(@PathVariable String numProduit, @RequestBody Produit produitDetails){

		Produit produit=produitrepository.findById(numProduit)
				.orElseThrow(()-> new ResourceNotFoundException("Id introuvable:"+ numProduit));
			
		produit.setDesign(produitDetails.getDesign());
		produit.setPrix(produitDetails.getPrix());
		produit.setQuantite(produitDetails.getQuantite());
			
		Produit updateProduit = produitrepository.save(produit);
		return ResponseEntity.ok(updateProduit);
	}
		
	@DeleteMapping("/produit/{numProduit}")
	public ResponseEntity<Map<String, Boolean>> deleteProduit(@PathVariable String numProduit){
			
		Produit produit=produitrepository.findById(numProduit)
				.orElseThrow(()-> new ResourceNotFoundException("Id introuvable:"+ numProduit));
			
		produitrepository.delete(produit);
		Map<String, Boolean> response= new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
