package com.divas.cemii.domain.repository;

import com.divas.cemii.domain.model.Idoso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdosoRepository extends JpaRepository<Idoso, Long> {
}
