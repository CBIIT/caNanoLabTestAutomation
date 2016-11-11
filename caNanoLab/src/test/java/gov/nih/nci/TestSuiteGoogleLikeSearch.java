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

public class TestSuiteGoogleLikeSearch
{
	private static Logger logger=Logger.getLogger("TestSuite");
	
	static BaseNanoLabMethods Test = new BaseNanoLabMethods();	
	
	//Google Like Search
	//Google Like Search - Sample
	//Google Like Search - Sample Data - Public
	
	//S.N.: 237
	//Test Name: 001_Verify User able to search for publicly available samples from google like search without login
	@Test
	public void verifyUserAbleToSearchForPubliclyAvailableSamplesFromGoogleLikeSearchWithoutLogin() throws Exception {
		String testName = "001_Verify User able to search for publicly available samples from google like search without login";
		String testDesc = "Verify User able to search for publicly available samples from google like search without login"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
				 "Test Submit Sample for Google Like Search As Curator", /****getSampleName***/
				 "Add", /****getClickPOCAddButton***/
				 "", /****getPOCOrganizationName***/
				 "", /****getPOCRole***/
				 "Yes", /****getAddressYesOrNo***/
				 "Save", /****getPOCSaveOrCancel***/
				 "Test", /****getKeywordA***/
				 "Sample", /****getKeywordB***/
				 "qa", /****getKeywordC***/
				 "Yes", /****getAccessAddYes***/
				 "Public", /****getAccessBy***/
				 "", /****getUserLoginName***/
				 "", /****getUserName***/
				 "", /****getAccessToTheSample***/
				 "Submit" /****getSubmitOrReset***/);
			Test.logout();
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "Test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 "View"/***getActions ***/);
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
	
