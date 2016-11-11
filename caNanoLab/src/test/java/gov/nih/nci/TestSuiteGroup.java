package gov.nih.nci;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.internal.seleniumemulation.Click;

import gov.nih.nci.HelperMethods.BaseTestMethods;
import gov.nih.nci.HelperMethods.BaseNanoLabMethods;

import org.junit.*;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;

import static gov.nih.nci.HelperMethods.TestConstants.*;

public class TestSuiteGroup
{
	private static Logger logger=Logger.getLogger("TestSuite");
	
	static BaseNanoLabMethods Test = new BaseNanoLabMethods();

	//S.N.: 256
	//Test Name: 001_Ensure Only Curator user able to Add a groups to the collaboration Groups
	@Test
	public void EnsureOnlyCuratorUserAbleToAddAGroupsToTheCollaborationGroups() throws Exception {
		String testName = "001_Ensure Only Curator user able to Add a groups to the collaboration Groups";
		String testDesc = "Ensure only curator user able to create a collaboration groups and add to the manage community"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLinkNotPresentOnThePage(By.linkText("GROUPS"));
			Test.logout();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLinkOnThePage(By.linkText("GROUPS"));
			Test.navigate_to_groups_page();
			Test.navigate_to_manage_collaboration_groups_page();
			Test.add_new_collaboration_group("Add", "", "", "Add", "", "Submit");
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 257
	//Test Name: 002_Ensure user should be able to submit a protocol and associate a collaboration group
	@Test
	public void EnsureUserShouldBeAbleToSubmitAProtocolAndAssociateACollaborationGroup() throws Exception {
		String testName = "002_Ensure user should be able to submit a protocol and associate a collaboration group";
		String testDesc = "Ensure user should be able to submit a protocol and associate a collaboration group"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLinkOnThePage(By.linkText("GROUPS"));
			Test.navigate_to_groups_page();
			Test.navigate_to_manage_collaboration_groups_page();
			Test.add_new_collaboration_group("Add", "", "", "Add", "", "Submit");
			Test.goHome();
			Test.submit_a_New_Protocols(
				 "AsynthesisB", 
				 "Test Submit Protocol As Curator ", 
				 "Test Protocol Abbreviation", 
				 "Test Protocol Version 1", 
				 "external1", 
				 "http://www.test.com", 
				 "Test File Title", 
				 "Test Description", 
				 "", 
				 "collaboration");			
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 258
	//Test Name: 003_Ensure user should be able to submit a publication and associate a collaboration group
	@Test
	public void EnsureUserShouldBeAbleToSubmitAPublicationAndAssociateACollaborationGroup() throws Exception {
		String testName = "003_Ensure user should be able to submit a publication and associate a collaboration group";
		String testDesc = "Ensure user should be able to submit a publication and associate a collaboration group"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLinkOnThePage(By.linkText("GROUPS"));
			Test.navigate_to_groups_page();
			Test.navigate_to_manage_collaboration_groups_page();
			Test.add_new_collaboration_group("Add", "", "", "Add", "", "Submit");
			Test.goHome();
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication(
				 "proceeding",/*** getpbType***/ 
				 "in press", /***getpbStatus ***/
				 "", /***getPubmedID ***/
				 "", /*** getDOI***/
				 "Test Submit Publication As Curator", /***getTitle ***/
				 "Test Journal",/***getJournal ***/ 
				 "", /*** getYear***/
				 "1", /*** getVolume***/
				 "1", /*** getStartPage***/
				 "99", /*** getEndPage***/
				 "Auto", /*** getAuthors***/
				 "FirstName", /*** getAuthFirstName***/
				 "LastName", /*** getAuthLastName***/
				 "FL", /*** getAuthInitials***/
				 "QA\nTest\nValidation\nPublication", /*** getKeywords***/
				 "Test Description for Publication", /***getDescription ***/
				 "characterization", /*** getResearchCategory***/
				 "Upload", /*** getUpload***/
				 "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", /***getUploadPath ***/ 
				 "", /*** getEnterFileURL***/
				 "", /*** getEnterFileURLPath***/
				 "test sample test", /*** getSampleName***/
				 "Add", /*** getAccessToThePublication***/
				 "Collaboration", /***getAccessBy ***/
				 "Researcher CaNano", /***getUserLoginName ***/
				 "canano_res", /***getUserName ***/
				 "read update delete", /*** getAccessToTheRole***/
				 "Submit", /***getSubmitOrResetOrUpdate ***/
				 "", /*** getSearchPublication***/
				 ""); /*** getEditAndAddToFavorites***/
			Test.wait_For(9000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 259
	//Test Name: 004_Ensure user should be able to submit a sample and associate a collaboration group
	@Test
	public void EnsureUserShouldBeAbleToSubmitASampleAndAssociateACollaborationGroup() throws Exception {
		String testName = "004_Ensure user should be able to submit a sample and associate a collaboration group";
		String testDesc = "Ensure user should be able to submit a sample and associate a collaboration group"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLinkOnThePage(By.linkText("GROUPS"));
			Test.navigate_to_groups_page();
			Test.navigate_to_manage_collaboration_groups_page();
			Test.add_new_collaboration_group("Add", "", "", "Add", "", "Submit");
			Test.goHome();
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
				 "Test Submit Sample As Researcher For Google like Search", /****getSampleName***/
				 "Add", /****getClickPOCAddButton***/
				 "", /****getPOCOrganizationName***/
				 "", /****getPOCRole***/
				 "Yes", /****getAddressYesOrNo***/
				 "Save", /****getPOCSaveOrCancel***/
				 "Test", /****getKeywordA***/
				 "Sample", /****getKeywordB***/
				 "qa", /****getKeywordC***/
				 "Yes", /****getAccessAddYes***/
				 "Collaboration", /****getAccessBy***/
				 "Guest Guest", /****getUserLoginName***/
				 "canano_guest", /****getUserName***/
				 "read update delete", /****getAccessToTheSample***/
				 "Submit" /****getSubmitOrReset***/);
			Test.wait_For(9000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	
	@After
	  public void tearDown() throws Exception {
		Test.shutdown();
	  }
}
