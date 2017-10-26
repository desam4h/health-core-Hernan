package co.zero.health.persistence;

import co.zero.health.model.Survey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends PagingAndSortingRepository<Survey, Long> {
    @Query("SELECT s FROM Survey s WHERE s.patient.id = :patientId ORDER BY s.id ASC")
    List<Survey> findAllByPatientId(@Param("patientId") Long patientId);
    void deleteAllByEventId(Long eventId);
    void deleteAllByPatientId(Long patientId);
}