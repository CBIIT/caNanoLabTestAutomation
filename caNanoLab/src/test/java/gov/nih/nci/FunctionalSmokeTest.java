package gov.nih.nci;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.internal.seleniumemulation.Click;

import gov.nih.nci.HelperMethods.BaseTestMethods;
import gov.nih.nci.HelperMethods.BaseNanoLabMethods;

import org.junit.*;
import org.apache.log4j.Logger;
import static gov.nih.nci.HelperMethods.TestConstants.*;

public class FunctionalSmokeTest
{
	private static Logger logger = Logger.getLogger("TestSuite");

	static BaseNanoLabMethods Test = new BaseNanoLabMethods();
	
	private String seleniumBrowser;	//firefox
	private String hostName;	//https://cananolab-qa.nci.nih.gov";
	public String seleniumUrl;	
	
	public FunctionalSmokeTest(){
		BaseTestMethods.appRelease = "cananoLab v2.2";
		BaseTestMethods.releaseDesc = "Welcome to the cancer Nanotechnology Laboratory (caNanoLab) portal.";
	}	


	//S.N.: 1
	//Test Name: 003_Login_as_Researcher
	@Test
	public void researcherLoginTest() throws Exception{
		String testName = "003_Login_as_Researcher";
		String testDesc = "Login to caNanoLab with a valid researcher account";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.logout();
			logger.info("---------------End of Test " + testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch (Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}
	}

	//S.N.: 2
	//Test Name: 002_Login_as_Curator
	@Test
	public void curatorLoginTest() throws Exception{
		String testName = "002_Login_as_Curator";
		String testDesc = "Login to caNanoLab with a valid curator account"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.logout();
			logger.info("---------------End of Test " + testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();	
		}catch (Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();				
		}
	}

	//S.N.: 4
	//Test Name: 005_Verify_Invalid_password
	@Test
	public void invalidPasswordTest() throws Exception {
		String testName = "005_Verify_Invalid_password";
		String testDesc = "Login to caNanoLab with a invalid password"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, "invalidpwd","fail");
			logger.info("---------------End of Test " + testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();	
		}catch (Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();				
		}		
	}	

	//S.N.: 6
	//Test Name: 013_Verify_caNanoLab_How_To_section_content
	@Test
	public void  verifycaNanoLabHowToSectionContent() throws Exception{
		String testName = "013_Verify_caNanoLab_How_To_section_content";
		String testDesc = "Verify caNanoLab 'How To' section content"; 
		logger.info("---------------Begin Test case: " + testName + "--------------");
		try{
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyLinkOnThePage(By.linkText(applinkHowDoISubmitData));
			Test.clickLink(By.linkText(applinkHowDoISubmitData));
			Test.switchToChildBrowser();
			Test.wait_For(1000);
			Test.expected_vs_actual_verification("caNanoLab FAQ");
			Test.switchToParentBrowser();
			Test.goAppLoginPage();
			Test.verifyLinkOnThePage(By.linkText(applinkHowDoIFindNanotechnologyProtocols));
			Test.clickLink(By.linkText(applinkHowDoIFindNanotechnologyProtocols));
			Test.wait_For(1000);
			Test.expected_vs_actual_verification("SearchProtocols");
			Test.goAppLoginPage();
			Test.verifyLinkOnThePage(By.linkText(applinkHowDoIFindNanotechnologyPublications));
			Test.clickLink(By.linkText(applinkHowDoIFindNanotechnologyPublications));
			Test.wait_For(1000);
			Test.expected_vs_actual_verification("SearchPublications");
			Test.goAppLoginPage();
			Test.verifyLinkOnThePage(By.linkText(applinkHowCanISearchForNanomaterials));
			Test.clickLink(By.linkText(applinkHowCanISearchForNanomaterials));
			Test.wait_For(1000);
			Test.expected_vs_actual_verification("Sample Search");
			Test.goAppLoginPage();
			Test.verifyLinkOnThePage(By.linkText(applinkHowCanISearchForNanomaterialsCharacterizations));
			Test.clickLink(By.linkText(applinkHowCanISearchForNanomaterialsCharacterizations));
			Test.wait_For(1000);
			Test.expected_vs_actual_verification("Sample Search");
			Test.goAppLoginPage();
			Test.verifyLinkOnThePage(By.linkText(applinkHowCanIGetDefinitionsFor));
			Test.clickLink(By.linkText(applinkHowCanIGetDefinitionsFor));
			Test.switchToChildBrowser();
			Test.wait_For(1000);
			Test.expected_vs_actual_verification("caNanoLab");
			Test.switchToParentBrowser();
			logger.info("---------------End of Test " + testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();						
		}catch (Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();				
		}
	}

	//S.N.: 7
	//Test Name: 015_Verify_caNanoLab_Browse_cananoLab_section_content
	@Test
	public void verifyBrowseCaNanoLabSectionContent() throws Exception {
		String testName = "015_Verify_caNanoLab_Browse_cananoLab_section_content";
		String testDesc = "Verify caNanoLab 'Browse caNanoLab' section content";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.Verify_caNanoLab_Browse_cananoLab_section_content("Search Protocols", "Search Samples", "Search Publications");
			logger.info("---------------End of Test " + testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();				
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();				
		}
	}

	//S.N.: 8
	//Test Name: 014_Verify_caNanoLab_Whats_New_section_content
	@Test
	public void verifyWhatsNewSectionContent_downloadLink() throws Exception {
		String testName = "014_Verify_caNanoLab_Whats_New_section_content_downloadLink";
		String testDesc = "Verify caNanoLab 'What's New' section content";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("download"), "caNanoLab Wiki Home Page");
			logger.info("---------------End of Test " + testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();				
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();			
		}
	}

