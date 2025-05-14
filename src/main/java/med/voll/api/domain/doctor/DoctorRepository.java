package med.voll.api.domain.doctor;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByIsActiveTrue(Pageable pageable);

    @Query("""
        SELECT d FROM Doctor d
        WHERE d.specialty = :specialty
        AND d.isActive = true
        AND d.id NOT IN (
            SELECT c.doctor.id FROM Consultation c
            WHERE c.date = :localDateTime
        )
        ORDER BY FUNCTION('RAND')
        LIMIT 1
        """)
    Doctor chooseDoctor(Specialty specialty, @NotNull @Future LocalDateTime localDateTime);

    @Query("""
        SELECT d.isActive FROM Doctor d
        WHERE d.id = :doctorId
        """)
    boolean findIsActiveById(Long doctorId);
}
