package dev.arpit.ecom.services;

import dev.arpit.ecom.models.DeliveryTask;
import dev.arpit.ecom.repositories.DeliveryTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryTaskService implements IDeliveryTaskService {
  @Autowired
  private DeliveryTaskRepository deliveryTaskRepository;

  @Override
  public List<DeliveryTask> findAllById(List<Long> taskIds) {
    return deliveryTaskRepository.findAllById(taskIds);
  }
}
