package com.Backend.CampusOrdering.repository;

import com.Backend.CampusOrdering.model.Credential;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CredentialInterface extends JpaRepository<Credential, Integer > {
    Credential getByStudentnum(String studentnum);
    boolean existsByStudentnum(String studentnum);
}
