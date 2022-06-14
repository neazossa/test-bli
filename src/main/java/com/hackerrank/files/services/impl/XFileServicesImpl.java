package com.hackerrank.files.services.impl;

import java.util.List;
import java.util.Optional;

import com.hackerrank.files.model.XFile;
import com.hackerrank.files.model.XFileRequestFileUpload;
import com.hackerrank.files.repository.XFileRepository;
import com.hackerrank.files.services.XFileServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XFileServicesImpl implements XFileServices {

  int BufferSize = 1024;

  @Autowired
  private XFileRepository repository;

  @Override
  public byte[] getDataFile(String groups){
    List<XFile> data = repository.findByFileGroup(groups);
    byte[] resp = new byte[BufferSize];
    for (XFile file : data) {
      resp = file.getFile();
    }
    return resp;
  }

  @Override
  public void saveDataFile(XFileRequestFileUpload fileGroup){
    Optional<XFile> data = repository.findByFileGroupAndFileName(fileGroup.getFileGroup(), fileGroup.getFileName());
    if(data.isPresent()){
      repository.save(transform(data.get().getId(), fileGroup));
    }
    repository.save(transform(null, fileGroup));
  }

  protected XFile transform(Long currentId, XFileRequestFileUpload request){
    return XFile.builder()
                .fileGroup(request.getFileGroup())
                .fileName(request.getFileName())
                .file(request.getFiles())
                .id(currentId)
                .build();
  }

}