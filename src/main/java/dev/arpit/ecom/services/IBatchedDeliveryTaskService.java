package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.InvalidBatchedDeliveryTaskIdException;
import dev.arpit.ecom.models.Location;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBatchedDeliveryTaskService {
  List<Location> buildRoute(long batchedTaskId) throws InvalidBatchedDeliveryTaskIdException;
}
