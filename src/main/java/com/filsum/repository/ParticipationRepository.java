package com.filsum.repository;

import com.filsum.model.Participation;
import com.filsum.model.Run;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {

    List<Participation> findByRun(Run run);

    List<Participation> findByRunInOrderByParticipationId(Collection<Run> runs);

    List<Participation> findByRunInAndPaid(Collection<Run> runs, boolean paid);

    List<Participation> findByRuntimeIsNotNull();

    List<Participation> findByRuntimeIsNotNullAndRun(Run run);
}
