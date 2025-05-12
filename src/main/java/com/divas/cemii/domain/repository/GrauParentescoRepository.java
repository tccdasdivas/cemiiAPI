package com.divas.cemii.domain.repository;

import com.divas.cemii.domain.model.GrauParentesco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrauParentescoRepository extends JpaRepository<GrauParentesco, Long> {
}