	//S.N.: 238
	//Test Name: 002_Verify User able to search for publicly available samples from google like search while user logged in as curator
	@Test
	public void verifyUserAbleToSearchForPubliclyAvailableSamplesFromGoogleLikeSearchWhileUserLoggedInAsCurator() throws Exception {
		String testName = "002_Verify User able to search for publicly available samples from google like search while user logged in as curator";
		String testDesc = "Verify User able to search for publicly available samples from google like search while user logged in as curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
				 "Test Submit Sample for Google Like Search As Curator", /****getSampleName***/
				 "Add", /****getClickPOCAddButton***/
				 "", /****getPOCOrganizationName***/
				 "", /****getPOCRole***/
				 "Yes", /****getAddressYesOrNo***/
				 "Save", /****getPOCSaveOrCancel***/
				 "Test", /****getKeywordA***/
				 "Sample", /****getKeywordB***/
				 "qa", /****getKeywordC***/
				 "Yes", /****getAccessAddYes***/
				 "Public", /****getAccessBy***/
				 "", /****getUserLoginName***/
				 "", /****getUserName***/
				 "", /****getAccessToTheSample***/
				 "Submit" /****getSubmitOrReset***/);
			Test.logout();
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "Test Submit Sample",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 "View"/***getActions ***/);
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
	
	//S.N.: 239
	//Test Name: 003_Verify User able to search for publicly available samples from google like search while user logged in as researcher
	@Test
	public void verifyUserAbleToSearchForPubliclyAvailableSamplesFromGoogleLikeSearchWhileUserLoggedInAsResearcher() throws Exception {
		String testName = "003_Verify User able to search for publicly available samples from google like search while user logged in as researcher";
		String testDesc = "Verify User able to search for publicly available samples from google like search while user logged in as researcher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
				 "Test Submit Sample for Google Like Search As Researcher", /****getSampleName***/
				 "Add", /****getClickPOCAddButton***/
				 "", /****getPOCOrganizationName***/
				 "", /****getPOCRole***/
				 "Yes", /****getAddressYesOrNo***/
				 "Save", /****getPOCSaveOrCancel***/
				 "Test", /****getKeywordA***/
				 "Sample", /****getKeywordB***/
				 "qa", /****getKeywordC***/
				 "Yes", /****getAccessAddYes***/
				 "Public", /****getAccessBy***/
				 "", /****getUserLoginName***/
				 "", /****getUserName***/
				 "", /****getAccessToTheSample***/
				 "Submit" /****getSubmitOrReset***/);
			Test.logout();
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "Test Submit Sample for Google Like Search As Researcher",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 "View"/***getActions ***/);
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
	
	//S.N.: 240
	//Test Name: 004_Verify User should not be able to search non publicly available samples from google like search without login
	@Test
	public void VerifyUserShouldNotBeAbleToSearchNonPubliclyAvailableSamplesFromGoogleLikeSearchWithoutLogin() throws Exception {
		String testName = "004_Verify User should not be able to search non publicly available samples from google like search without login";
		String testDesc = "Verify User should not be able to search non publicly available samples from google like search without login"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
				 "Test Submit Sample As Curator For Google like Search", /****getSampleName***/
				 "Add", /****getClickPOCAddButton***/
				 "", /****getPOCOrganizationName***/
				 "", /****getPOCRole***/
				 "Yes", /****getAddressYesOrNo***/
				 "Save", /****getPOCSaveOrCancel***/
				 "Test", /****getKeywordA***/
				 "Sample", /****getKeywordB***/
				 "qa", /****getKeywordC***/
				 "Yes", /****getAccessAddYes***/
				 "User", /****getAccessBy***/
				 "Researcher CaNano", /****getUserLoginName***/
				 "canano_res", /****getUserName***/
				 "read update delete", /****getAccessToTheSample***/
				 "Submit" /****getSubmitOrReset***/);
			Test.logout();
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "Read",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "",/***getSrchRsltVerifYes ***/ 
				 "",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_verification(
				 "Find", /***verRsltFind ***/ 
				 "", /***verSerchTerm ***/ 
				 "" /***verNoSearchResult ***/);
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
	
	//Google Like Search - Sample Data
	
	//S.N.: 241
	//Test Name: 001_Verify User able to search for publicly available samples from google like search while user logged in as curator
	@Test
	public void VerifyUserAbleToSearchForPubliclyAvailableSamplesFromGoogleLikeSearchWhileUserLoggedInAsCurator() throws Exception {
		String testName = "001_Verify User able to search for publicly available samples from google like search while user logged in as curator";
		String testDesc = "Verify User able to search for publicly available samples from google like search while user logged in as curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
				 "Test Submit Sample As Curator For Google like Search", /****getSampleName***/
				 "Add", /****getClickPOCAddButton***/
				 "", /****getPOCOrganizationName***/
				 "", /****getPOCRole***/
				 "Yes", /****getAddressYesOrNo***/
				 "Save", /****getPOCSaveOrCancel***/
				 "Test", /****getKeywordA***/
				 "Sample", /****getKeywordB***/
				 "qa", /****getKeywordC***/
				 "Yes", /****getAccessAddYes***/
				 "User", /****getAccessBy***/
				 "Researcher CaNano", /****getUserLoginName***/
				 "canano_res", /****getUserName***/
				 "read update delete", /****getAccessToTheSample***/
				 "Submit" /****getSubmitOrReset***/);
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "Test Submit Sample As Curator For Google like Search",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "",/***getSrchRsltVerifYes ***/ 
				 "",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_verification(
				 "Find", /***verRsltFind ***/ 
				 "", /***verSerchTerm ***/ 
				 "" /***verNoSearchResult ***/);
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
	
	//S.N.: 242
	//Test Name: 002_Verify User able to search for publicly available samples from google like search while user logged in as Researcher
	@Test
	public void VerifyUserAbleToSearchForPubliclyAvailableSamplesFromGoogleLikeSearchWhileUserLoggedInAsResearcher() throws Exception {
		String testName = "002_Verify User able to search for publicly available samples from google like search while user logged in as Researcher";
		String testDesc = "Verify User able to search for publicly available samples from google like search while user logged in as Researcher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
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
				 "User", /****getAccessBy***/
				 "Guest Guest", /****getUserLoginName***/
				 "canano_guest", /****getUserName***/
				 "read update delete", /****getAccessToTheSample***/
				 "Submit" /****getSubmitOrReset***/);
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "Test Submit Sample As Curator For Google like Search",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "",/***getSrchRsltVerifYes ***/ 
				 "",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_verification(
				 "Find", /***verRsltFind ***/ 
				 "", /***verSerchTerm ***/ 
				 "" /***verNoSearchResult ***/);
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
	
	//Google Like Search - General
	
	//S.N.: 243
	//Test Name: 001_Verify Google like search does not return any search results when user search for invalid search term
	@Test
	public void googleLikeSearchDoesNotReturnAnySearchResultsWhenUserSearchForInvalidSearchTerm() throws Exception {
		String testName = "001_Verify Google like search does not return any search result when user search for invalid search term";
		String testDesc = "Verify Google like search does not return any search result when user search for invalid search term"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "abcdefghijklmnopqrstuvwxyz",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "",/***getSrchRsltVerifYes ***/ 
				 "",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_verification(
				 "", /***verRsltFind ***/ 
				 "", /***verSerchTerm ***/ 
				 "No Search Result" /***verNoSearchResult ***/);
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
	
	//S.N.: 244
	//Test Name: 002_Ensure user able to sort google like search results by name
	@Test
	public void EnsureUserAbleToSortGoogleLikeSearchResultsByName() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by name";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by name column"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Name");
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
	
	//S.N.: 245
	//Test Name: 003_Ensure user able to sort google like search results by type
	@Test
	public void EnsureUserAbleToSortGoogleLikeSearchResultsByType() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Type";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Type column"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Type");
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
	
	//S.N.: 246
	//Test Name: 004_Ensure user able to sort google like search results by Created Date
	@Test
	public void EnsureUserAbleToSortGoogleLikeSearchResultsByCreatedDate() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Created Date";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Created Date column"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("CreatedDate");
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
	
	//S.N.: 247
	//Test Name: 005_Ensure user able to sort google like search results by Description
	@Test
	public void EnsureUserAbleToSortGoogleLikeSearchResultsByDescription() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Description";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Description column"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Description");
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
	
	//S.N.: 248
	//Test Name: 006_Ensure user able to sort google like search results by name when user logged in as Curator
	@Test
	public void EnsureUserAbleToSortGoogleLikeSearchResultsByNameWhenUserLoggerInAsCurator() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by name when user logged in as Curator";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by name column when user logged in as Curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Name");
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
	
	//S.N.: 249
	//Test Name: 007_Ensure user able to sort google like search results by type when user logged in as Curator
	@Test
	public void EnsureUserAbleToSortGoogleLikeSearchResultsByTypeWhenUserLoggerInAsCurator() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Type when user logged in as Curator";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Type column when user logged in as Curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Type");
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
	
	//S.N.: 250
	//Test Name: 008_Ensure user able to sort google like search results by Created Date when user logged in as Curator
	@Test
	public void EnsureUserAbleToSortGoogleLikeSearchResultsByCreatedDateWhenUserLoggerInAsCurator() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Created Date when user logged in as Curator";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Created Date column when user logged in as Curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("CreatedDate");
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
	
	//S.N.: 251
	//Test Name: 009_Ensure user able to sort google like search results by Description when user logged in as Curator
	@Test
	public void EnsureUserAbleToSortGoogleLikeSearchResultsByDescriptionWhenUserLoggerInAsCurator() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Description when user logged in as Curator";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Description column when user logged in as Curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Description");
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
	
	//S.N.: 252
	//Test Name: 010_Ensure user able to sort google like search results by name when user logged in as Researcher
	@Test
	public void EnsureUserAbleToSortGoogleLikeSearchResultsByNameWhenUserLoggerInAsReasercher() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by name when user logged in as Reasercher";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by name column when user logged in as Reasercher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Name");
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
	
	//S.N.: 253
	//Test Name: 011_Ensure user able to sort google like search results by type when user logged in as Reasercher
	@Test
	public void EnsureUserAbleToSortGoogleLikeSearchResultsByTypeWhenUserLoggerInAsReasercher() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Type when user logged in as Reasercher";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Type column when user logged in as Reasercher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Type");
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
	
	//S.N.: 254
	//Test Name: 012_Ensure user able to sort google like search results by Created Date when user logged in as Reasercher
	@Test
	public void EnsureUserAbleToSortGoogleLikeSearchResultsByCreatedDateWhenUserLoggerInAsReasercher() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Created Date when user logged in as Reasercher";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Created Date column when user logged in as Reasercher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("CreatedDate");
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
	
	//S.N.: 255
	//Test Name: 013_Ensure user able to sort google like search results by Description when user logged in as Reasercher
	@Test
	public void EnsureUserAbleToSortGoogleLikeSearchResultsByDescriptionWhenUserLoggerInAsReasercher() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Description when user logged in as Reasercher";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Description column when user logged in as Reasercher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Description");
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
	
	@After
	  public void tearDown() throws Exception {
		Test.shutdown();
	  }
}
