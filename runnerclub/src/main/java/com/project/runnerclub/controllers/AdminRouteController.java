package com.project.runnerclub.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.runnerclub.entities.Route;
import com.project.runnerclub.repo.RouteRepo;
import com.project.runnerclub.services.RouteService;

@RestController
@RequestMapping("/adminroutes")
public class AdminRouteController {

	private RouteService routeService;
	
	public AdminRouteController(RouteRepo routeRepo) {
		this.routeService = (RouteService) routeRepo;
	}
	
	@GetMapping
	public List<Route> getAllRoutes(){
		return routeService.getAllRoutes();
	}
	
	@PostMapping
	public Route createRoute(Route newRoute) {
		return routeService.saveOneRoute(newRoute);
	}
	
	@PutMapping("/{routeId}")
	public Route updateOneRoute(@PathVariable Long routeId , Route newRoute) {
		return routeService.updateOneRoute(routeId, newRoute);
	}
	
	@DeleteMapping("/{routeId}")
	public void deleteOneRoute(@PathVariable Long routeId) {
		routeService.deleteById(routeId);
	}
	
}