	//S.N.: 9
	//Test Name: 014_Verify_caNanoLab_Whats_New_section_content
	@Test
	public void verifyWhatsNewSectionContent_releaseNotesLink() throws Exception {
		String testName = "014_Verify_caNanoLab_Whats New_section_content_releaseNotesLink";
		String testDesc = "Verify caNanoLab 'What's New' section content";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("caNanoLab Release Notes"), "caNanoLab 1.5.5 Release Note");
			logger.info("---------------End of Test " + testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();				
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();
		}
	}

	//S.N.: 10
	//Test Name: 014_Verify_caNanoLab_Whats_New_section_content
	@Test
	public void verifyHomePageWelcomeContent() throws Exception {
		String testName = "011_Verify_Home_page_Welcome_Content";
		String testDesc = "Verification of the Welcome text on the Home page";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyWelcomeContent("Welcome to the cancer Nanotechnology Laboratory (caNanoLab) portal. caNanoLab is a data sharing portal designed to facilitate information sharing across the international biomedical nanotechnology research community to expedite and validate the use of nanotechnology in biomedicine. caNanoLab provides support for the annotation of nanomaterials with characterizations resulting from physico-chemical, in vitro and in vivo assays and the sharing of these characterizations and associated nanotechnology protocols in a secure fashion.","Home");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}
	}

	//S.N.: 11
	//Test Name: 001_Verify_Option_Browse_publically_available_Data
	@Test
	public void verifyOptions_BrowsePublicallyAvailabledata() throws Exception {
		String testName = "001_Verify_Option_Browse_publically_available_Data";
		String testDesc = "Verification of the 'Browse publically available data' option";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//REmoved in 2.2
			//Test.chooseLoginOptions("Browse publically available data");
			Test.verifyPage(By.cssSelector(".contentTitle>tbody>tr>th"),"Sample Search");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 12
	//Test Name: 002_Verify_Option_Login_to_submit_data
	@Test
	public void verifyOptions_LoginToSubmitData() throws Exception {
		String testName = "002_Verify_Option_Login_to_submit_data";
		String testDesc = "Verification of the 'Login to submit data' option"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Removed in 2.2
			//Test.chooseLoginOptions("Login to submit data");
			Test.actual_with_expected_css_text_verification("No account is required to browse publicly available data.", appCSSUserActions);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 13
	//Test Name: 003_Verify_Option_Register_for_login_account
	@Test
	public void verifyOptions_RegisterForLoginAccount() throws Exception {
		String testName = "003_Verify_Option_Register_for_login_account";
		String testDesc = "Verification of the 'Register for a login account' option";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Removed in 2.2
			//Test.chooseLoginOptions("Register for a login account");
			Test.actual_with_expected_css_text_verification("User Registration Help Glossary", "table.contentTitle");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 15
	//Test Name: 007_Verify_caNanoLab_Feature_section_content
	@Test
	public void verifyFeatureSectionContent () throws Exception {
		String testName = "007_Verify_caNanoLab_Feature_section_content";
		String testDesc = "Verification of the Feature section content";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			String featuresSection = "caNanoLab provides access to information on:Nanotechnology ProtocolsNanomaterial CompositionNanomaterial Characterizations (physic-chemical, in vitro, in vivo)Nanomaterial PublicationsFor additional information, see the caNanoLab FAQ or Online Help";
			Test.actual_with_expected_xpath_text_verification(featuresSection, "//td[2]/table/tbody/tr[5]/td");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 20
	//Test Name: 010_Verify_Help_pages(1)
	@Test
	public void verifyHelpPage() throws Exception{
		String testName = "010_Verify_Help_pages(1)";
		String testDesc = "Verify if Help pages are functioning correctly."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("HELP"), "caNanoLab User's Guide");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();
		}		
	}

	//S.N.: 21
	//Test Name: 010_Verify_Help_pages(2)
	@Test
	public void verifyContextSensitiveHelpPage() throws Exception{
		String testName = "010_Verify_Help_pages(2)";
		String testDesc = "Verify if contextual Help pages are functioning correctly."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//REmoved in 2.2
			//Test.chooseLoginOptions("Register for a login account");
			Test.click_go();
			Test.verifyPopupPage(By.linkText("Help"), "Wiki");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//Related Links Verifications
	//NCI

	//S.N.: 22
	//Test Name: 006_Verify_additional_nci_links_to_quick_links_section_caNanoLabWiki
	@Test
	public void verifyAdditionalNCILinks_caNanoLabWiki() throws Exception{
		String testName = "006_Verify_additional_nci_links_to_quick_links_section_caNanoLabWiki";
		String testDesc = "Verify NCI link 'caNanoLab Wiki' is displayed in the Quick Links section.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("caNanoLab Wiki"), "caNanoLab Wiki Home Page");
			Test.verifyUrlWithSessionID("https://wiki.nci.nih.gov/display/caNanoLab/caNanoLab+Wiki+Home+Page");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 23
	//Test Name: 006_Verify_additional_nci_links_to_quick_links_section_NCICBIITHome
	@Test
	public void verifyAdditionalNCILinks_NCICBIITHome() throws Exception{
		String testName = "006_Verify_additional_nci_links_to_quick_links_section_NCICBIITHome";
		String testDesc = "Verify NCI link 'NCI CBIIT Home' is displayed in the Quick Links section."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("NCI CBIIT Home"), "National Cancer Informatics Program (NCIP)");
			Test.verifyUrl("https://cbiit.nci.nih.gov/");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 24
	//Test Name: 006_Verify_additional_nci_links_to_quick_links_section_NCLHome
	@Test
	public void verifyAdditionalNCILinks_NCLHome() throws Exception{
		String testName = "006_Verify_additional_nci_links_to_quick_links_section_NCLHome";
		String testDesc = "Verify NCI link 'NCL Home' is displayed in the Quick Links section."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("NCL Home"), "Nanotechnology Characterization Lab");
			Test.verifyUrl("https://nanolab.cancer.gov/");
			Test.switchToParentBrowser();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 25
	//Test Name: 006_Verify_additional_nci_links_to_quick_links_section_NCLCSNHome
	//Link removed in 2.2
	//@Test
	public void verifyAdditionalNCILinks_NCLCSNHome() throws Exception{
		String testName = "006_Verify_additional_nci_links_to_quick_links_section_NCLCSNHome";
		String testDesc = "Verify NCI link 'NCL CSN Home' is displayed in the Quick Links section.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("NCL CSN Home"), "HOME");
			Test.verifyUrl("http://uqbar.ncifcrf.gov/Advanced_Structure_Analysis/HOME.html");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 27
	//Test Name: 006_Verify_additional_nci_links_to_quick_links_section_NCIHome
	@Test
	public void verifyAdditionalNCILinks_NCIHome() throws Exception{
		String testName = "006_Verify_additional_nci_links_to_quick_links_section_NCIHome";
		String testDesc = "Verify NCI link 'NCI Home' is displayed in the Quick Links section."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("NCI Home"), "Cancer Currents Blog");
			Test.verifyUrl("https://www.cancer.gov/");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 28
	//Test Name: 006_Verify_additional_nci_links_to_quick_links_section_NanotechnologyWorkingGroup
	@Test
	public void verifyAdditionalNCILinks_NanotechnologyWorkingGroup() throws Exception{
		String testName = "006_Verify_additional_nci_links_to_quick_links_section_NanotechnologyWorkingGroup";
		String testDesc = "Verify additonal NCI link 'Nanotechnology Working Group' is displayed in the Quick Links section.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("Nanotechnology Working Group"), "Nanotechnology Working Group");
			Test.verifyUrl("https://wiki.nci.nih.gov/display/ICR/Nanotechnology+Working+Group");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 29
	//Test Name: 006_Verify_additional_nci_links_to_quick_links_section_NanoHubs
	@Test
	public void verifyAdditionalNCILinks_NanoHubs() throws Exception{
		String testName = "006_Verify_additional_nci_links_to_quick_links_section_NanoHubs";
		String testDesc = "Verify additonal NCI link 'Nano Hubs' is displayed in the Quick Links section.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("NCIP HUB"), "caNanoLab Curation");
			Test.verifyUrl("https://nciphub.org/groups/cananolabcuration");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//Related Links Verifications
	//External

	//S.N.: 30
	//Test Name: 006_Verify_additional_external_links_to_quick_links_section_Disclaimer
	@Test
	public void verifyAdditionalExternalLinks_Disclaimer() throws Exception{
		String testName = "006_Verify_additional_external_links_to_quick_links_section_Disclaimer";
		String testDesc = "Verify additonal external link 'Disclaimer' is displayed in the Quick Links section.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText(applinkDisclaimer), "LEGAL RULES OF THE ROAD");
			Test.verifyUrl(hostName+"/caNanoLab/html/cananoDisclaimer.html");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 31
	//Test Name: 006_Verify_additional_external_links_to_quick_links_section_NBI
	@Test
	public void verifyAdditionalExternalLinks_NBI() throws Exception{
		String testName = "006_Verify_additional_external_links_to_quick_links_section_NBI";
		String testDesc = "Verify additonal external link 'NBI' is displayed in the Quick Links section.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("NBI"), "Welcome to the Nanomaterial-Biological Interactions Knowledgebase!");
			Test.verifyUrl("http://nbi.oregonstate.edu/");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 32
	//Test Name: 006_Verify_additional_external_links_to_quick_links_section_NIOSHNIL
	@Test
	public void verifyAdditionalExternalLinks_NIOSHNIL() throws Exception{
		String testName = "006_Verify_additional_external_links_to_quick_links_section_NIOSHNIL";
		String testDesc = "Verify additonal external link 'NIOSH NIL' is displayed in the Quick Links section."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("NIOSH NIL"), "Nanoparticle Information Library (NIL)");
			Test.verifyUrl("http://nanoparticlelibrary.net/index.asp");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 33
	//Test Name: 006_Verify_additional_external_links_to_quick_links_section_InterNano
	@Test
	public void verifyAdditionalExternalLinks_InterNano() throws Exception{
		String testName = "006_Verify_additional_external_links_to_quick_links_section_InterNano";
		String testDesc = "Verify additonal external link 'InterNano' is displayed in the Quick Links section."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("InterNano"), "What is Nanomanufacturing?");
			Test.verifyUrl("http://www.internano.org/");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 34
	//Test Name: 006_Verify_additional_external_links_to_quick_links_section_nanoHUB
	@Test
	public void verifyAdditionalExternalLinks_nanoHUB() throws Exception{
		String testName = "006_Verify_additional_external_links_to_quick_links_section_nanoHUB";
		String testDesc = "Verify additonal external link 'nanoHUB' is displayed in the Quick Links section."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("nanoHUB"), "nanoHUB.org - Home");
			Test.verifyUrl("http://nanohub.org/home");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 35
	//Test Name: 006_Verify_additional_external_links_to_quick_links_section_ICON
	@Test
	public void verifyAdditionalExternalLinks_ICON() throws Exception{
		String testName = "006_Verify_additional_external_links_to_quick_links_section_ICON";
		String testDesc = "Verify additonal external link 'ICON' is displayed in the Quick Links section."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("ICON"), "Our current and prospective industrial partners have strongly encouraged us to go beyond the traditional structures of an industrial affiliates ");
			Test.verifyUrl("http://cben.rice.edu/industry/icon.aspx");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 36
	//Test Name: 006_Verify_additional_external_links_to_quick_links_section_SAFENANO
	@Test
	public void verifyAdditionalExternalLinks_SAFENANO() throws Exception{
		String testName = "006_Verify_additional_external_links_to_quick_links_section_SAFENANO";
		String testDesc = "Verify additonal external link 'SAFENANO' is displayed in the Quick Links section."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("SAFENANO"), "SAFENANO");
			Test.verifyUrl("http://www.safenano.org/");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 37
	//Test Name: 006_Verify_additional_external_links_to_quick_links_section_SAFENANO
	@Test
	public void verifyAdditionalExternalLinks_8() throws Exception{
		String testName = "006_Verify_additional_external_links_to_quick_links_section_8";
		String testDesc = "Verify additonal external link 'OECD' is displayed in the Quick Links section."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("OECD"), "STInano - OECD");
			Test.verifyUrl("https://www.oecd.org/sti/nano/");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 38
	//Test Name: 006_Verify_additional_external_links_to_quick_links_section_SAFENANO
	@Test
	public void verifyAdditionalExternalLinks_eNanoMapper() throws Exception{
		String testName = "006_Verify_additional_external_links_to_quick_links_section_eNanoMapper";
		String testDesc = "Verify additonal external link 'eNanoMapper' is displayed in the Quick Links section."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("eNanoMapper"), "");
			Test.verifyElementOnThePage(By.cssSelector("img[alt=\"Home\"]"));
			Test.verifyUrl("https://enanomapper.net/");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//S.N.: 39
	//Test Name: 006_Verify_additional_external_links_to_quick_links_section_NanomaterialRegsitry
	@Test
	public void verifyAdditionalExternalLinks_NanomaterialRegsitry() throws Exception{
		String testName = "006_Verify_additional_external_links_to_quick_links_section_NanomaterialRegsitry";
		String testDesc = "Verify additonal external link 'Nanomaterial Regsitry' is displayed in the Quick Links section.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("Nanomaterial Registry"), "Nanomaterial Registry");
			Test.verifyUrl("https://www.nanomaterialregistry.org/");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}

	//Application Functional verification

	//S.N.: 40
	//Test Name: 010_Verify_login_splash_screen_text
	@Test
	public void loginSplashScreenTextVerification() throws Exception {
		String testName = "010_Verify_login_splash_screen_text";
		String testDesc = "Verification of the Welcome text on the login splash screen"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword,"pass");
			Test.verifyWelcomeContent(appWelcomeMessage,"LoginSplashScreen");
			Test.logout();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}	

	//S.N.: 41
	//Test Name: 007_Verify_user_session_is_lost_when_browser_window_is_closed
	@Test
	public void verifyUserSessionIsLostWhenBrowserWindowIsClosed() throws Exception {
		String testName = "007_Verify_user_session_is_lost_when_browser_window_is_closed";
		String testDesc = "Verify that user session is lost when browser window is closed.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyUserSession(researcherUserName, researcherPassword, seleniumBrowser);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}	

	//S.N.: 42
	//Test Name: 001_Verify_sample_search_by_keyword
	@Test
	public void SamplesSearchByKeyword() throws Exception {
		String testName = "001_Verify_sample_search_by_keyword";
		String testDesc = "verify sample search by keyword"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(3000);
			//Options no longer available since 2.2
			//Test.chooseLoginOptions("Browse publicly available data");
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_simple("GLIOBLASTOMA MULTIFORME", "", "", "", "", "", "", "", "", "", "search");
			Test.wait_For(2000);
			Test.verify_sample_search_results("Sample Search Results", 2);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}

	//S.N.: 43
	//Test Name: 002_verify_sample_contains_search_by_sample_name
	/*	@Test
	public void SamplesContainsSearchBySampleName() throws Exception {
		String testName = "002_verify_sample_contains_search_by_sample_name";
		String testDesc = "Verify sample contains search by Sample name"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_simple("NCL", "contains", "", "", "", "", "", "", "", "", "search");
			Test.verify_sample_search_results("Sample Search Results", 1);
			Test.click_next_result_page_until("NCL-23");
			Test.verify_sample_name_contains_from_search_results_page("NCL-23");
			//Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
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
			Test.chooseLoginOptions("Browse publically available data");
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
	 */
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

	@Before
	public void setup()
	{
		seleniumBrowser = System.getProperty(BROWSER);
		hostName = System.getProperty(HOST_NAME);
		seleniumUrl = hostName + "/caNanoLab/";
	}

	@After
	public void tearDown() throws Exception {
		Test.shutdown();
	}
}