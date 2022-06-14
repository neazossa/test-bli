package com.hackerrank.files.services;

import com.hackerrank.files.model.XFileRequestFileUpload;

public interface XFileServices {

  byte[] getDataFile(String groups);

  void saveDataFile(XFileRequestFileUpload fileGroup);

}