package spring.framework.eventorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.framework.eventorganizer.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    void deleteById(Long id);
}
