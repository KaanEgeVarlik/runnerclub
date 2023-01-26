package com.project.runnerclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.runnerclub.entities.Route;
import com.project.runnerclub.repo.RouteRepo;

@Service
public class RouteService {

private RouteRepo routeRepo;
	
	public RouteService(RouteRepo routeRepo) {
		this.routeRepo = routeRepo;
	}

	public List<Route> getAllRoutes() {
		return routeRepo.findAll();
	}

	public Route saveOneRoute(Route newRoute) {
		return routeRepo.save(newRoute);
	}

	public Route updateOneRoute(Long routeId, Route newRoute) {
		Optional<Route> route = routeRepo.findById(routeId);
		if(route.isPresent()) {
			Route foundRoute = route.get();
			foundRoute.setStartingLocation(newRoute.getStartingLocation());
			foundRoute.setDestination(newRoute.getDestination());
			foundRoute.setHour(newRoute.getHour());
			foundRoute.setNumberOfVehicles(newRoute.getNumberOfVehicles());
			routeRepo.save(foundRoute);
			return foundRoute;
		} else {
			return null;
		}
	}

	public void deleteById(Long routeId) {
		routeRepo.deleteById(routeId);
	}
}
