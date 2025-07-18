package com.noel.service;

import com.noel.model.Vehicle;

import java.util.List;

public interface VehicleService {

  Vehicle create(Vehicle vehicle);

  List<Vehicle> getAllVehicles();

  Vehicle findById(String vehicleId);

  void associate(String vehicleId, String userId);

  void removeAssociation(String vehicleId, String userId);
}
