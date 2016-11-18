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

public class TestSuiteB
{
	private static Logger logger = Logger.getLogger("TestSuite");

	static BaseNanoLabMethods Test = new BaseNanoLabMethods();

	//S.N.: 52
	//Test Name: 011_Verify_the_ability_to_search_non_publically_available_samples_when_logged_in_as_curator
	@Test
	public void verifyAbilityToSearchNonPublicallyAvailableSamplesWhenLoggedInAsCurator() throws Exception {
		String testName = "011_Verify_the_ability_to_search_non_publically_available_samples_when_logged_in_as_curator";
		String testDesc = "verify the ability to search non publically available samples data by loggin in as a curator.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Login to submit data");
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "equals", "SNL_UNM-CAshleyACSNano2012-25", "", "", "", "", "", "", "", "search");
			Test.wait_For(4000);
			//Test.sample_search_results_verification("One item found.");
			Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}		
	}

	//S.N.: 58
	//Test Name: 003_Verify_that_a_researcher_can_only_view_sample_details_for_samples_that_he_has_readonly_access
	@Test
	public void verifyThatAResearcherCanOnlyViewSampleDetailsforSamplesThatHehasReadOnlyAccess() throws Exception {
		String testName = "003_Verify_that_a_researcher_can_only_view_sample_details_for_samples_that_he_has_readonly_access";
		String testDesc = "Verify that a user with Researcher privileges can ONLY view sample details for sample he/she has readonly access.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Login to submit data");
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "equals", "NCL-23-1", "", "", "", "", "", "", "", "search");
			Test.wait_For(4000);
			//Test.sample_search_results_verification("One item found.");
			Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			Test.view_sample_details_from_search_results_page("NCL-23-1");
			Test.view_sample_composition_from_search_results_page("NCL-23-1");
			Test.view_sample_characterization_from_search_results_page("NCL-23-1");
			Test.view_sample_publication_from_search_results_page("NCL-23-1", "All");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}		
	}

	//S.N.: 62
	//Test Name: 003_Verify_sample_search_by_publication_PubMed_ID_as_a_Curator
	@Test
	public void verifySampleSearchByPublicationPubMedIDasaCurator() throws Exception {
		String testName = "003_Verify_sample_search_by_publication_PubMed_ID_as_a_Curator";
		String testDesc = "Verify Curator able to search publicly available data from caNanoLab Publication search page by PubMed ID"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.Verify_sample_search_by_publication_PubMed_ID_as_a_Curator("17278104", "PubMed ID: 17278104");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 63
	//Test Name: 004_Verify_sample_search_by_publication_DOI_as_a_Curator
	@Test
	public void verifySampleSearchByPublicationDOIasaCurator() throws Exception {
		String testName = "004_Verify_sample_search_by_publication_DOI_as_a_Curator";
		String testDesc = "Verify Curator able to search publicly available data from caNanoLab Publication search page by DOI"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.Verify_sample_search_by_publication_DOI_as_a_Curator("10.1002%2Fijc.22581", "DOI Id: 10.1002/ijc.22581");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 64
	//Test Name: 004_Verify_sample_search_by_publication_DOI_as_a_Curator
	@Test
	public void verifySampleSearchByPublicationPubMedIDasaResearcher() throws Exception {
		String testName = "005_Verify_sample_search_by_publication_PubMed_ID_as_a_Researcher";
		String testDesc = "Verify Researcher able to search publicly available data from caNanoLab Publication search page by PubMed ID"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLogin(By.linkText("PUBLICATIONS"));
			Test.Verify_sample_search_by_publication_PubMed_ID_as_a_Researcher("17278104", "PubMed ID: 17278104");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 65
	//Test Name: 006_Verify_sample_search_by_publication_DOI_as_a_Researcher
	@Test
	public void verifySampleSearchByPublicationDOIasaResearcher() throws Exception {
		String testName = "006_Verify_sample_search_by_publication_DOI_as_a_Researcher";
		String testDesc = "Verify Researcher able to search publicly available data from caNanoLab Publication search page by DOI";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLogin(By.linkText("PUBLICATIONS"));
			Test.Verify_sample_search_by_publication_DOI_as_a_Researcher("10.1002%2Fijc.22581", "DOI Id: 10.1002/ijc.22581");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 94
	//Test Name: 014_verify_publication_search_by_keyword_as_a_Curator
	@Test
	public void verifyPublicationSearchByKeywordAsaCurator() throws Exception {
		String testName = "014_verify_publication_search_by_keyword_as_a_Curator";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Keyword as a Curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.verify_publication_search_by_keyword_as_a_Curator("test");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 95
	//Test Name: 018_verify_publication_search_by_keyword_as_a_Researcher
	@Test
	public void verifyPublicationSearchByKeywordAsaResearcher() throws Exception {
		String testName = "018_verify_publication_search_by_keyword_as_a_Researcher";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Keyword as a Researcher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLogin(By.linkText("PUBLICATIONS"));
			Test.verify_publication_search_by_keyword_as_a_Researcher("test");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	// Publication >> Add Publication
	//S.N.: 96
	//Test Name: 001_Verify_the_ability_to_submit_a_New_Publication_as_a_Curator
	@Test
	public void VerifyTheAbilityToSubmitaNewPublicationAsaCurator() throws Exception {
		String testName = "001_Verify_the_ability_to_submit_a_New_Publication_as_a_Curator";
		String testDesc = "Verify Curator user able to submit a new publication as a curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication("proceeding", "in press", "", "", "Test Submit Publication As Curator", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "Upload", "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", "", "", "test sample test", "Add", "User", "Researcher CaNano", "canano_res", "read update delete", "Submit", "Search", "");
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

	//S.N.: 97
	//Test Name: 002_Verify_the_ability_to_submit_a_New_Publication_as_a_Researcher
	@Test
	public void VerifyTheAbilityToSubmitaNewPublicationAsaResearcher() throws Exception {
		String testName = "002_Verify_the_ability_to_submit_a_New_Publication_as_a_Researcher";
		String testDesc = "Verify researcher user able to submit a new publication as a curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLogin(By.linkText("PUBLICATIONS"));
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication("proceeding", "in press", "", "", "Test Submit Publication As Researcher", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "Upload", "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", "", "", "test sample test", "Add", "User", "Researcher CaNano", "canano_res", "read update delete", "Submit", "Search", "");
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

	/*
	 * CURATION 
	 * Review Data Pending Release to Public
	 */

	//S.N.: 98
	//Test Name: 001_Verify_Curator_should_be_able_to_review_pending_data
	@Test
	public void verifyCuratorShouldBeAbleToReviewPendingData() throws Exception {
		String testName = "001_Verify_Curator_should_be_able_to_review_pending_data";
		String testDesc = "Verify Curator able to review pending data"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String HomePageURL = hostName + "/caNanoLab/#/home";
			Test.verifyUrl(HomePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.clickPageLinks("Review Data Pending Release to Public", "Review By Curator");
			Test.Verify_Curator_should_be_able_to_review_pending_data("sample", "Data Type", "Data Name");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	/*
	 * CURATION 
	 * Remove Struts from CURATION page
	 */

	//S.N.: 99
	//Test Name: 001_Ensure_Struts_has_been_removed_from_Manage_Curation_page
	@Test
	public void ensureStrutsHasBeenRemovedfromManageCurationPage() throws Exception {
		String testName = "001_Ensure_Struts_has_been_removed_from_Manage_Curation_page";
		String testDesc = "Ensure Struts has been removed from Manage Curation page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = hostName + "/caNanoLab/#/";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			String manageCurationURL = hostName + "/caNanoLab/#/manageCuration";
			Test.verifyUrl(manageCurationURL);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 100
	//Test Name: 002_Ensure_Struts_has_been_removed_from_Review_By_Curator_page
	@Test
	public void ensureStrutsHasBeenRemovedFromReviewByCuratorPage() throws Exception {
		String testName = "002_Ensure_Struts_has_been_removed_from_Review_By_Curator_page";
		String testDesc = "Ensure Struts has been removed from Review by Curator page and system is displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = hostName + "/caNanoLab/#/";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.clickPageLinks("Review Data Pending Release to Public", "Review By Curator");
			String reviewByCuratorURL = hostName + "/caNanoLab/#/reviewData";
			Test.verifyUrl(reviewByCuratorURL);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	@Before
	public void setup()
	{
	}

	@After
	public void tearDown() throws Exception {
		Test.shutdown();
	}
}
