package gov.nih.nci;

import static gov.nih.nci.HelperMethods.TestConstants.seleniumBrowser;
import static gov.nih.nci.HelperMethods.TestConstants.seleniumUrl;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import gov.nih.nci.HelperMethods.BaseNanoLabMethods;
import gov.nih.nci.HelperMethods.TestExecutionException;

public class TestSuiteB2
{
	private static Logger logger = Logger.getLogger("TestSuite");

	static BaseNanoLabMethods Test = new BaseNanoLabMethods();

	//S.N.: 51
	//Test Name: 009_verify_sample_search_by_characterization_type
	@Test
	public void SamplesSearchByCharacterization() throws Exception {
		String testName = "010_verify_sample_search_by_characterization";
		String testDesc = "Verify sample search by Characterization";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_simple("", "", "", "", "", "", "", "", "physico-chemical characterization", "molecular weight", "search");
			Test.wait_For(4000);
			//Test.sample_search_results_verification("(.*) items found, displaying 1 to 25.");
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

	//S.N.: 53
	//Test Name: 012_Verify_that_searching_for_non_public_sample_results_in_no_search_results_for_public_users
	@Test
	public void verifyThatSearchingForNonPublicSampleResultsInNoSearchResultsForPublicUsers() throws Exception {
		String testName = "012_Verify_that_searching_for_non_public_sample_results_in_no_search_results_for_public_users";
		String testDesc = "Verify that \"No search results\" is returned when a public user searches for a non-public sample."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_simple("", "equals", "SNL_UNM-CAshleyACSNano2012-25", "", "", "", "", "", "", "", "search");
			Test.wait_For(4000);
			Test.sample_search_error_verification();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}		
	}

