package dev.arpit.ecom.services;

import dev.arpit.ecom.adapters.MapsAdapter;
import dev.arpit.ecom.dtos.ResponseCode;
import dev.arpit.ecom.exceptions.InvalidBatchedDeliveryTaskIdException;
import dev.arpit.ecom.models.BatchedDeliveryTask;
import dev.arpit.ecom.models.Location;
import dev.arpit.ecom.models.DeliveryTask;
import dev.arpit.ecom.repositories.BatchedDeliveryTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BatchedDeliveryTaskService implements IBatchedDeliveryTaskService {
    @Autowired
    private BatchedDeliveryTaskRepository batchedDeliveryTaskRepository;
    @Autowired
    private MapsAdapter mapsAdapter;

    @Transactional
    @Override
    public List<Location> buildRoute(long batchedTaskId) throws InvalidBatchedDeliveryTaskIdException {
        BatchedDeliveryTask batchedDeliveryTask = batchedDeliveryTaskRepository
            .findById(batchedTaskId).
            orElseThrow(() ->
                new InvalidBatchedDeliveryTaskIdException(
                    ResponseCode.ECOM_FAILURE_400,
                    "Batched task not found with id: " + batchedTaskId,
                    "Batched task not found"
                )
            );
        List<Location> locations = batchedDeliveryTask.getTasks().stream().map(DeliveryTask::getDropLocation).toList();
        return mapsAdapter.buildRoute(locations);
    }
}
