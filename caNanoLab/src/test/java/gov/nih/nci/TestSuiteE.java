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
			Test.publication_search("", "", "", "", "contains", "doped nanoshells", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("doped nanoshells", "yes", "view");
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
			Test.publication_search("", "", "", "", "contains", "doped nanoshells", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("doped nanoshells ", "yes", "edit");
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
	//@Test
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
			Test.navigate_to_sample_composition_functionalizing_entity();
			Test.submit_a_sample_composition_functionalizing(
				 "Magnetic Particle", /***getFunctionalizingEntityType**/
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
