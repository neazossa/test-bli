package com.hackerrank.files.repository;

import com.hackerrank.files.model.XFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface XFileRepository extends JpaRepository<XFile, Long> {

    //don't delete
    List<XFile> findByFileGroup(String fileGroup);

    //don't delete
    Optional<XFile> findByFileGroupAndFileName(String fileGroup, String fileName);
}
