package com.github.furistao.covid19.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.furistao.covid19.exception.ResourceNotFoundException;
import com.github.furistao.covid19.model.Covid19Case;
import com.github.furistao.covid19.repository.Covid19CaseRepository;

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

import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
@Api(tags = "症例情報")
public class Covid19CaseController {

	@Autowired
	private Covid19CaseRepository caseRepository;

	// get all cases
	@GetMapping("/cases")
	public List<Covid19Case> getAllCase() {
		return caseRepository.findAll();
	}

	// get max id of cases
	@GetMapping("/cases/maxid")
	public Covid19Case getMaxIdCase() {
		return caseRepository.getMaxIdCase();
	}

	// create cases rest api
	@PostMapping("/cases")
	public Covid19Case createCase(@RequestBody Covid19Case aCase) {
		return caseRepository.save(aCase);
	}

	// get case by id rest api
	@GetMapping("/cases/{id}")
	public ResponseEntity<Covid19Case> getCaseById(@PathVariable Long id) {
		Covid19Case aCase = caseRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Case not exist with id :" + id));
		return ResponseEntity.ok(aCase);
	}

	// update case rest api
	@PutMapping("/cases/{id}")
	public ResponseEntity<Covid19Case> updateCase(@PathVariable Long id,
			@RequestBody Covid19Case caseDetails) {

		Covid19Case aCase = caseRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Case not exist with id :" + id));
				aCase.setId(caseDetails.getId());

		Covid19Case updatedCase = caseRepository.save(aCase);
		return ResponseEntity.ok(updatedCase);
	}

	// delete cases rest api
	@DeleteMapping("/cases/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCase(@PathVariable Long id) {
		Covid19Case aCase = caseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Temperature not exist with id :" + id));

		caseRepository.delete(aCase);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	// get temperatures during the days
	@GetMapping("/case/updated/from/{strFrom}/to/{srtTo}")
	// http://localhost:8080/api/v1/temperatures/date/from/2020-09-03/to/2020-09-30
	public List<Covid19Case> getCaseByUpdatedBetween(@PathVariable String strFrom, @PathVariable String srtTo) {

		return caseRepository.findByUpdatedAtBetween(strFrom, srtTo);
	}
}
