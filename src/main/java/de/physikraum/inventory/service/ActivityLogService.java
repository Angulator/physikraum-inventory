package de.physikraum.inventory.service;

import de.physikraum.inventory.entity.ActivityLog;
import de.physikraum.inventory.repository.ActivityLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogService {
    private final ActivityLogRepository repository;
    public ActivityLogService(ActivityLogRepository repository) { this.repository = repository; }
    public List<ActivityLog> findAll() { return repository.findAll(); }
    public ActivityLog save(ActivityLog log) { return repository.save(log); }
}
