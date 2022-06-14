package com.hackerrank.files.controller;

import com.hackerrank.files.model.RestResponse;
import com.hackerrank.files.model.XFileRequestFileDownload;
import com.hackerrank.files.model.XFileRequestFileUpload;
import com.hackerrank.files.services.XFileServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RequestController {
    //define endpoints for download and upload

  @Autowired
  private XFileServices services;  

  @GetMapping("/uploader")
  public ResponseEntity<RestResponse> getFileUpload(@RequestBody XFileRequestFileUpload request){
    services.saveDataFile(request);
    return new ResponseEntity(RestResponse.builder().message("file successfully upload").build(), HttpStatus.CREATED);
  }

  @GetMapping("/downloader")
  public ResponseEntity<byte[]> getFileUpload(@RequestBody XFileRequestFileDownload request){
    return ResponseEntity.ok(services.getDataFile(request.getFileGroup()));
  }
    
}
