package dev.arpit.ecom.services;

import dev.arpit.ecom.models.DeliveryTask;

import java.util.List;

public interface IDeliveryTaskService {
  List<DeliveryTask> findAllById(List<Long> taskIds);
}
