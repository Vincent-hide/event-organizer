package spring.framework.eventorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.framework.eventorganizer.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    void deleteById(Long id);
}
