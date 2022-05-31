package com.mec.dnaVerifier.dna;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IDnaRepository extends JpaRepository<Dna, UUID> {
    boolean existsBySequence(String sequence);
    Optional<Dna> findBySequence(String sequence);
    long countByIsMalformed(Boolean malformed);
}