	//S.N.: 54
	//Test Name: 012_Verify_that_searching_for_non_public_sample_results_in_no_search_results_for_public_users
	@Test
	public void SamplesSearchBySampleNameAndPOC() throws Exception {
		String testName = "013_verify_sample_search_by_combination_of_sample_name_and_sample_poc";
		String testDesc = "Verify complex sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_contains_search_by_sample_name("ncl");
			Test.samples_contains_search_by_sample_poc("ma");
			Test.submitSampleSearch();
			//Test.sample_search_results_verification("(.*) items found, displaying 1 to 25.");
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

	//S.N.: 55
	//Test Name: 014_Verify_the_ability_to_reset_the_sample_search_fields
	@Test
	public void verifyTheAbilityToResetSampleSearchCriteria() throws Exception {
		String testName = "014_Verify_the_ability_to_reset_the_sample_search_fields";
		String testDesc = "verify that the fields in the sample search page can be reset by clicking on reset button"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_simple("test", "equals", "NCL-23-1", "equals", "Devid", "carbon", "Monomer", "magnetic", "ex vivo", "imaging", "reset");
			Test.wait_For(4000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 56
	//Test Name: 001_Verify_that_publically_available_sample_details_summary_can_be_viewed
	@Test
	public void verifyThatPublicallyAvailableSampleDetailsSummaryCanBeViewed() throws Exception {
		String testName = "001_Verify_that_publically_available_sample_details_summary_can_be_viewed";
		String testDesc = "verify that the public user has the ability to view the sample details summary of publically available sample data";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_equals_search_by_sample_name("NCL-49-2");
			Test.submitSampleSearch();
			//Test.sample_search_results_verification("One item found.");
			Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			Test.view_sample_details_from_search_results_page("NCL-49-2");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}		
	}

	//S.N.: 57
	//Test Name: 002_Verify_that_Data_Availability_chart_of_publically_available_sample_can_be_viewed
	@Test
	public void verifyThatDataAvailabilityChartOfPublicallyAvailableSampleCanBeViewed() throws Exception {
		String testName = "002_Verify_that_Data_Availability_chart_of_publically_available_sample_can_be_viewed";
		String testDesc = "verify that a public user has the ability to view the Data Availabiity chart of a publically available sample";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_equals_search_by_sample_name("NCL-49-2");
			Test.submitSampleSearch();
			Test.sample_search_results_verification();
			Test.view_data_availability_chart_from_sample_search_results_page("NCL-49-2", "caNanoLab Availability Score:");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}		
	}

	//S.N.: 59
	//Test Name: 015_verify_that_clicking_on_public_results_from_home_page_returns_sample_search_results_for_all_public_samples
	@Test
	public void verifyClickingOnPublicResultsLinkAgainstSampleSearchesFromHomePageReturnsAllPublicallyAvailableSamples() throws Exception {
		String testName = "015_verify_that_clicking_on_public_results_from_home_page_returns_sample_search_results_for_all_public_samples";
		String testDesc = "Verify that clicking on 997 link on the Home page in \"Public Results\" column against the Search Samples in Browse cananoLab section returns all publically available samples results";
		try{	 
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_public_sample_search_results_from_browseCananoLabSection();
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

	// Publication >> Search for Samples by Publication

	//S.N.: 60
	//Test Name: 001_Verify_sample_search_by_publication_PubMed_ID
	@Test
	public void verifySampleSearchByPublicationPubMedID() throws Exception {
		String testName = "001_Verify_sample_search_by_publication_PubMed_ID";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by PubMed ID"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.wait_For(3000);
			Test.Verify_sample_search_by_publication_PubMed_ID("17278104", "PubMed ID: 17278104");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 61
	//Test Name: 002_Verify_sample_search_by_publication_DOI
	@Test
	public void verifySampleSearchByPublicationDOI() throws Exception {
		String testName = "002_Verify_sample_search_by_publication_DOI";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by DOI"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.wait_For(3000);
			Test.Verify_sample_search_by_publication_DOI("10.1002%2Fijc.22581", "DOI Id: 10.1002/ijc.22581");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}


	//Publication >> Search Publication

	//S.N.: 66
	//Test Name: 001_Verify_publication_search_by_keyword
	@Test
	public void verifyPublicationSearchByKeyword() throws Exception {
		String testName = "001_Verify_publication_search_by_keyword";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Keyword";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_keyword("test");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 67
	//Test Name: 002_Verify_publication_search_by_Publication_Type
	@Test
	public void verifyPublicationSearchByPublicationType() throws Exception {
		String testName = "002_Verify_publication_search_by_Publication_Type";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Publication Type"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Publication_Type();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 68
	//Test Name: 003_Verify_publication_search_by_Research_Category
	@Test
	public void verifyPublicationSearchByResearchCategory() throws Exception {
		String testName = "003_Verify_publication_search_by_Research_Category";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Reasearch Category"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Research_Category();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 69
	//Test Name: 004_Verify_publication_search_by_PubMed_ID
	@Test
	public void verifyPublicationSearchByPubMedID() throws Exception {
		String testName = "004_Verify_publication_search_by_PubMed_ID";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by PubMedID";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.test_004_Verify_publication_search_by_PubMed_ID("17278104");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 70
	//Test Name: 005_Verify_publication_search_by_Digital_Object_ID
	@Test
	public void verifyPublicationSearchByDigitalObjectID() throws Exception {
		String testName = "005_Verify_publication_search_by_Digital_Object_ID";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by digital object ID"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Digital_Object_ID("10.1002/ijc.22581");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 71
	//Test Name: 006_Verify_publication_contains_search_by_Publication_Title
	@Test
	public void VerifyPublicationContainsSearchbyPublicationTitle() throws Exception {
		String testName = "006_Verify_publication_contains_search_by_Publication_Title";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by publication title as contains search";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_contains_search_by_Publication_Title("The PeptideAtlas project.");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 72
	//Test Name: 006_Verify_publication_contains_search_by_Publication_Title
	@Test
	public void VerifyPublicationEqualsSearchByPublicationTitle() throws Exception {
		String testName = "007_Verify_publication_equals_search_by_Publication_Title";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by publication title as equals search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_equals_search_by_Publication_Title("equals", "The PeptideAtlas project.");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}	

	//S.N.: 73
	//Test Name: 008_Verify_publication_search_by_Authors
	@Test
	public void VerifyPublicationSearchByAuthors() throws Exception {
		String testName = "008_Verify_publication_search_by_Authors";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Authors"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Authors("Agata");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}	

	//S.N.: 74
	//Test Name: 009_Verify_publication_search_by_Sample_Name_contains
	@Test
	public void verifyPublicationSearchBySampleNameContains() throws Exception {
		String testName = "009_Verify_publication_search_by_Sample_Name_contains";
		String testDesc = "Verify publication search by Sample Name as contains";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Sample_Name_option("TEST", "contains");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}	

	//S.N.: 75
	//Test Name: 010_Verify_publication_search_by_Sample_Name_equals
	@Test
	public void verifyPublicationSearchBySampleNameEquals() throws Exception {
		String testName = "010_Verify_publication_search_by_Sample_Name_equals";
		String testDesc = "Verify publication search by Sample Name as equals"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Sample_Name_option("TEST-TL2009-01", "equals");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 76
	//Test Name: 011_Verify_publication_search_by_Composition_Nanomaterial_Entity
	@Test
	public void verifyPublicationSearchByCompositionNanomaterialEntity_1() throws Exception {
		String testName = "011_Verify_publication_search_by_Composition_Nanomaterial_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Nanomaterial_Entity("biopolymer");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 77
	//Test Name: 011_Verify_publication_search_by_Composition_Nanomaterial_Entity
	@Test
	public void verifyPublicationSearchByCompositionNanomaterialEntity_2() throws Exception {
		String testName = "011_Verify_publication_search_by_Composition_Nanomaterial_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Nanomaterial_Entity("carbon");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 78
	//Test Name: 011_Verify_publication_search_by_Composition_Nanomaterial_Entity
	@Test
	public void verifyPublicationSearchByCompositionNanomaterialEntity_3() throws Exception {
		String testName = "011_Verify_publication_search_by_Composition_Nanomaterial_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Nanomaterial_Entity("carbon black");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 79
	//Test Name: 011_Verify_publication_search_by_Composition_Nanomaterial_Entity
	@Test
	public void verifyPublicationSearchByCompositionNanomaterialEntity_4() throws Exception {
		String testName = "011_Verify_publication_search_by_Composition_Nanomaterial_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Nanomaterial_Entity("carbon nanotube");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 80
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void verifyPublicationSearchByCompositionFunctionalizingEntity_1() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("Magnetic Particle");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 81
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void verifyPublicationSearchByCompositionFunctionalizingEntity_2() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("Monomer");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 82
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void verifyPublicationSearchByCompositionFunctionalizingEntity_3() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("Polymer");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 83
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void verifyPublicationSearchByCompositionFunctionalizingEntity_4() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("Quantum Dot");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 84
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void verifyPublicationSearchByCompositionFunctionalizingEntity_5() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("antibody");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 85
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void verifyPublicationSearchByCompositionFunctionalizingEntity_6() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("biopolymer");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 86
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void verifyPublicationSearchByCompositionFunctionalizingEntity_7() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("radioisotope");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 87
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void verifyPublicationSearchByCompositionFunctionalizingEntity_8() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("small molecule");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 88
	//Test Name: 013_Verify_publication_search_by_Function
	@Test
	public void verifyPublicationSearchByFunction_1() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publicly available data");
			Test.Verify_publication_search_by_Function("endosomolysis");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 89
	//Test Name: 013_Verify_publication_search_by_Function
	@Test
	public void verifyPublicationSearchByFunction_2() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publicly available data");
			Test.Verify_publication_search_by_Function("imaging function");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 90
	//Test Name: 013_Verify_publication_search_by_Function
	@Test
	public void verifyPublicationSearchByFunction_3() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publicly available data");
			Test.Verify_publication_search_by_Function("other");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 91
	//Test Name: 013_Verify_publication_search_by_Function
	@Test
	public void verifyPublicationSearchByFunction_4() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publicly available data");
			Test.Verify_publication_search_by_Function("targeting function");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 92
	//Test Name: 013_Verify_publication_search_by_Function
	@Test
	public void verifyPublicationSearchByFunction_5() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publicly available data");
			Test.Verify_publication_search_by_Function("therapeutic function");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 93
	//Test Name: 013_Verify_publication_search_by_Function
	@Test
	public void verifyPublicationSearchByFunction_6() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.Verify_publication_search_by_Function("transfection");
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
	public void tearDownAfterEachTest()
	{
		
	}

}
