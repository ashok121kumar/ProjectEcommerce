package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseTest;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseTest{
	
public static void generateJvmReport(String jsonFile){
		
		File file=new File(getProjectLoc()+"\\target");
		
		Configuration configuration=new Configuration(file,"Adactin Hotel");
		configuration.addClassifications("os", "WINDOW 10");
		configuration.addClassifications("Browser", "Edge");
		configuration.addClassifications("Browser Version", "104");
		configuration.addClassifications("Sprint", "35");
		
		List<String> jsonFiles=new ArrayList<String>();
		jsonFiles.add(jsonFile);
		
		ReportBuilder builder=new ReportBuilder(jsonFiles,configuration);
		
		builder.generateReports();
		
		
	}

}
