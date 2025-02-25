package com.noel.service;

import com.noel.model.Status;
import com.noel.model.Vehicle;
import com.noel.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
