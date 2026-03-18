package dev.arpit.ecom.services;

import dev.arpit.ecom.models.Location;
import dev.arpit.ecom.models.DeliveryPartner;
import dev.arpit.ecom.models.DeliveryPartnerTaskMapping;
import dev.arpit.ecom.models.DeliveryTask;
import dev.arpit.ecom.utils.DistanceUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeliveryPartnerTaskMappingService implements IDeliveryPartnerTaskMappingService {

    @Autowired
    private IDeliveryPartnerService iDeliveryPartnerService;
    @Autowired
    private IDeliveryTaskService iDeliveryTaskService;

    @Override
    public List<DeliveryPartnerTaskMapping> matchPartnersAndTasks(List<Long> partnerIds, List<Long> taskIds) {
        List<DeliveryPartner> partners = iDeliveryPartnerService.findAllById(partnerIds);
        List<DeliveryTask> tasks = iDeliveryTaskService.findAllById(taskIds);

        List<PairCandidate> candidates = new ArrayList<>();
        for(DeliveryPartner partner : partners) {
            Location partnerLocation = partner.getCurrentLocation();

            for(DeliveryTask task : tasks) {
                Location taskLocation = task.getPickupLocation();
                double distance = DistanceUtils.calculateDistance(partnerLocation, taskLocation);
                candidates.add(new PairCandidate(partner, task, distance));
            }
        }

        candidates.sort(Comparator.comparingDouble(PairCandidate::getDistance));

        // Greedy assignment
        Set<Long> assignedPartnerIds = new HashSet<>();
        Set<Long> assignedTaskIds = new HashSet<>();
        List<DeliveryPartnerTaskMapping> mappings = new ArrayList<>();

        for (PairCandidate candidate : candidates) {
            Long partnerId = candidate.getPartner().getId();
            Long taskId = candidate.getTask().getId();

            if (assignedPartnerIds.contains(partnerId) || assignedTaskIds.contains(taskId)) {
                continue;
            }

            DeliveryPartnerTaskMapping mapping = new DeliveryPartnerTaskMapping();
            mapping.setPartner(candidate.getPartner());
            mapping.setTask(candidate.getTask());
            mappings.add(mapping);
            assignedPartnerIds.add(partnerId);
            assignedTaskIds.add(taskId);

            // Stop if we cannot match more
            if (assignedPartnerIds.size() == partners.size() || assignedTaskIds.size() == tasks.size()) {
                break;
            }
        }

        return mappings;
    }

    @Getter
    @Setter
    private static class PairCandidate {
        private final DeliveryPartner partner;
        private final DeliveryTask task;
        private final double distance;

        PairCandidate(DeliveryPartner partner, DeliveryTask task, double distance) {
            this.partner = partner;
            this.task = task;
            this.distance = distance;
        }
    }
}
