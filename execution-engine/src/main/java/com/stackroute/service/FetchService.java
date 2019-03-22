package com.stackroute.service;

import java.io.IOException;

public interface FetchService {

    public String fetchFilesAndSave() throws IOException, InterruptedException;

    public void setGiturl1(String gitUrl);  public String getGiturl1();

    public void  setUsername(String username);

    public String getUsername();

}
