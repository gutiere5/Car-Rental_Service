package com.noel.service;

import com.noel.model.Status;
import com.noel.model.Vehicle;
import com.noel.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VehicleServiceImp implements VehicleService {

  private final VehicleRepository vehicleRepository;

  @Override
  public Vehicle create(Vehicle vehicle) {
    vehicle.setId(UUID.randomUUID().toString());
      vehicle.setStatus(Status.AVAILABLE);
      vehicle.setOwner(null);
      vehicle.setAssociatedDate(null);
      return vehicleRepository.save(vehicle);
  }

  @Override
  public List<Vehicle> getAllVehicles() {
    return (List<Vehicle>) vehicleRepository.findAll();
  }

  @Override
  public Vehicle findById(String vehicleId) {
    return vehicleRepository.findById(vehicleId).orElseThrow();
  }

  @Override
  public void associate(String vehicleId, String userId) {
    var vehicle = vehicleRepository.findById(vehicleId)
            .filter(v -> v.getStatus() == Status.AVAILABLE)
            .orElseThrow();

    //Update parameters of the vehicle
    vehicle.setStatus(Status.ASSOCIATED);
    vehicle.setAssociatedDate(new Date());
    vehicle.setOwner(userId);

    //We update the vehicle entity
    vehicleRepository.save(vehicle);
  }
}
