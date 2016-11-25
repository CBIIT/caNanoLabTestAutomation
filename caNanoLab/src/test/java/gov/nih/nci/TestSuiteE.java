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

public class TestSuiteE
{
	private static Logger logger = Logger.getLogger("TestSuite");

	static BaseNanoLabMethods Test = new BaseNanoLabMethods();

	//My Favorites
	//Edit

	//S.N.: 201
	//Test Name: 001_Ensure Curator user able to add a Sample to the Favorites list and edit the added sample from my favorites page
	@Test
	public void EnsureCuratorUserAbleToAddASampleToTheFavoritesListAndEditTheAddedSampleFromMyFavoritesPage() throws Exception {
		String testName = "001_Ensure Curator user able to add a Sample to the Favorites list and edit the added sample from my favorites page";
		String testDesc = "Ensure Curator user able to add a Sample to the Favorites list and edit the added sample from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Test Submit Sample As", "", "", "", "", "", "", "", "search");
			Test.wait_until_search_samples_table_data_load();
			Test.sample_add_to_favorites("Test Submit Sample", "yes", "edit");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 202
	//Test Name: 002_Ensure Curator user able to add a Protocol to the Favorites list and edit the added protocol from my favorites page
	@Test
	public void ensureCuratorUserAbleToAddAProtocolToTheFavoritesListAndEditTheAddedProtocolFromMyFavoritesPage() throws Exception {
		String testName = "002_Ensure Curator user able to add a Protocol to the Favorites list and edit the added protocol from my favorites page";
		String testDesc = "Ensure Curator user able to add a Protocol to the Favorites list and edit the added protocol from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "Test Submit Protocol", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("Test Submit Protocol", "yes", "edit");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 203
	//Test Name: 003_Ensure Curator user able to add a publication to the Favorites list and edit the added publication from my favorites page
	@Test
	public void EnsureCuratorUserAbleToAddAPublicationToTheFavoritesListAndEditTheAddedPublicationFromMyFavoritesPage() throws Exception {
		String testName = "003_Ensure Curator user able to add a publication to the Favorites list and edit the added publication from my favorites page";
		String testDesc = "Ensure Curator user able to add a publication to the Favorites list and edit the added publication from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_publication_all();
			Test.navigate_to_publication_search_page();
			Test.publication_search("", "", "", "", "contains", "Test Submit publication", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("Test Submit Publication", "yes", "edit");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//My Favorites
	//remove

	//S.N.: 204
	//Test Name: 001_Ensure Curator user able to add a Sample to the Favorites list and remove the added sample from my favorites page
	@Test
	public void EnsureCuratorUserAbleToAddASampleToTheFavoritesListAndRemoveTheAddedSampleFromMyFavoritesPage() throws Exception {
		String testName = "001_Ensure Curator user able to add a Sample to the Favorites list and remove the added sample from my favorites page";
		String testDesc = "Ensure Curator user able to add a Sample to the Favorites list and remove the added sample from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Test Submit Sample As", "", "", "", "", "", "", "", "search");
			Test.wait_until_search_samples_table_data_load();
			Test.sample_add_to_favorites("Test Submit Sample", "yes", "remove");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 205
	//Test Name: 002_Ensure Curator user able to add a Protocol to the Favorites list and remove the added protocol from my favorites page
	@Test
	public void ensureCuratorUserAbleToAddAProtocolToTheFavoritesListAndRemoveTheAddedProtocolFromMyFavoritesPage() throws Exception {
		String testName = "002_Ensure Curator user able to add a Protocol to the Favorites list and remove the added protocol from my favorites page";
		String testDesc = "Ensure Curator user able to add a Protocol to the Favorites list and remove the added protocol from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "Test Submit Protocol", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("Test Submit Protocol", "yes", "remove");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 206
	//Test Name: 003_Ensure Curator user able to add a publication to the Favorites list and remove the added publication from my favorites page
	@Test
	public void EnsureCuratorUserAbleToAddAPublicationToTheFavoritesListAndRemoveTheAddedPublicationFromMyFavoritesPage() throws Exception {
		String testName = "003_Ensure Curator user able to add a publication to the Favorites list and remove the added publication from my favorites page";
		String testDesc = "Ensure Curator user able to add a publication to the Favorites list and remove the added publication from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_publication_all();
			Test.navigate_to_publication_search_page();
			Test.publication_search("", "", "", "", "contains", "Test Submit publication", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("Test Submit Publication", "yes", "remove");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	// Favorites
	// Researcher

	//S.N.: 207
	//Test Name: 001_Ensure researcher user able to add a Sample to the Favorites list
	@Test
	public void EnsureresearcherUserAbleToAddASampleToTheFavoritesList() throws Exception {
		String testName = "001_Ensure researcher user able to add a Sample to the Favorites list";
		String testDesc = "Ensure researcher user able to add a Sample from sample search results page to the my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Test Submit Sample As", "", "", "", "", "", "", "", "search");
			Test.wait_until_search_samples_table_data_load();
			Test.sample_add_to_favorites("Test Submit Sample", "yes", "");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 208
	//Test Name: 002_Ensure researcher user able to add a Protocol to the Favorites list
	@Test
	public void EnsureresearcherUserAbleToAddAProtocolToTheFavoritesList() throws Exception {
		String testName = "002_Ensure researcher user able to add a Protocol to the Favorites list";
		String testDesc = "Ensure researcher user able to add a Protocol from Protocol search results page to the my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "ASYN_B00005_PROT1", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("ASYN_B00005_PROT1", "yes", "");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 209
	//Test Name: 003_Ensure researcher user able to add a Publication to the Favorites list
	@Test
	public void EnsureresearcherUserAbleToAddAPublicationToTheFavoritesList() throws Exception {
		String testName = "003_Ensure researcher user able to add a Publication to the Favorites list";
		String testDesc = "Ensure researcher user able to add a Publication from Publication search results page to the my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_publication_all();
			Test.navigate_to_publication_search_page();
			Test.publication_search("", "", "", "", "contains", "Test Submit publication", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("Test Submit Publication", "yes", "");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//My Favorites
	//Researcher
	//View

	//S.N.: 210
	//Test Name: 001_Ensure researcher user able to add a Sample to the Favorites list and view the added sample from my favorites page
	@Test
	public void EnsureresearcherUserAbleToAddASampleToTheFavoritesListAndViewTheAddedSampleFromMyFavoritesPage() throws Exception {
		String testName = "001_Ensure researcher user able to add a Sample to the Favorites list and view the added sample from my favorites page";
		String testDesc = "Ensure researcher user able to add a Sample to the Favorites list and view the added sample from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Test Submit Sample", "", "", "", "", "", "", "", "search");
			Test.wait_until_search_samples_table_data_load();
			Test.sample_add_to_favorites("Test Submit Sample", "yes", "view");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 211
	//Test Name: 002_Ensure researcher user able to add a Protocol to the Favorites list and view the added protocol from my favorites page
	@Test
	public void ensureresearcherUserAbleToAddAProtocolToTheFavoritesListAndViewTheAddedProtocolFromMyFavoritesPage() throws Exception {
		String testName = "002_Ensure researcher user able to add a Protocol to the Favorites list and view the added protocol from my favorites page";
		String testDesc = "Ensure researcher user able to add a Protocol to the Favorites list and view the added protocol from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "Test Submit Protocol", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("Test Submit Protocol", "yes", "view");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 212
	//Test Name: 003_Ensure researcher user able to add a publication to the Favorites list and view the added publication from my favorites page
	@Test
	public void EnsureresearcherUserAbleToAddAPublicationToTheFavoritesListAndViewTheAddedPublicationFromMyFavoritesPage() throws Exception {
		String testName = "003_Ensure researcher user able to add a publication to the Favorites list and view the added publication from my favorites page";
		String testDesc = "Ensure researcher user able to add a publication to the Favorites list and view the added publication from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_publication_all();
			Test.navigate_to_publication_search_page();
			Test.publication_search("", "", "", "", "contains", "Test Submit publication", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("Test Submit Publication", "yes", "view");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//My Favorites
	//Researcher
	//Edit

	//S.N.: 213
	//Test Name: 001_Ensure researcher user able to add a Sample to the Favorites list and edit the added sample from my favorites page
	@Test
	public void EnsureresearcherUserAbleToAddASampleToTheFavoritesListAndEditTheAddedSampleFromMyFavoritesPage() throws Exception {
		String testName = "001_Ensure researcher user able to add a Sample to the Favorites list and edit the added sample from my favorites page";
		String testDesc = "Ensure researcher user able to add a Sample to the Favorites list and edit the added sample from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Test Submit Sample As Researcher", "", "", "", "", "", "", "", "search");
			Test.wait_until_search_samples_table_data_load();
			Test.sample_add_to_favorites("Test Submit Sample As Researcher", "yes", "edit");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 214
	//Test Name: 002_Ensure researcher user able to add a Protocol to the Favorites list and edit the added protocol from my favorites page
	@Test
	public void ensureResearcherUserAbleToAddAProtocolToTheFavoritesListAndEditTheAddedProtocolFromMyFavoritesPage() throws Exception {
		String testName = "002_Ensure researcher user able to add a Protocol to the Favorites list and edit the added protocol from my favorites page";
		String testDesc = "Ensure researcher user able to add a Protocol to the Favorites list and edit the added protocol from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "Test Submit Protocol", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("Test Submit Protocol", "yes", "edit");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 215
	//Test Name: 003_Ensure researcher user able to add a publication to the Favorites list and edit the added publication from my favorites page
	@Test
	public void EnsureresearcherUserAbleToAddAPublicationToTheFavoritesListAndEditTheAddedPublicationFromMyFavoritesPage() throws Exception {
		String testName = "003_Ensure researcher user able to add a publication to the Favorites list and edit the added publication from my favorites page";
		String testDesc = "Ensure researcher user able to add a publication to the Favorites list and edit the added publication from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_publication_all();
			Test.navigate_to_publication_search_page();
			Test.publication_search("", "", "", "", "contains", "Test Submit publication", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("Test Submit Publication", "yes", "edit");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//My Favorites
	//Researcher
	//remove

	//S.N.: 216
	//Test Name: 001_Ensure researcher user able to add a Sample to the Favorites list and remove the added sample from my favorites page
	@Test
	public void EnsureResearcherUserAbleToAddASampleToTheFavoritesListAndRemoveTheAddedSampleFromMyFavoritesPage() throws Exception {
		String testName = "001_Ensure researcher user able to add a Sample to the Favorites list and remove the added sample from my favorites page";
		String testDesc = "Ensure researcher user able to add a Sample to the Favorites list and remove the added sample from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Sample", "", "", "", "", "", "", "", "search");
			Test.wait_until_search_samples_table_data_load();
			Test.sample_add_to_favorites("Test Submit Sample", "yes", "remove");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 217
	//Test Name: 002_Ensure researcher user able to add a Protocol to the Favorites list and remove the added protocol from my favorites page
	@Test
	public void ensureResearcherUserAbleToAddAProtocolToTheFavoritesListAndRemoveTheAddedProtocolFromMyFavoritesPage() throws Exception {
		String testName = "002_Ensure researcher user able to add a Protocol to the Favorites list and remove the added protocol from my favorites page";
		String testDesc = "Ensure researcher user able to add a Protocol to the Favorites list and remove the added protocol from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "ASYN_B00005_PROT1", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("Test Submit Protocol", "yes", "remove");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 218
	//Test Name: 003_Ensure researcher user able to add a publication to the Favorites list and remove the added publication from my favorites page
	@Test
	public void EnsureResearcherUserAbleToAddAPublicationToTheFavoritesListAndRemoveTheAddedPublicationFromMyFavoritesPage() throws Exception {
		String testName = "003_Ensure researcher user able to add a publication to the Favorites list and remove the added publication from my favorites page";
		String testDesc = "Ensure researcher user able to add a publication to the Favorites list and remove the added publication from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_publication_all();
			Test.navigate_to_publication_search_page();
			Test.publication_search("", "", "", "", "contains", "nonpalpable tumors", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("Test Submit Publication", "yes", "remove");
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	// Sample Submit - Curator

	//S.N.: 219
	//Test Name: 001_Ensure Curator User able to submit a sample
	@Test
	public void EnsureCuratorUserAbleToSubmitASample() throws Exception {
		String testName = "001_Ensure Curator User able to submit a sample";
		String testDesc = "Verify curator user able to login to the system as curator and submit a sample successfully"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample As Curator", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 220
	//Test Name: 002_Ensure Curator User able to submit a Nanomaterial entity to the sample 
	@Test
	public void ensureCuratorUserAbleToSubmitANanomaterialEntityToTheSample() throws Exception {
		String testName = "002_Ensure Curator User able to submit a Nanomaterial entity to the sample";
		String testDesc = "Ensure Curator User able to submit a Nanomaterial entity to the sample "; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Nanomaterial Entity As Curator", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_nanomaterial_entity();
			Test.submit_a_sample_composition_nanomaterrial(
					"biopolymer", /****getNanomaterialEntityType***/
					"Test Submit Sample Nanomaterial Entity", /****getDescription ***/ 
					"arabino-hezulose", /****getBiopolymerName ***/
					"peptide", /**** getBiopolymerType ***/ 
					"test arabino-hezulose", /****getBiopolymerSequence ***/ 
					"coat", /****getCompEleType ***/
					"Acetaminophen", /****getCompEleChemicalName ***/
					"Substance", /****getCompElePubChemDataSource ***/
					"random", /****getCompElePubChemId ***/
					"0.1", /****getCompEleAmount ***/
					"%", /****getCompEleAmountUnit ***/
					"Hill", /****getCompEleMolecularFormulaType ***/
					"Acetaminophen", /****getMolecularFormula ***/
					"Acetaminophen (paracetamol, N-acetyl-p-aminophenol, 4-hydroxyacetanilide) is a widely used analgesic and antipyretic", /****getComEleDescription ***/
					"Add", /****getCompEleInherentFunctionAdd ***/
					"endosomolysis", /****getComEleInherentFunctionType ***/
					"endosomolysis description", /****getComEleInherentDescription ***/
					"Save", /****getInherentFunctionSaveOrCancelOrRemove ***/
					"Save", /****getCompositionElementSaveOrCancel ***/
					"Add", /****getFileAdd***/
					"Upload", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"SamplesFile", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"image", /****getFileType***/
					"Test Sample Image", /****getFileTitle***/
					"Test Image", /****getFileKeywords***/
					"Test Image Description", /****getFileDescription***/
					"Save", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/);
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 221
	//Test Name: 003_Ensure Curator User able to submit a Functionalzing entity to the sample 
	@Test
	public void ensureCuratorUserAbleToSubmitAFunctionalizingEntityToTheSample() throws Exception {
		String testName = "003_Ensure Curator User able to submit a Functionalzing entity to the sample";
		String testDesc = "Ensure Curator User able to submit a Functionalzing entity to the sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Functionalizing Entity As Curator", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_functionalizing_entity();
			Test.submit_a_sample_composition_functionalizing(
					"Magnetic Particle", /***getFunctionalizingEntityType***/
					"Chromate and dichromate",
					"BioAssay",
					"random",
					"5",
					"%",
					"Hill",
					"Test Molecular Formula",
					"enzymatic cleavage",
					"Test Activation Effect",
					"Description",
					"", /***getInherentFunctionAdd***/
					"endosomolysis",
					"Inherent Function Description",
					"Save",
					"",
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/
					);
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 222
	//Test Name: 004_Ensure Curator User able to submit a Chemical Association to the sample 
	@Test
	public void ensureCuratorUserAbleToSubmitAChemicalAssociationToTheSample() throws Exception {
		String testName = "004_Ensure Curator User able to submit a Chemical Association to the sample";
		String testDesc = "Ensure Curator User able to submit a Chemical Association to the sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Chemical Association As Curator", /****getSampleName***/
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
					"canano_res", /****getUserLoginName***/
					"canano_res", /****getUserName***/
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_nanomaterial_entity();
			Test.submit_a_sample_composition_nanomaterrial(
					"biopolymer", /****getNanomaterialEntityType***/
					"Test Submit Sample Nanomaterial Entity", /****getDescription ***/ 
					"arabino-hezulose", /****getBiopolymerName ***/
					"peptide", /**** getBiopolymerType ***/ 
					"test arabino-hezulose", /****getBiopolymerSequence ***/ 
					"coat", /****getCompEleType ***/
					"Acetaminophen", /****getCompEleChemicalName ***/
					"Substance", /****getCompElePubChemDataSource ***/
					"random", /****getCompElePubChemId ***/
					"0.1", /****getCompEleAmount ***/
					"%", /****getCompEleAmountUnit ***/
					"Hill", /****getCompEleMolecularFormulaType ***/
					"Acetaminophen", /****getMolecularFormula ***/
					"Acetaminophen (paracetamol, N-acetyl-p-aminophenol, 4-hydroxyacetanilide) is a widely used analgesic and antipyretic", /****getComEleDescription ***/
					"Add", /****getCompEleInherentFunctionAdd ***/
					"endosomolysis", /****getComEleInherentFunctionType ***/
					"endosomolysis description", /****getComEleInherentDescription ***/
					"Save", /****getInherentFunctionSaveOrCancelOrRemove ***/
					"Save", /****getCompositionElementSaveOrCancel ***/
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/);
			Test.wait_For(5000);
			Test.navigate_to_sample_composition_functionalizing_entity();
			Test.submit_a_sample_composition_functionalizing(
					"Magnetic Particle", /***getFunctionalizingEntityType***/
					"Chromate and dichromate",
					"BioAssay",
					"random",
					"5",
					"%",
					"Hill",
					"Test Molecular Formula",
					"enzymatic cleavage",
					"Test Activation Effect",
					"Description",
					"", /***getInherentFunctionAdd***/
					"endosomolysis",
					"Inherent Function Description",
					"Save",
					"",
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/
					);
			Test.wait_For(5000);
			Test.navigate_to_sample_composition_chamical_association();
			Test.submit_a_sample_composition_chemical_association(
					"Association", /****getAssociationType***/
					"Test Submit Chemical Association", /****getDescription***/
					"nanomaterial entity", /****getElementSelectA***/
					"functionalizing entity", /****getElementSelectB***/
					"biopolymer", /****getEelementSelectAA***/
					"Magnetic Particle", /****getEelementSelectBB***/
					"coat (name: Acetaminophen)", /****getEelementSelectAAA***/
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"Submit" /****getSubmitOrReset ***/
					);
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 223
	//Test Name: 005_Ensure Curator User able to submit a Composition File to the sample 
	@Test
	public void ensureCuratorUserAbleToSubmitACompositionFileToTheSample() throws Exception {
		String testName = "005_Ensure Curator User able to submit a Composition File to the sample";
		String testDesc = "Ensure Curator User able to submit a Composition File to the sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Composition File As Curator", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.wait_For(5000);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_file();
			Test.submit_a_sample_composition_file(
					"File", /****getFileAdd***/
					"Upload", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"SamplesFile", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"image", /****getFileType***/
					"Test Sample Image", /****getFileTitle***/
					"Test Image", /****getFileKeywords***/
					"Test Image Description", /****getFileDescription***/
					"Submit" /****getSubmitOrReset ***/
					);	
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//Submit Sample - Researcher

	//S.N.: 224
	//Test Name: 001_Ensure Researcher User able to submit a sample
	@Test
	public void EnsureResearcherUserAbleToSubmitASample() throws Exception {
		String testName = "001_Ensure Researcher User able to submit a sample";
		String testDesc = "Verify Researcher user able to login to the system as Researcher and submit a sample successfully"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample As Researcher", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 225
	//Test Name: 002_Ensure Researcher User able to submit a Nanomaterial entity to the sample 
	@Test
	public void ensureResearcherUserAbleToSubmitANanomaterialEntityToTheSample() throws Exception {
		String testName = "002_Ensure Researcher User able to submit a Nanomaterial entity to the sample";
		String testDesc = "Ensure Researcher User able to submit a Nanomaterial entity to the sample "; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Nanomaterial Entity As Researcher", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_nanomaterial_entity();
			Test.submit_a_sample_composition_nanomaterrial(
					"biopolymer", /****getNanomaterialEntityType***/
					"Test Submit Sample Nanomaterial Entity", /****getDescription ***/ 
					"arabino-hezulose", /****getBiopolymerName ***/
					"peptide", /**** getBiopolymerType ***/ 
					"test arabino-hezulose", /****getBiopolymerSequence ***/ 
					"coat", /****getCompEleType ***/
					"Acetaminophen", /****getCompEleChemicalName ***/
					"Substance", /****getCompElePubChemDataSource ***/
					"random", /****getCompElePubChemId ***/
					"0.1", /****getCompEleAmount ***/
					"%", /****getCompEleAmountUnit ***/
					"Hill", /****getCompEleMolecularFormulaType ***/
					"Acetaminophen", /****getMolecularFormula ***/
					"Acetaminophen (paracetamol, N-acetyl-p-aminophenol, 4-hydroxyacetanilide) is a widely used analgesic and antipyretic", /****getComEleDescription ***/
					"Add", /****getCompEleInherentFunctionAdd ***/
					"endosomolysis", /****getComEleInherentFunctionType ***/
					"endosomolysis description", /****getComEleInherentDescription ***/
					"Save", /****getInherentFunctionSaveOrCancelOrRemove ***/
					"Save", /****getCompositionElementSaveOrCancel ***/
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/);
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 226
	//Test Name: 003_Ensure Researcher User able to submit a Functionalzing entity to the sample 
	@Test
	public void ensureResearcherUserAbleToSubmitAFunctionalizingEntityToTheSample() throws Exception {
		String testName = "003_Ensure Researcher User able to submit a Functionalzing entity to the sample";
		String testDesc = "Ensure Researcher User able to submit a Functionalzing entity to the sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Functionalizing Entity As Researcher", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_functionalizing_entity();
			Test.submit_a_sample_composition_functionalizing(
					"Magnetic Particle", /***getFunctionalizingEntityType***/
					"Chromate and dichromate",
					"BioAssay",
					"random",
					"5",
					"%",
					"Hill",
					"Test Molecular Formula",
					"enzymatic cleavage",
					"Test Activation Effect",
					"Description",
					"", /***getInherentFunctionAdd***/
					"endosomolysis",
					"Inherent Function Description",
					"Save",
					"",
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/
					);
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 227
	//Test Name: 004_Ensure Researcher User able to submit a Chemical Association to the sample 
	@Test
	public void ensureResearcherUserAbleToSubmitAChemicalAssociationToTheSample() throws Exception {
		String testName = "004_Ensure Researcher User able to submit a Chemical Association to the sample";
		String testDesc = "Ensure Researcher User able to submit a Chemical Association to the sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Chemical Association As Researcher", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_nanomaterial_entity();
			Test.submit_a_sample_composition_nanomaterrial(
					"biopolymer", /****getNanomaterialEntityType***/
					"Test Submit Sample Nanomaterial Entity", /****getDescription ***/ 
					"arabino-hezulose", /****getBiopolymerName ***/
					"peptide", /**** getBiopolymerType ***/ 
					"test arabino-hezulose", /****getBiopolymerSequence ***/ 
					"coat", /****getCompEleType ***/
					"Acetaminophen", /****getCompEleChemicalName ***/
					"Substance", /****getCompElePubChemDataSource ***/
					"random", /****getCompElePubChemId ***/
					"0.1", /****getCompEleAmount ***/
					"%", /****getCompEleAmountUnit ***/
					"Hill", /****getCompEleMolecularFormulaType ***/
					"Acetaminophen", /****getMolecularFormula ***/
					"Acetaminophen (paracetamol, N-acetyl-p-aminophenol, 4-hydroxyacetanilide) is a widely used analgesic and antipyretic", /****getComEleDescription ***/
					"Add", /****getCompEleInherentFunctionAdd ***/
					"endosomolysis", /****getComEleInherentFunctionType ***/
					"endosomolysis description", /****getComEleInherentDescription ***/
					"Save", /****getInherentFunctionSaveOrCancelOrRemove ***/
					"Save", /****getCompositionElementSaveOrCancel ***/
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/);
			Test.wait_For(5000);
			/*Test.navigate_to_sample_composition_functionalizing_entity();
			Test.submit_a_sample_composition_functionalizing(
				 "Magnetic Particle", /***getFunctionalizingEntityType***//*
				 "Chromate and dichromate",
				 "BioAssay",
				 "random",
				 "5",
				 "%",
				 "Hill",
				 "Test Molecular Formula",
				 "enzymatic cleavage",
				 "Test Activation Effect",
				 "Description",
				 "", *//***getInherentFunctionAdd***//*
				 "endosomolysis",
				 "Inherent Function Description",
				 "Save",
				 "",
			     "", *//****getFileAdd***//*
			     "", *//****getFileUpload***//*
			     "", *//****getFileEnterFileURL***//*
			     "", *//****getFileUploadBrowse***//*
			     "", *//****getFileEnterFileURLAddress***//*
			     "", *//****getFileType***//*
			     "", *//****getFileTitle***//*
			     "", *//****getFileKeywords***//*
			     "", *//****getFileDescription***//*
			     "", *//****getFileSaveOrCancel***//*
			     "", *//****getCopyToTheOtherSample ***//*
			     "Submit" *//****getSubmitOrReset ***//*
				 );*/
			Test.wait_For(5000);
			Test.navigate_to_sample_composition_chamical_association();
			Test.submit_a_sample_composition_chemical_association(
					"Association", /****getAssociationType***/
					"Test Submit Chemical Association", /****getDescription***/
					"nanomaterial entity", /****getElementSelectA***/
					"functionalizing entity", /****getElementSelectB***/
					"biopolymer", /****getEelementSelectAA***/
					"Magnetic Particle", /****getEelementSelectBB***/
					"coat (name: Acetaminophen)", /****getEelementSelectAAA***/
					"Add", /****getFileAdd***/
					"Upload", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"SamplesFile", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"image", /****getFileType***/
					"Test Sample Image", /****getFileTitle***/
					"Test Image", /****getFileKeywords***/
					"Test Image Description", /****getFileDescription***/
					"Save", /****getFileSaveOrCancel***/
					"Submit" /****getSubmitOrReset ***/
					);
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 228
	//Test Name: 005_Ensure Researcher User able to submit a Composition File to the sample 
	@Test
	public void ensureResearcherUserAbleToSubmitACompositionFileToTheSample() throws Exception {
		String testName = "005_Ensure Researcher User able to submit a Composition File to the sample";
		String testDesc = "Ensure Researcher User able to submit a Composition File to the sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Composition File As Researcher", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.wait_For(5000);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_file();
			Test.submit_a_sample_composition_file(
					"File", /****getFileAdd***/
					"Upload", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"SamplesFile", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"image", /****getFileType***/
					"Test Sample Image", /****getFileTitle***/
					"Test Image", /****getFileKeywords***/
					"Test Image Description", /****getFileDescription***/
					"Submit" /****getSubmitOrReset ***/
					);	
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//Password Reset

	//Removed in 2.2
	//S.N.: 229
	//Test Name: 001_Verify user able to reset password
	/*@Test
	public void verifyUserAbleToResetPassword() throws Exception {
		String testName = "001_Verify user able to reset password";
		String testDesc = "Verify user able to reset password"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Reset password");
			Test.reset_password("test_res", tier, "Reset Password");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}*/

	//Removed in 2.2
	//S.N.: 230
	//Test Name: 002_Verify user should not be able to reset password with the same password
	/*@Test
	public void verifyUserShouldNotBeAbleToResetPasswordWithTheSamePassword() throws Exception {
		String testName = "002_Verify user should not be able to reset password with the same password";
		String testDesc = "Verify user should not be able to reset password with the same password"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Reset password");
			Test.reset_password_with_same_pass("test_res", tier, "Reset Password");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}*/

	//Removed in 2.2
	//S.N.: 231
	//Test Name: 003_Verify reset password fields are required fields
	/*@Test
	public void verifyResetPasswordFieldsAreRequiredFields() throws Exception {
		String testName = "003_Verify reset password fields are required fields";
		String testDesc = "Verify reset password fields are required fields"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Reset password");
			Test.reset_password_fields_required("", tier, "Reset Password");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}*/

	//Removed in 2.2
	//S.N.: 232
	//Test Name: 004_Verify user unable to reset password without confirm new password
	/*@Test
	public void VerifyUserUnableToResetPasswordWithoutConfirmNewPassword() throws Exception {
		String testName = "004_Verify user unable to reset password without confirm new password";
		String testDesc = "Verify user unable to reset password without confirm new password"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Reset password");
			Test.reset_password_confirm_new_password("test_res", tier, "Reset Password");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}*/

	//Removed in 2.2
	//S.N.: 233
	//Test Name: 005_Verify new password field is required field when user try to reset password 
	/*@Test
	public void verifyNewPasswordFieldIsRequiredFieldWhenUserTryToResetPassword() throws Exception {
		String testName = "005_Verify new password field is required field when user try to reset password";
		String testDesc = "Verify new password field is required field when user try to reset password"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Reset password");
			Test.reset_password_new_password_field_required("test_res", tier, "Reset Password");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}*/

	//Removed in 2.2
	//S.N.: 234
	//Test Name: 006_Verify old password field is required field when user try to reset password 
	/*@Test
	public void verifyOldPasswordFieldIsRequiredFieldWhenUserTryToResetPassword() throws Exception {
		String testName = "006_Verify old password field is required field when user try to reset password";
		String testDesc = "Verify old password field is required field when user try to reset password"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Reset password");
			Test.reset_password_old_password_field_required("test_res", tier, "Reset Password");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}*/

	//Removed in 2.2
	//S.N.: 235
	//Test Name: 007_Verify Login ID field is required field when user try to reset password 
	/*@Test
	public void verifyLoginIDFieldIsRequiredFieldWhenUserTryToResetPassword() throws Exception {
		String testName = "007_Verify Login ID field is required field when user try to reset password";
		String testDesc = "Verify Login ID field is required field when user try to reset password"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Reset password");
			Test.reset_password_login_id_field_required("test_res", tier, "Reset Password");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}*/

	//S.N.: 236
	//Test Name: 008_Verify user unable to reset password if password requirement is not fulfill according to password policy  
	@Test
	public void verifyUserUnableToResetPasswordIfPasswordRequirementIsNotFulfillAccordingToPasswordPolicy() throws Exception {
		String testName = "008_Verify user unable to reset password if password requirement is not fulfill according to password policy";
		String testDesc = "Verify user unable to reset password if password requirement is not fulfill according to password policy"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Reset password");
			Test.reset_password_without_password_policy_unsuccessful("test_res", tier, "Reset Password");
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
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
	//@Test
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

	//Group

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
					"", /*** getUpload***/
					"", /***getUploadPath ***/ 
					"", /*** getEnterFileURL***/
					"", /*** getEnterFileURLPath***/
					"test sample test", /*** getSampleName***/
					"Add", /*** getAccessToThePublication***/
					"Collaboration", /***getAccessBy ***/
					"Researcher CaNano", /***getUserLoginName ***/
					"canano_res", /***getUserName ***/
					"READ WRITE DELETE", /*** getAccessToTheRole***/
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
			Test.wait_For(3000);
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
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
