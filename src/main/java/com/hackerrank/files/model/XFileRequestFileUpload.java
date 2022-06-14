package com.hackerrank.files.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class XFileRequestFileUpload{
  private Long id;
  private String fileGroup;
  private String fileName;
  private byte[] files;
}