package com.dante.struts2.file;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

public class FileUpload  extends ActionSupport{
	private String destPath;
	private File myfile;
	private String myFileFileName="testF.png";
	private String myFileContentType;
	@Override
	public String execute() throws Exception {
		destPath="E:/test/struts";
		System.out.println("------myfile----:"+myfile);
		System.out.println("-------myFileFileName----:"+myFileFileName);
		
		File destFile=new File(destPath,myFileFileName);
		FileUtils.copyFile(myfile, destFile);
		return SUCCESS;
	}
	public String getDestPath() {
		return destPath;
	}
	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
	public File getMyfile() {
		return myfile;
	}
	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

}
