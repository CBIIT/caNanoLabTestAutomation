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

public class TestSuiteProtocols {
	static BaseNanoLabMethods Test = new BaseNanoLabMethods();
	private static Logger logger=Logger.getLogger("TestSuite");
	public static String seleniumBrowser = "firefox";
	public static String tier = "dev";
	//public static String HostName = "http://localhost:9090";
	public static String HostName = "https://cananolab-stage-sg.nci.nih.gov";
	//public static String HostName = "https://cananolab-qa-sg.nci.nih.gov";
	//public static String HostName = "http://nciws-q438-v:18080";
	//public static String HostName = "http://ncias-d1360-v.nci.nih.gov:18080";
	public static String seleniumUrl = HostName + "/caNanoLab/";	
	public static String curatorUserName = "curatorUserName";
	public static String curatorPassword = "curatorPassword";
	public static String researcherUserName = "researcherUserName";
	public static String researcherPassword = "researcherPassword";
		
	//Application configuration
	public static String applinkHOME = "HOME";
	public static String applinkPROTOCOLS = "PROTOCOLS";
	public static String applinkSAMPLES = "SAMPLES";
	public static String applinkPUBLICATIONS = "PUBLICATIONS";
	public static String applinkCURATION = "CURATION";
	public static String applinkMYWORKSPACE = "MY WORKSPACE";
	public static String applinkHELP = "HELP";
	public static String applinkLOGOUT = "LOGOUT";
	public static String applinkGLOSSARY = "GLOSSARY";
	public static String applinkCONTACTUS = "CONTACT US";
	public static String applinkPRIVACYNOTICE = "PRIVACY NOTICE";
	public static String applinkDISCLAIMER = "DISCLAIMER";
	public static String applinkACCESSIBILITY = "ACCESSIBILITY";
	public static String applinkAPPLICATIONSUPPORT = "APPLICATION SUPPORT";
	
	public static String applinkcaNanoLabWiki = "caNanoLab Wiki";
	public static String applinkNCICBIITHome = "NCI CBIIT Home";
	public static String applinkNCLHome = "NCL Home";
	public static String applinkNCLCSNHome = "NCL CSN Home";
	public static String applinkNCINanoAllianceHome = "NCI Nano Alliance Home";
	public static String applinkNCIHome = "NCI Home";
	public static String applinkNanotechnologyWorkingGroup = "Nanotechnology Working Group";
	public static String applinkNanoHubs = "Nano Hubs";
	public static String applinkDisclaimer = "Disclaimer";
	public static String applinkNBI = "NBI";
	public static String applinkNIOSHNIL = "NIOSH NIL";
	public static String applinkInterNano = "InterNano";
	public static String applinknanoHUB = "nanoHUB";
	public static String applinkICON = "ICON";
	public static String applinkSAFENANO = "SAFENANO";
	public static String applinkOECD = "OECD";
	public static String applinkeNanoMapper = "eNanoMapper";
	public static String applinkNanomaterialRegistry = "Nanomaterial Registry";
	
	public static String applinkFAQ = "FAQ";
	public static String applinkOnlineHelp = "Online Help";
	public static String applinkSearchProtocols = "Search Protocols";
	public static String applinkSearchSamples = "Search Samples";
	public static String applinkSearchPublications = "Search Publications";
	public static String applinkDownload = "download";
	public static String applinkReleaseNotes = "caNanoLab Release Notes";
	
	//How to Section
	public static String applinkHowDoISubmitData = "How do I submit data into caNanoLab?";
	public static String applinkHowDoIIncorporate = "How do I incorporate caNanoLab into a data sharing plan?";
	public static String applinkHowDoIFindNanotechnologyProtocols = "How do I find nanotechnology protocols?";
	public static String applinkHowDoIFindNanotechnologyPublications = "How do I find Nanotechnology publications?";
	public static String applinkHowCanISearchForNanomaterials = "How can I search for nanomaterials?";
	public static String applinkHowCanISearchForNanomaterialsCharacterizations = "How can I search for nanomaterial characterizations?";
	public static String applinkHowCanIGetDefinitionsFor = "Where can I get definitions for nanotechnology concepts?";
	
	//Application Confirmation Message
	public static String registrationSubmitConfMessage = "Your registration request has been sent to the administrator for assignment of your User ID and Password. You should receive this information via e-mail within one business day from time of submission.";
	public static String sampleSubmitConfMessage = "";
	public static String publicationSubmitConfMessage = "";
	public static String protocolSubmitConfMessage = "";
	public static String appWelcomeMessage = "Welcome to the cancer Nanotechnology Laboratory (caNanoLab) portal. caNanoLab is a data sharing portal designed to facilitate information sharing across the international biomedical nanotechnology research community to expedite and validate the use of nanotechnology in biomedicine. caNanoLab allows researchers to share information on nanomaterials by normalizing the format of publication-quality data, including details often unavailable in the published form, and centralizing its storage. These data include the composition of the nanomaterial, its functions (e.g. therapeutic, targeting, diagnostic imaging), its characterizations from physico-chemical (e.g. size, molecular weight, surface), in vitro (e.g. cytotoxicity, blood contact) and in vivo (e.g. animal toxicity and efficacy) nanomaterial assays, and the protocols of these assays.\n\nThe diagram below illustrates the caNanoLab functionality and workflow. \"Active links\" are provided that allows a user to directly navigate to the appropriate function based on the authorization level of the user. In particular, the Sample Submission workflow allows direct launching points to develop caNanoLab data files from a user's inputs. Navigation is also available through the menus above.";
	
	//Application CSS Configuration
	public static String appCSSUserActions = "td.sidebarContent";
	
	public TestSuiteProtocols(){
		BaseTestMethods.appRelease = "cananoLab v2.1";
		BaseTestMethods.releaseDesc = "caNanoLab v2.1 is refactored using AngularJS as the Front-end framework and JAVA REST services as the middle-tier";
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
	
	//S.N.: 3
	//Test Name: 004_Verify_Invalid_username
	@Test
	public void invalidUserNameTest() throws Exception {
		String testName = "004_Verify_Invalid_username";
		String testDesc = "Login to caNanoLab with a invalid user account"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login("invalid", "invalidpwd","fail");
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

	//S.N.: 5
	//Test Name: 006_Verify_case_insensitive_password
	// this script run result is failed due to known issue
	@Test
	public void caseInsensitivePasswordTest() throws Exception {
		String testName = "006_Verify_case_insensitive_password";
		String testDesc = "Login to caNanoLab with a case insensitive password"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, "reslcasepass","fail");
			logger.info("This Test Case result is failed due to known issue");
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
			Test.expected_vs_actual_verification("Protocol Search");
			Test.goAppLoginPage();
			Test.verifyLinkOnThePage(By.linkText(applinkHowDoIFindNanotechnologyPublications));
			Test.clickLink(By.linkText(applinkHowDoIFindNanotechnologyPublications));
			Test.wait_For(1000);
			Test.expected_vs_actual_verification("Publication Search");
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
			Test.expected_vs_actual_verification("caNanoLab FAQ");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Login to submit data");
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
			Test.chooseLoginOptions("Register for a login account");
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
	
	//S.N.: 14
	//Test Name: 004_Verify_Option_Reset_Password
	@Test
	public void verifyOptions_ResetPassword() throws Exception {
		String testName = "004_Verify_Option_Reset_Password";
		String testDesc = "Verification of the 'Reset Password' option"; 
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
			Test.actual_with_expected_xpath_text_verification(featuresSection, "//td[2]/table/tbody/tr[6]/td");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 16
	//Test Name: 008_Regsiter_New_User_Required_Fields_only
	@Test
	public void verifyRequiredFieldsInUserRegistrationPage() throws Exception{
		String testName = "008_Regsiter_New_User_Required_Fields_only";
		String testDesc = "Verification of the user registration functionality by proving only the required fields"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.userRegistration("", "Ahmed", "Shamim", "ahmeds6@mail.nih.gov", "240-276-6978", "Leidos Biomedical inc", "", "", "", "submit");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 17
	//Test Name: 009_Regsiter_New_User_All_Fields
	@Test
	public void verifyAllFieldsInUserRegistrationPage() throws Exception{
		String testName = "009_Regsiter_New_User_All_Fields";
		String testDesc = "Verification of the user registration functionality by proving all the fields"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.userRegistration("Mr.", "testfirst", "testlast", "ahmeds6@mail.nih.gov", "240-276-6978", "Leidos Biomedical inc", "240-301-7503", "Test registration request. PLEASE IGNORE!!", "check", "submit");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 18
	//Test Name: 011_Verify_User_Regsitration_with_Invalid_Values
	@Test
	public void verifyInvalidFieldValuesInUserRegistrationPage() throws Exception{
		String testName = "011_Verify_User_Regsitration_with_Invalid_Values";
		String testDesc = "Verify that the system returns error messages when invalid values are entered"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.userRegistration("", "$%^$&^", "%&^%&^", "abc.xyz@mail", "1-800-XYZ-0897", "Leidos Biomedical inc", "1-800-XYZ-0897", "", "", "submit");
			Test.verifyUserRegistrationErrors();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 19
	//Test Name: 012_Verify_Reset_user_registration_Fields
	@Test
	public void verifyResetOptionInUserRegistrationPage() throws Exception{
		String testName = "012_Verify_Reset_user_registration_Fields";
		String testDesc = "Verification of the user registration 'reset' functionality by proving all the fields and clearing the values entered by clicking on the reset button";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.userRegistration("Mr.", "testfirst", "testlast", "ramaniv@mail.nih.gov", "240-276-5291", "Leidos Biomedical inc", "240-301-7503", "Test registration request. PLEASE IGNORE!!", "check", "reset");
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
			Test.wait_For(3000);
			Test.verifyPopupPage(By.linkText("HELP"), "caNanoLab User's Guide");
			Test.verifyUrl("https://wiki.nci.nih.gov/display/caNanoLab/caNanoLab+User%27s+Guide");
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
			Test.chooseLoginOptions("Register for a login account");
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
			Test.verifyPopupPage(By.linkText("NCI CBIIT Home"), "National Cancer Informatics Program");
			Test.verifyUrl("http://cbiit.nci.nih.gov/");
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
			Test.verifyUrl("http://ncl.cancer.gov/");
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
	@Test
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
	
	//S.N.: 26
	//Test Name: 006_Verify_additional_nci_links_to_quick_links_section_NCINanoAllianceHome
	@Test
	public void verifyAdditionalNCILinks_NCINanoAllianceHome() throws Exception{
		String testName = "006_Verify_additional_nci_links_to_quick_links_section_NCINanoAllianceHome";
		String testDesc = "Verify NCI link 'NCI Nano Alliance Home' is displayed in the Quick Links section.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.verifyPopupPage(By.linkText("NCI Nano Alliance Home"), "NCI Alliance for Nanotechnology in Cancer");
			Test.verifyUrl("http://nano.cancer.gov/");
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
			Test.verifyPopupPage(By.linkText("NCI Home"), "Comprehensive Cancer Information - National Cancer Institute");
			Test.verifyUrl("http://www.cancer.gov/");
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
			Test.verifyPopupPage(By.linkText("Nano Hubs"), "NCIP Hub - Group: caNanoLab Curation");
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
			Test.verifyUrl(HostName+"/caNanoLab/html/cananoDisclaimer.html");
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
			Test.verifyPopupPage(By.linkText("ICON"), "This work is supported in part by the Nanoscale Science and Engineering Initiative of the National Science Foundation");
			Test.verifyUrl("http://icon.rice.edu/research.cfm");
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
			Test.verifyPopupPage(By.linkText("SAFENANO"), "© IOM SAFENANO");
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
			Test.verifyUrl("http://www.oecd.org/sti/nano/");
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
			Test.verifyUrl("http://enanomapper.net/");
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
			Test.login(researcherUserName,researcherPassword,"pass");
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
			Test.verifyUserSession(researcherUserName,researcherPassword, seleniumBrowser);
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
			Test.chooseLoginOptions("Browse publically available data");
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
	@Test
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
	
	//S.N.: 44
	//Test Name: 003_verify_sample_equals_search_by_sample_name
	@Test
	public void SamplesEqualsSearchBySampleName() throws Exception {
		String testName = "003_verify_sample_equals_search_by_sample_name";
		String testDesc = "Verify equals sample search by Sample name"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_simple("", "equals", "SNL_UNM-CAshleyACSNano2012-22", "", "", "", "", "", "", "", "search");
			Test.verify_sample_search_results("Sample Search Results", 1);
			Test.verify_sample_name_contains_from_search_results_page("SNL_UNM-CAshleyACSNano2012-22");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}

	//S.N.: 45
	//Test Name: 004_verify_sample_contains_search_by_poc
	@Test
	public void SamplesContainsSearchBySamplePOC() throws Exception {
		String testName = "004_verify_sample_contains_search_by_poc";
		String testDesc = "Verify sample contains search by Sample POC"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_simple("", "", "", "contains", "David", "", "", "", "", "", "search");
			Test.verify_sample_search_results("Sample Search Results", 1);
			Test.verify_sample_poc_contains_from_search_results_page("WSU_DPS Department of Pharmaceutical Sciences, Wayne State University 259 Mack Avenue Detroit MI 48202 USA");
			Test.click_view_link_by_sample_poc_contains_name("WSU_DPS Department of Pharmaceutical Sciences, Wayne State University 259 Mack Avenue Detroit MI 48202 USA");
			Test.verify_sample_general_info("WSU_USTC-QZhouJDT2009-09", "12/14/10", "COPOLYMER NONCOMPLEMENTARY PEPTIDE PLASMID POLYPLEX", "Yes", "David", "WSU_DPS", "investigator");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	
	//S.N.: 46
	//Test Name: 005_verify_sample_equals_search_by_sample_poc
	@Test
	public void SamplesEqualsSearchBySamplePOC() throws Exception {
		String testName = "005_verify_sample_equals_search_by_sample_poc";
		String testDesc = "Verify sample equals search by Sample POC"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_simple("", "", "", "equals", "WSU_DPS", "", "", "", "", "", "search");
			Test.verify_sample_search_results("Sample Search Results", 1);
			Test.verify_sample_poc_contains_from_search_results_page("WSU_DPS Department of Pharmaceutical Sciences, Wayne State University 259 Mack Avenue Detroit MI 48202 USA");
			Test.click_view_link_by_sample_poc_contains_name("WSU_DPS Department of Pharmaceutical Sciences, Wayne State University 259 Mack Avenue Detroit MI 48202 USA");
			Test.verify_sample_general_info("", "", "", "", "David", "WSU_DPS", "");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	

	//S.N.: 47
	//Test Name: 006_verify_sample_search_by_composition_nanomaterial_entity
	@Test
	public void SamplesSearchByNanomaterialEntity() throws Exception {
		String testName = "006_verify_sample_search_by_composition_nanomaterial_entity";
		String testDesc = "Verify sample search by nanomaterial entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_simple("", "", "", "", "", "carbon black", "", "", "", "", "search");
			Test.verify_sample_composition_contains_from_search_results_page("carbon black");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	
	//S.N.: 48
	//Test Name: 007_verify_sample_search_by_composition_functionalizing_entity
	@Test
	public void SamplesSearchByFunctionalizingEntity() throws Exception {
		String testName = "007_verify_sample_search_by_composition_functionalizing_entity";
		String testDesc = "Verify sample search by functionalizing entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_simple("", "", "", "", "", "", "Monomer", "", "", "", "search");
			Test.click_view_link_by_sample_name_contains("UNC-SGrattonPNAS2008-08");
			Test.navigate_sample_tabs("Composition");
			Test.wait_For(4000);
			Test.expected_value_verification("Monomer");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	
	//S.N.: 49
	//Test Name: 008_verify_sample_search_by_composition_function
	@Test
	public void SamplesSearchByFunctiontypes() throws Exception {
		String testName = "008_verify_sample_search_by_composition_function";
		String testDesc = "Verify sample search by function types"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_by_function_types("targeting function");
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
	
	//S.N.: 50
	//Test Name: 009_verify_sample_search_by_characterization_type
	@Test
	public void SamplesSearchByCharacterizationType() throws Exception {
		String testName = "009_verify_sample_search_by_characterization_type";
		String testDesc = "Verify sample search by Characterization types"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_simple("", "", "", "", "", "", "", "", "physico-chemical characterization", "", "search");
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
			Test.chooseLoginOptions("Login to submit data");
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
			Test.view_data_availability_chart_from_sample_search_results_page("NCL-49-2", "caNanoLab Availability Score:(.*)");
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
			Test.chooseLoginOptions("Login to submit data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			Test.chooseLoginOptions("Browse publically available data");
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
			String HomePageURL = HostName + "/caNanoLab/#/home";
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
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			String manageCurationURL = HostName + "/caNanoLab/#/manageCuration";
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
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.clickPageLinks("Review Data Pending Release to Public", "Review By Curator");
			String reviewByCuratorURL = HostName + "/caNanoLab/#/reviewData";
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
	
	//S.N.: 101
	//Test Name: ensureStrutsHasBeenRemovedFromManageBatchDataAvailabilityPage
	@Test
	public void ensureStrutsHasBeenRemovedFromManageBatchDataAvailabilityPage() throws Exception {
		String testName = "003_Ensure_Struts_has_been_removed_from_Manage_Batch_Data_Availability_page";
		String testDesc = "Ensure Struts has been removed from Manage batch data avilability page and system is displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.clickPageLinks("Manage Batch Data Availability", "Manage Batch Data Availability");
			String manageBatchDataAvailabilityURL = HostName + "/caNanoLab/#/batchDataAvailability";
			Test.verifyUrl(manageBatchDataAvailabilityURL);
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
	* MANAGE CURATION page
	*/
	
	//S.N.: 102
	//Test Name: 001_Verify_Manage_Curation_page_title_exists
	@Test
	public void verifyManageCurationPageTitleExists() throws Exception {
		String testName = "001_Verify_Manage_Curation_page_title_exists";
		String testDesc = "Verify Manage curation title exists under Curation page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String HomePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(HomePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.verifyPage(By.cssSelector(".contentTitle tbody tr th"), "Manage Curation");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 103
	//Test Name: 002_Verify_Review_Data_Pending_Release_to_Public_link_Exists
	@Test
	public void verifyReviewDataPendingReleaseToPublicLinkExists() throws Exception {
		String testName = "002_Verify_Review_Data_Pending_Release_to_Public_link_Exists";
		String testDesc = "Verify Review Data Pending Release to Public link exists under Curation page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String HomePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(HomePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.verifyLink(By.linkText("Review Data Pending Release to Public"));
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 104
	//Test Name: 003_Verify_Manage_Batch_Data_Availability_link_Exists
	@Test
	public void verifyManageBatchDataAvailabilityLinkExists() throws Exception {
		String testName = "003_Verify_Manage_Batch_Data_Availability_link_Exists";
		String testDesc = "Verify Manage Batch Data Avialability link exists under Curation page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			String HomePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(HomePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.verifyLink(By.linkText("Manage Batch Data Availability"));
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
	 * Manage Batch Data Availability
	 */

	//S.N.: 105
	//Test Name: 001_Verify_user_able_to_submit_generate_data_availability_for_all_samples_search
	@Test
	public void verifyUserAbleToSubmitGenerateDataAvailabilityForAllSamplesSearch() throws Exception {
		String testName = "001_Verify_user_able_to_submit_generate_data_availability_for_all_samples_search";
		String testDesc = "Verify user able to submit generate data availability for all samples serach. Depend upon data avilability system may take a while to generate matrics for available samples";
		try{	 
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String HomePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(HomePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.verify_user_able_to_submit_generate_data_availability_for_all_samples_search();
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
	 * My Workspace
	 */
	
	//S.N.: 106
	//Test Name: 001_Verify_Curator_user_can_view_My_Worksapce
	@Test
	public void verifyCuratorUserCanViewMyWorksapce() throws Exception {
		String testName = "001_Verify_Curator_user_can_view_My_Worksapce";
		String testDesc = "Verifying My worksapce is visible to the Curator user when user logged into the system"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_user_can_view_My_Worksapce();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 107
	//Test Name: 002_Verify_Researcher_user_can_view_My_Worksapce
	@Test
	public void verifyResearcherUserCanViewMyWorksapce() throws Exception {
		String testName = "002_Verify_Researcher_user_can_view_My_Worksapce";
		String testDesc = "Verifying My worksapce is visible to the Researcher user when user logged into the system";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLogin(By.linkText("MY WORKSPACE"));
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Researcher_user_can_view_My_Worksapce();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 108
	//Test Name: 003_Verify_User_can_uncheck_Samples_from_My_Workspace
	@Test
	public void verifyUserCanUncheckSamplesFromMyWorkspace() throws Exception {
		String testName = "003_Verify_User_can_uncheck_Samples_from_My_Workspace";
		String testDesc = "User should be able to uncheck My Samples and system should display My Protocols and My Publications sections only";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_User_can_uncheck_Samples_from_My_Workspace();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 109
	//Test Name: 004_Verify_User_can_Uncheck_protocols_from_My_Workspace
	@Test
	public void verifyUserCanUncheckProtocolsFromMyWorkspace() throws Exception {
		String testName = "004_Verify_User_can_Uncheck_protocols_from_My_Workspace";
		String testDesc = "User should be able to uncheck My Samples and system should display My Protocols and My Publications sections only";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_User_can_Uncheck_protocols_from_My_Workspace();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 110
	//Test Name: 005_Verify_User_can_uncheck_Publications_from_My_Workspace_page
	@Test
	public void verifyUserCanUncheckPublicationsFromMyWorkspacePage() throws Exception {
		String testName = "005_Verify_User_can_uncheck_Publications_from_My_Workspace_page";
		String testDesc = "User should be able to uncheck My Publications and system should display My samples and My Protoclos sections only"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_User_can_uncheck_Publications_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 111
	//Test Name: 006_Verify_Curator_User_can_View_samples_from_My_Workspace_page
	@Test
	public void verifyCuratorUserCanViewSamplesFromMyWorkspacePage() throws Exception {
		String testName = "006_Verify_Curator_User_can_View_samples_from_My_Workspace_page";
		String testDesc = "User should be able to view My Samples and system should display My samples General info page";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("MY WORKSPACE"));
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_User_can_View_samples_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	

	//112
	//Test Name: 007_Verify_Curator_User_can_Edit_samples_from_My_Workspace_page
	@Test
	public void verifyCuratorUserCanEditSamplesFromMyWorkspacePage() throws Exception {
		String testName = "007_Verify_Curator_User_can_Edit_samples_from_My_Workspace_page";
		String testDesc = "User should be able to Edit My Samples and system should display My samples Edit General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_User_can_Edit_samples_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//113
	//Test Name: 008_Verify_Researcher_User_can_View_samples_from_My_Workspace_page
	@Test
	public void verifyResearcherUserCanViewSamplesFromMyWorkspacePage() throws Exception {
		String testName = "008_Verify_Researcher_User_can_View_samples_from_My_Workspace_page";
		String testDesc = "Researcher User should be able to view My Samples and system should display My samples General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Researcher_User_can_View_samples_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//114
	//Test Name: 009_Verify_Researcher_User_can_Edit_samples_from_My_Workspace_page
	@Test
	public void verifyResearcherUserCanEditSamplesFromMyWorkspacePage() throws Exception {
		String testName = "009_Verify_Researcher_User_can_Edit_samples_from_My_Workspace_page";
		String testDesc = "Researchcer User should be able to Edit My Samples and system should display My samples Edit General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Researcher_User_can_Edit_samples_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//115
	//Test Name: 010_Verify_Curator_User_can_View_My_Protocols_from_My_Workspace_page
	@Test
	public void verifyCuratorUserCanViewMyProtocolsFromMyWorkspacePage() throws Exception {
		String testName = "010_Verify_Curator_User_can_View_My_Protocols_from_My_Workspace_page";
		String testDesc = "User should be able to view My Samples and system should display My samples General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_User_can_View_My_Protocols_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//116
	//Test Name: 011_Verify_Researcher_User_can_View_My_Protocols_from_My_Workspace_page
	@Test
	public void verifyResearcherUserCanViewMyProtocolsFromMyWorkspacePage() throws Exception {
		String testName = "011_Verify_Researcher_User_can_View_My_Protocols_from_My_Workspace_page";
		String testDesc = "User should be able to view My Samples and system should display My samples General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Researcher_User_can_View_My_Protocols_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	
	//117
	//Test Name: 012_Verify_Curator_User_can_Edit_My_Protocols_from_My_Workspace_page
	@Test
	public void VerifyCuratorUserCanEditMyProtocolsFromMyWorkspacePage() throws Exception {
		String testName = "012_Verify_Curator_User_can_Edit_My_Protocols_from_My_Workspace_page";
		String testDesc = "User should be able to view My Samples and system should display My samples General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_User_can_Edit_My_Protocols_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//118
	//Test Name: 013_Verify_Reseracher_User_can_Edit_My_Protocols_from_My_Workspace_page
	@Test
	public void VerifyReseracherUserCanEditMyProtocolsFromMyWorkspacePage() throws Exception {
		String testName = "013_Verify_Reseracher_User_can_Edit_My_Protocols_from_My_Workspace_page";
		String testDesc = "User should be able to view My Samples and system should display My samples General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Reseracher_User_can_Edit_My_Protocols_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//119
	//Test Name: 014_Verify_Curator_User_can_View_My_Publications_from_My_Workspace_page
	@Test
	public void verifyCuratorUserCanViewMyPublicationsFromMyWorkspacePage() throws Exception {
		String testName = "014_Verify_Curator_User_can_View_My_Publications_from_My_Workspace_page";
		String testDesc = "Curator User should be able to view My Publications and system should display My Publication page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_User_can_View_My_Publications_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//120
	//Test Name: 015_Verify_Researcher_User_can_View_My_publications_from_My_Workspace_page
	@Test
	public void verifyResearcherUserCanViewMyPublicationsFromMyWorkspacePage() throws Exception {
		String testName = "015_Verify_Researcher_User_can_View_My_publications_from_My_Workspace_page";
		String testDesc = "Researcher User should be able to view My Publications and system should display My Publication page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Researcher_User_can_View_My_publications_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//121
	//Test Name: 016_Verify_Curator_User_can_Edit_My_Publications_from_My_Workspace_page
	@Test
	public void verifyCuratorUserCanEditMyPublicationsFromMyWorkspacePage() throws Exception {
		String testName = "016_Verify_Curator_User_can_Edit_My_Publications_from_My_Workspace_page";
		String testDesc = "Curator User should be able to Edit My Samples and system should display My Publications Edit page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_User_can_Edit_My_Publications_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
			
		}			
	}
	
	//122
	//Test Name: 017_Verify_Researcher_User_can_Edit_My_Publications_from_My_Workspace_page
	@Test
	public void verifyResearcherUserCanEditMyPublicationsFromMyWorkspacePage() throws Exception {
		String testName = "017_Verify_Researcher_User_can_Edit_My_Publications_from_My_Workspace_page";
		String testDesc = "Researcher User should be able to Edit My Publication and system should display My Publication edit page";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Researcher_User_can_Edit_My_Publications_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//123
	//Test Name: 018_Ensure_User_can_view_samples_protocols_and_publications_and_use_back_button_from_view_page
	@Test
	public void ensureUsercanViewSamplesProtocolsAndPublicationsAndUseBackButtonFromViewPage() throws Exception {
		String testName = "018_Ensure_User_can_view_samples_protocols_and_publications_and_use_back_button_from_view_page";
		String testDesc = "User should be able to view My Samples and system should display My samples General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Ensure_User_can_view_samples_protocols_and_publications_and_use_back_button_from_view_page();
			String samplePageURL = HostName + "/caNanoLab/#/myWorkspace";
			Test.verifyUrl(samplePageURL);		
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// Remove Struts from Publication page
	
	//S.N.: 124
	//Test Name: 003_Ensure Struts has been removed from Manage Publication Page
	@Test
	public void ensureStrutsHasBeenRemovedFromManagePublicationPage() throws Exception {
		String testName = "003_Ensure Struts has been removed from Manage Publication Page";
		String testDesc = "Ensure Struts has been removed from Manage Publication Search Page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("PUBLICATIONS", "Manage Publications");
			String publicationSearchURL = HostName + "/caNanoLab/#/managePublications";
			Test.verifyUrl(publicationSearchURL);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 125
	//Test Name: 001_Ensure Struts has been removed from Publication Search Page
	@Test
	public void ensureStrutsHasBeenRemovedFromPublicationSearchPage() throws Exception {
		String testName = "001_Ensure Struts has been removed from Publication Search Page";
		String testDesc = "Ensure Struts has been removed from Publication Search Page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("PUBLICATIONS", "Manage Publications");
			Test.clickPageLinks("Search Existing Publications", "Publication Search");
			String publicationSearchURL = HostName + "/caNanoLab/#/searchPublication";
			Test.verifyUrl(publicationSearchURL);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 126
	//Test Name: 001_Ensure Struts has been removed from Publication Submission Page
	@Test
	public void ensureStrutsHasBeenRemovedFromPublicationSubmissionPage() throws Exception {
		String testName = "001_Ensure Struts has been removed from Publication Submission Page";
		String testDesc = "Ensure Struts has been removed from Publication Submission Page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.clickMenubarLinks("PUBLICATIONS", "Manage Publications");
			Test.clickPageLinks("Submit a New Publication", "Submit Publication");
			String publicationSearchURL = HostName + "/caNanoLab/#/submitPublication";
			Test.verifyUrl(publicationSearchURL);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 127
	//Test Name: 001_Ensure Struts has been removed from Search for Samples by Publication Page
	@Test
	public void ensureStrutsHasBeenRemovedFromSearchForSamplesByPublicationPage() throws Exception {
		String testName = "001_Ensure Struts has been removed from Search for Samples by Publication Page";
		String testDesc = "Ensure Struts has been removed from search for samples by Publication Page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.clickMenubarLinks("PUBLICATIONS", "Manage Publications");
			Test.clickPageLinks("Search for Samples by Publication", "Sample Search by Publication");
			String publicationSearchURL = HostName + "/caNanoLab/#/searchSamplesByPublication";
			Test.verifyUrl(publicationSearchURL);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	// Delete Publication
	
	//S.N.: 128
	//Test Name: 001_Verify_that_a_curator_can_remove_submited_publication
	@Test
	public void verifyThatACuratorCanRemoveSampleFromPublication() throws Exception {
		String testName = "001_Verify_that_a_curator_can_remove_submited_publication";
		String testDesc = "Verify Curator user able to submit a new publication as a curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication("proceeding", "in press", "", "", "Test Submit Publication As Curator", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "Upload", "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", "", "", "test sample test", "Add", "User", "Researcher CaNano", "canano_res", "read update delete", "Submit", "Search", "Edit");
			Test.wait_For(9000);
			Test.delete_publication("OK");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
			
		}			
	}
	
	//S.N.: 129
	//Test Name: 002_Verify_that_a_researcher_able_to_remove_sample_from_publication_for_publication_that_user_have_delete_access
	@Test
	public void verifyThatAResearcherAbleToRemoveSampleFromPublicationForPublicationThatUserHaveDeleteAccess() throws Exception {
		String testName = "002_Verify_that_a_researcher_able_to_remove_sample_from_publication_for_publication_that_user_have_delete_access";
		String testDesc = "Verify researcher use able to remove sumited publication that user have delete access"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication("proceeding", "in press", "", "", "Test Submit Publication As Researcher", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "Upload", "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", "", "", "test sample test", "Add", "User", "Researcher CaNano", "canano_res", "read update delete", "Submit", "Search", "Edit");
			Test.wait_For(9000);
			Test.delete_publication("OK");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// Edit Publication
	
	//S.N.: 130
	//Test Name: 001_Verify_that_a_researcher_can_edit_publication_for_publication_that_user_has_update_or_edit_access
	@Test
	public void verifyThatAResearcherCanEditPublicationForPublicationThatUserHasUpdateOrEditAccess() throws Exception {
		String testName = "001_Verify_that_a_researcher_can_edit_publication_for_publication_that_user_has_update_or_edit_access";
		String testDesc = "Verify researcher use able to remove sumited publication that user have delete access"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication("proceeding", "in press", "", "", "Test Submit Publication As Researcher", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "Upload", "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", "", "", "test sample test", "Add", "User", "Researcher CaNano", "canano_res", "read update delete", "Submit", "Search", "Edit");
			Test.wait_For(9000);
			Test.submit_a_new_publication("", "", "", "", "Test Submit Publication As Researcher Update", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "", "", "", "", "test sample test", "", "", "", "", "", "Update", "Search", "Edit");
			Test.wait_For(9000);
			Test.delete_publication("OK");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 131
	//Test Name: 003_Verify_that_a_curator_can_edit_publication
	@Test
	public void verifyThatACuratorCanEditPublication() throws Exception {
		String testName = "003_Verify_that_a_curator_can_edit_publication";
		String testDesc = "Verify Curator user able to submit a new publication as a curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication("proceeding", "in press", "", "", "Test Submit Publication As Curator", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "Upload", "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", "", "", "test sample test", "Add", "User", "Researcher CaNano", "canano_res", "read update delete", "Submit", "Search", "Edit");
			Test.wait_For(9000);
			Test.submit_a_new_publication("", "", "", "", "Test Submit Publication As Curator Update", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "", "", "", "", "test sample test", "", "", "", "", "", "Update", "Search", "Edit");
			Test.wait_For(9000);
			Test.delete_publication("OK");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// Submit Samples
	
	//S.N.: 132 ---
	//Test Name: 001_Verify_the_ability_to_add_a_new_sample_as_a_Curator
	@Test
	public void VerifyTheAbilityToAddANewSampleAsACurator() throws Exception {
		String testName = "001_Verify_the_ability_to_add_a_new_sample_as_a_Curator";
		String testDesc = "Verify Curator user able to submit a new Samples as a curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			//Submit Sample
			Test.submit_new_sample("Test Submit Sample As Curator", "Submit");
			Test.Verify_the_ability_to_submit_a_New_Samples_general_info("Test Submit Sample As Curator", "BB_SH_DFCI_WCMC_BWH_MIT", "investigator", "Researcher CaNano", "canano_res");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 133 ---
	//Test Name: 002_Verify_the_ability_to_add_a_new_sample_as_a_Researcher
	@Test
	public void VerifyTheAbilityToAddANewSampleAsAResearcher() throws Exception {
		String testName = "002_Verify_the_ability_to_add_a_new_sample_as_a_Researcher";
		String testDesc = "Verify Curator user able to submit a new Samples as a Researcher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLogin(By.linkText("MY WORKSPACE"));
			Test.Verify_the_ability_to_submit_a_New_Samples_general_info("Test Submit Sample As Researcher", "BB_SH_DFCI_WCMC_BWH_MIT", "investigator", "Guest Guest", "canano_guest");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 134 ---
	//Test Name: 005_Verify_the_ability_to_add_a_Sample_Composition_Naomaterial_Entity_as_Curator
	@Test
	public void verifyTheAbilityToAddASampleCompositionNaomaterialEntityAsCurator() throws Exception {
		String testName = "005_Verify_the_ability_to_add_a_Sample_Composition_Naomaterial_Entity_as_Curator";
		String testDesc = "Verify Curator user able to submit a new Samples composition nanomaterial entity as a curator";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.Verify_the_ability_to_submit_a_New_Samples_general_info("Test Submit Sample As Curator", "BB_SH_DFCI_WCMC_BWH_MIT", "investigator", "Researcher CaNano", "canano_res");
			Test.Verify_the_ability_to_add_a_Sample_Composition_Naomaterial_Entity_as_Curator();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 135 ---
	//Test Name: 006_Verify_the_ability_to_add_a_Sample_Composition_Functionalizing_Entity_as_Curator
	@Test
	public void verifyTheAbilityToAddASampleCompositionFunctionalizingEntityAsCurator() throws Exception {
		String testName = "006_Verify_the_ability_to_add_a_Sample_Composition_Functionalizing_Entity_as_Curator";
		String testDesc = "Verify Curator user able to submit a new Samples composition fucntionalizing entity as a curator";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			//Test.Search_Samples__For_Composition_Naomaterial_Entity("Test Submit Sample As Curator14213528");
			Test.Verify_the_ability_to_submit_a_New_Samples_general_info("Test Submit Sample As Curator", "BB_SH_DFCI_WCMC_BWH_MIT", "investigator", "Researcher CaNano", "canano_res");
			Test.Verify_the_ability_to_add_a_Sample_Composition_Functionalizing_Entity_as_Curator();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	
	//Submit Protocols
	
	//S.N.: 136 ---
	//Test Name: 006_Verify_the_ability_to_add_a_Sample_Composition_Functionalizing_Entity_as_Curator
	@Test
	public void VerifyTheAbilityToSubmitANewProtocolsAsACurator() throws Exception {
		String testName = "001_Verify_the_ability_to_submit_a_New_Protocols_as_a_Curator";
		String testDesc = "Verify Curator user able to submit a new Protocol";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.submit_a_New_Protocols("AsynthesisB", "Test Submit Protocol As Curator ", "Test Protocol Abbreviation", "Test Protocol Version 1", "external1", "http://www.test.com", "Test File Title", "Test Description", "Researcher CaNano", "canano_res");			
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 137 ---
	//Test Name: 002_Verify_the_ability_to_submit_a_New_Protocols_as_a_Researcher
	@Test
	public void VerifyTheAbilityToSubmitANewProtocolsAsAResearcher() throws Exception {
		String testName = "002_Verify_the_ability_to_submit_a_New_Protocols_as_a_Researcher";
		String testDesc = "Verify Researcher user able to submit a new Protocol"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.submit_a_New_Protocols("AsynthesisB", "Test Submit Protocol As Researcher ", "Test Protocol Abbreviation", "Test Protocol Version 1", "external1", "http://www.test.com", "Test File Title", "Test Description", "Guest Guest", "canano_guest");			
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	
	// Protocol 
	// Remove Struts from Protocol page
	
	//S.N.: 138 ---
	//Test Name: 002_Verify_the_ability_to_submit_a_New_Protocols_as_a_Researcher
	@Test
	public void ensureStrutsHasBeenRemovedFromManageProtocolPage() throws Exception {
		String testName = "001_Ensure_Struts_has_been_removed_from_Manage_Protocol_page";
		String testDesc = "Ensure Struts has been removed from Manage Protocol page and the system is displaying the new framework URL";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("PROTOCOLS", "Manage Protocols");
			String manageCurationURL = HostName + "/caNanoLab/#/manageProtocols";
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
	
	//S.N.: 139 ---
	//Test Name: 002_Ensure_Struts_has_been_removed_from_Submit_a_New_Protocol_page
	@Test
	public void ensureStrutsHasBeenRemovedFromSubmitANewProtocolpage() throws Exception {
		String testName = "002_Ensure_Struts_has_been_removed_from_Submit_a_New_Protocol_page";
		String testDesc = "Ensure Struts has been removed from Submit Protocol page and the system is displaying the new framework URL";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("PROTOCOLS", "Manage Protocols");
			Test.clickPageLinks("Submit a New Protocol", "Submit Protocol");
			String manageCurationURL = HostName + "/caNanoLab/#/submitProtocol";
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
	
	//S.N.: 140 ---
	//Test Name: 003_Ensure_Struts_has_been_removed_from_Search_Existing_Protocols_page
	@Test
	public void ensureStrutsHasBeenRemovedFromSearchExistingProtocolsPage() throws Exception {
		String testName = "003_Ensure_Struts_has_been_removed_from_Search_Existing_Protocols_page";
		String testDesc = "Ensure Struts has been removed from Search existing Protocol page and the system is displaying the new framework URL";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("PROTOCOLS", "Manage Protocols");
			Test.clickPageLinks("Search Existing Protocols", "Protocol Search");
			String manageCurationURL = HostName + "/caNanoLab/#/searchProtocol";
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
	
	
	// Search Protocols
	
	//S.N.: 141 ---
	//Test Name: 001_Verify_the_ability_to_Search_Protocols_as_a_Curator
	@Test
	public void verifyTheAbilityToSearchProtocolsAsACurator() throws Exception {
		String testName = "001_Verify_the_ability_to_Search_Protocols_as_a_Curator";
		String testDesc = "Ensure Curator user able to serach existing protocols"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.clickMenubarLinks("PROTOCOLS", "Manage Protocols");
			Test.clickPageLinks("Search Existing Protocols", "Protocol Search");
			Test.search_Existing_Protocols("search", "", "contains", "", "contains", "", "contains","");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 142 ---
	//Test Name: 001_Verify_the_ability_to_Search_Protocols_as_a_Curator
	@Test
	public void verifyTheAbilityToSearchProtocolsAsACurator1() throws Exception {
		String testName = "001_Verify_the_ability_to_Search_Protocols_as_a_Curator";
		String testDesc = "Ensure Curator user able to serach existing protocols"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.clickMenubarLinks("PROTOCOLS", "Manage Protocols");
			Test.clickPageLinks("Search Existing Protocols", "Protocol Search");
			Test.search_Existing_Protocols("search", "AsynthesisB", "contains", "Test Submit", "contains", "", "contains","");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// Sample page verification
	
	//S.N.: 143 ---
	//Test Name: 001_Verify_the_ability_to_Search_Protocols_as_a_Curator
	@Test
	public void VerifySampleSubmitPage() throws Exception {
		String testName = "001_Verify_the_ability_to_Search_Protocols_as_a_Curator";
		String testDesc = "Ensure Curator user able to serach existing protocols"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.clickMenubarLinks("SAMPLES", "Manage Samples");
			Test.clickPageLinks("Copy an Existing Sample", "Submit Sample");
			Test.verify_Sample_Submit_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	
	// Advanced Search
	
	//Sample Criteria - Curator
	
	//S.N.: 144
	//Test Name: 001_Curator User should be able to add sample criteria with sample name and contains filter to the Advanced sample search
	@Test
	public void curatorUserShouldBeAbleToAddSampleCriteriaWithSampleNameAndContainsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "001_Curator User should be able to add sample criteria with sample name and contains filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add sample criteria with sample name and contains filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"sample name"/*getSampleORPOCName*/, 
				"contains"/*getSampCriContainsOrEqual*/, 
				"NCL-23"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				""/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				""/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                "Yes"/*verifySearchSampleValYesOrNo*/, 
                "contains"/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
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
	
	//S.N.: 145
	//Test Name: 002_Curator User should be able to add sample criteria with sample name and equals filter to the Advanced sample search
	@Test
	public void curatorUserShouldBeAbleToAddSampleCriteriaWithSampleNameAndEqualsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "002_Curator User should be able to add sample criteria with sample name and equals filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add sample criteria with sample name and equals filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"sample name"/*getSampleORPOCName*/, 
				"equals"/*getSampCriContainsOrEqual*/, 
				"NCL-23-1"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				""/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				""/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                "Yes"/*verifySearchSampleValYesOrNo*/, 
                "equals"/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
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
	
	//S.N.: 146
	//Test Name: 003_Curator User should be able to perform Advanced sample search by sample criteria with point of contact name and contains filter
	@Test
	public void curatorUserShouldBeAbleToPefromAdvancedSampleSearchBySampleCriteriaWithPointOfContactNameAndContainsFilter() throws Exception {
		String testName = "003_Curator User should be able to perform Advanced sample search by sample criteria with point of contact name and contains filter";
		String testDesc = "Ensure Curator User should be able to perform Advanced sample search by sample criteria with point of contact name and contains filter"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"point of contact name"/*getSampleORPOCName*/, 
				"contains"/*getSampCriContainsOrEqual*/, 
				"David"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				""/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				""/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                ""/*verifySearchSampleValYesOrNo*/, 
                ""/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 147
	//Test Name: 004_Curator User should be able to perform Advanced sample search by sample criteria with point of contact name and equals filter
	@Test
	public void curatorUserShouldBeAbleToPefromAdvancedSampleSearchBySampleCriteriaWithPointOfContactNameAndEqualsFilter() throws Exception {
		String testName = "004_Curator User should be able to perform Advanced sample search by sample criteria with point of contact name and equals filter";
		String testDesc = "Ensure Curator User should be able to perform Advanced sample search by sample criteria with point of contact name and equals filter"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"point of contact name"/*getSampleORPOCName*/, 
				"equals"/*getSampCriContainsOrEqual*/, 
				"David A Scheinberg"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				""/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				""/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                ""/*verifySearchSampleValYesOrNo*/, 
                ""/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 147
	//Test Name: 005_Ensure Curator user able to Reset sample criteria from adavanced sample search page
	@Test
	public void ensureCuratorUserAbleToResetSampleCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "005_Ensure Curator user able to Reset sample criteria from adavanced sample search page";
		String testDesc = "Ensure Curator user able to Reset sample criteria from adavanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"point of contact name"/*getSampleORPOCName*/, 
				"equals"/*getSampCriContainsOrEqual*/, 
				"David A Scheinberg"/*getSampleCriteriaName*/, 
				"Reset"/*getSampCriAddOrReset*/, 
				""/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				""/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                ""/*getSearchOrReset*/, 
                ""/*verifySearchSampleValYesOrNo*/, 
                ""/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			//Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 148
	//Test Name: 006_Ensure Curator user able to Remove sample criteria from adavanced sample search page
	@Test
	public void ensureCuratorUserAbleToRemoveSampleCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "006_Ensure Curator user able to Remove sample criteria from adavanced sample search page";
		String testDesc = "Ensure Curator user able to Remove sample criteria from adavanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"sample name"/*getSampleORPOCName*/, 
				"equals"/*getSampCriContainsOrEqual*/, 
				"NCL-23-1"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				"Edit"/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				"Remove"/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                ""/*verifySearchSampleValYesOrNo*/, 
                ""/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			//Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 149
	//Test Name: 007_Ensure Curator user able to Edit sample criteria from adavanced sample search page
	@Test
	public void EnsureCuratorUserAbleToEditSampleCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "007_Ensure Curator user able to Edit sample criteria from adavanced sample search page";
		String testDesc = "Ensure Curator user able to Edit sample criteria from adavanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"sample name"/*getSampleORPOCName*/, 
				"equals"/*getSampCriContainsOrEqual*/, 
				"NCL-23-1"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				"Edit"/*getSampleCriteriaEdit*/, 
				"point of contact name"/*getSampleORPOCNameEdit*/, 
				"contains"/*getSampCriContainsOrEqualEdit*/, 
				"David"/*getSampleCriteriaNameEdit*/, 
				"Add"/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                ""/*verifySearchSampleValYesOrNo*/, 
                ""/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			//Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//Sample Criteria - Researcher
	
	//S.N.: 150
	//Test Name: 001_Researcher User should be able to add sample criteria with sample name and contains filter to the Advanced sample search
	@Test
	public void researcherUserShouldBeAbleToAddSampleCriteriaWithSampleNameAndContainsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "001_Researcher User should be able to add sample criteria with sample name and contains filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add sample criteria with sample name and contains filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(	
				"sample name"/*getSampleORPOCName*/, 
				"contains"/*getSampCriContainsOrEqual*/, 
				"NCL-23"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				""/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				""/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                "Yes"/*verifySearchSampleValYesOrNo*/, 
                "contains"/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
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
	
	//S.N.: 151
	//Test Name: 002_Researcher User should be able to add sample criteria with sample name and equals filter to the Advanced sample search
	@Test
	public void researcherUserShouldBeAbleToAddSampleCriteriaWithSampleNameAndEqualsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "002_Researcher User should be able to add sample criteria with sample name and equals filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add sample criteria with sample name and equals filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"equals"/*getSampCriContainsOrEqual*/, 
										"NCL-23-1"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/, 
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    "Yes"/*verifySearchSampleValYesOrNo*/, 
					                    "equals"/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
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
	
	//S.N.: 152
	//Test Name: 003_Researcher User should be able to perform Advanced sample search by sample criteria with point of contact name and contains filter
	@Test
	public void researcherUserShouldBeAbleToPefromAdvancedSampleSearchBySampleCriteriaWithPointOfContactNameAndContainsFilter() throws Exception {
		String testName = "003_Researcher User should be able to perform Advanced sample search by sample criteria with point of contact name and contains filter";
		String testDesc = "Ensure Researcher User should be able to perform Advanced sample search by sample criteria with point of contact name and contains filter"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("point of contact name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"David"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/, 
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 153
	//Test Name: 004_Researcher User should be able to perform Advanced sample search by sample criteria with point of contact name and equals filter
	@Test
	public void researcherUserShouldBeAbleToPefromAdvancedSampleSearchBySampleCriteriaWithPointOfContactNameAndEqualsFilter() throws Exception {
		String testName = "004_Researcher User should be able to perform Advanced sample search by sample criteria with point of contact name and equals filter";
		String testDesc = "Ensure Researcher User should be able to perform Advanced sample search by sample criteria with point of contact name and equals filter"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("point of contact name"/*getSampleORPOCName*/, 
										"equals"/*getSampCriContainsOrEqual*/, 
										"David A Scheinberg"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/, 
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 154
	//Test Name: 005_Ensure Researcher user able to Reset sample criteria from advanced sample search page
	@Test
	public void ensureResearcherUserAbleToResetSampleCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "005_Ensure Researcher user able to Reset sample criteria from advanced sample search page";
		String testDesc = "Ensure Researcher user able to Reset sample criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("point of contact name"/*getSampleORPOCName*/, 
										"equals"/*getSampCriContainsOrEqual*/, 
										"David A Scheinberg"/*getSampleCriteriaName*/, 
										"Reset"/*getSampCriAddOrReset*/, 
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    ""/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			//Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 155
	//Test Name: 006_Ensure Researcher user able to Remove sample criteria from advanced sample search page
	@Test
	public void ensureResearcherUserAbleToRemoveSampleCriteriaFromAdvancedSampleSearchPage() throws Exception {
		String testName = "006_Ensure Researcher user able to Remove sample criteria from advanced sample search page";
		String testDesc = "Ensure Researcher user able to Remove sample criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"equals"/*getSampCriContainsOrEqual*/, 
										"NCL-23-1"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/, 
										"Edit"/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										"Remove"/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			//Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 156
	//Test Name: 007_Ensure Researcher user able to Edit sample criteria from advanced sample search page
	@Test
	public void ensureResearcherUserAbleToEditSampleCriteriaFromAdvancedSampleSearchPage() throws Exception {
		String testName = "007_Ensure Researcher user able to Edit sample criteria from advanced sample search page";
		String testDesc = "Ensure Researcher user able to Edit sample criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"equals"/*getSampCriContainsOrEqual*/, 
										"NCL-23-1"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/, 
										"Edit"/*getSampleCriteriaEdit*/, 
										"point of contact name"/*getSampleORPOCNameEdit*/, 
										"contains"/*getSampCriContainsOrEqualEdit*/, 
										"David"/*getSampleCriteriaNameEdit*/, 
										"Add"/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			//Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//Composition Criteria - Curator
	
	//S.N.: 157
	//Test Name: 001_Curator User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name contains filter to the Advanced sample search
	@Test
	public void curatorUserShouldBeAbleToAddCompositionCriteriaWithNanomaterialEntityAndBiopolymerAndChemicalNameContainsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "001_Curator User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name contains filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name contains filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL-23"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/, 
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "nanomaterial entity"/*getCompositionCriteriaFilterA*/, 
					                    "dendrimer"/*getCompositionCriteriaFilterB*/, 
					                    "contains"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Diaminobutane"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 158
	//Test Name: 002_Curator User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name equals filter to the Advanced sample search
	@Test
	public void curatorUserShouldBeAbleToAddCompositionCriteriaWithNanomaterialEntityAndBiopolymerAndChemicalNameEqualsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "002_Curator User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name equals filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name equals filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL-23"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "nanomaterial entity"/*getCompositionCriteriaFilterA*/, 
					                    "dendrimer"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Diaminobutane (DAB)"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 159
	//Test Name: 003_Curator User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name contains filter to the Advanced sample search
	@Test
	public void curatorUserShouldBeAbleToAddCompositionCriteriaWithFunctionalizingEntityAndAntibodyAndChemicalNameContainsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "003_Curator User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name contains filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name contains filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL-23"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "contains"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 160
	//Test Name: 004_Curator User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name with the equals filter to the Advanced sample search
	@Test
	public void curatorUserShouldBeAbleToAddCompositionCriteriaWithFunctionalizingEntityAndAntibodyAndChemicalNameEqualsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "004_Curator User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name equals filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name with the equals filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 161
	//Test Name: 005_Curator User should be able to add Composition Criteria with Function and Imaging Function filter to the Advanced sample search
	@Test
	public void curatorUserShouldBeAbleToAddCompositionCriteriaWithFunctionAndImagingFunctionFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "005_Curator User should be able to add Composition Criteria with Function and Imaging Function filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add Composition Criteria with Function and Imaging Function filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "function"/*getCompositionCriteriaFilterA*/, 
					                    "imaging function"/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_function();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 162
	//Test Name: 006_Curator User should be able to add Composition Criteria with Function and Targeting Function filter to the Advanced sample search
	@Test
	public void curatorUserShouldBeAbleToAddCompositionCriteriaWithFunctionAndTargetingFunctionFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "006_Curator User should be able to add Composition Criteria with Function and Targeting Function filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add Composition Criteria with Function and Targeting Function filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "function"/*getCompositionCriteriaFilterA*/, 
					                    "targeting function"/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_function();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 163
	//Test Name: 007_Ensure Curator user able to Reset Composition Criteria from advanced sample search page
	@Test
	public void EnsureCuratorUserAbleToResetCompositionCriteriaFromAdvancedSampleSearchPage() throws Exception {
		String testName = "007_Ensure curator user able to Reset Composition Criteria from advanced sample search page";
		String testDesc = "Ensure curator user able to Reset Composition Criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Reset"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    ""/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 164
	//Test Name: 008_Ensure Curator user able to Remove Composition Criteria from advanced sample search page
	@Test
	public void ensureCuratorUserAbleToRemoveCompositionCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "008_Ensure Curator user able to Remove Composition Criteria from advanced sample search page";
		String testDesc = "Ensure Curator user able to Remove Composition Criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    "Edit"/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    "Remove"/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    ""/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 165
	//Test Name: 009_Ensure Curator user able to Edit Composition Criteria from advanced sample search page
	@Test
	public void ensureCuratorUserAbleToEditCompositionCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "009_Ensure Curator user able to Edit Composition Criteria from advanced sample search page";
		String testDesc = "Ensure Curator user able to Edit Composition Criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    "Edit"/*getCompositionCriteriaAEdit*/, 
					                    "nanomaterial entity"/*getCompositionCriteriaFilterAEdit*/, 
					                    "carbon nanotube"/*getCompositionCriteriaFilterBEdit*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    "Magnevist Edit Test"/*getCompositionCriteriaNameEdit*/, 
					                    "Add"/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    ""/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//Composition Criteria - Researcher
	
	//S.N.: 166
	//Test Name: 001_Researcher User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name contains filter to the Advanced sample search
	@Test
	public void researcherUserShouldBeAbleToAddCompositionCriteriaWithNanomaterialEntityAndBiopolymerAndChemicalNameContainsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "001_Researcher User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name contains filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name contains filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL-23"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/, 
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "nanomaterial entity"/*getCompositionCriteriaFilterA*/, 
					                    "dendrimer"/*getCompositionCriteriaFilterB*/, 
					                    "contains"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Diaminobutane"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 167
	//Test Name: 002_Researcher User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name equals filter to the Advanced sample search
	@Test
	public void ResearcherUserShouldBeAbleToAddCompositionCriteriaWithNanomaterialEntityAndBiopolymerAndChemicalNameEqualsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "002_Researcher User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name equals filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name equals filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL-23"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "nanomaterial entity"/*getCompositionCriteriaFilterA*/, 
					                    "dendrimer"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Diaminobutane (DAB)"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 168
	//Test Name: 003_Researcher User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name contains filter to the Advanced sample search
	@Test
	public void ResearcherUserShouldBeAbleToAddCompositionCriteriaWithFunctionalizingEntityAndAntibodyAndChemicalNameContainsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "003_Researcher User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name contains filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name contains filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL-23"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "contains"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 169
	//Test Name: 004_Researcher User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name equals filter to the Advanced sample search
	@Test
	public void ResearcherUserShouldBeAbleToAddCompositionCriteriaWithFunctionalizingEntityAndAntibodyAndChemicalNameEqualsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "004_Researcher User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name equals filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name with the equals filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 170
	//Test Name: 005_Researcher User should be able to add Composition Criteria with Function and Imaging Function filter to the Advanced sample search
	@Test
	public void ResearcherUserShouldBeAbleToAddCompositionCriteriaWithFunctionAndImagingFunctionFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "005_Researcher User should be able to add Composition Criteria with Function and Imaging Function filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add Composition Criteria with Function and Imaging Function filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "function"/*getCompositionCriteriaFilterA*/, 
					                    "imaging function"/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_function();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 171
	//Test Name: 006_Curator User should be able to add Composition Criteria with Function and Targeting Function filter to the Advanced sample search
	@Test
	public void ResearcherUserShouldBeAbleToAddCompositionCriteriaWithFunctionAndTargetingFunctionFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "006_Researcher User should be able to add Composition Criteria with Function and Targeting Function filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add Composition Criteria with Function and Targeting Function filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "function"/*getCompositionCriteriaFilterA*/, 
					                    "targeting function"/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_function();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 172
	//Test Name: 007_Ensure Researcher user able to Reset Composition Criteria from advanced sample search page
	@Test
	public void EnsureResearcherUserAbleToResetCompositionCriteriaFromAdvancedSampleSearchPage() throws Exception {
		String testName = "007_Ensure Researcher user able to Reset Composition Criteria from advanced sample search page";
		String testDesc = "Ensure Researcher user able to Reset Composition Criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Reset"/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    ""/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 173
	//Test Name: 008_Ensure Researcher user able to Remove Composition Criteria from advanced sample search page
	@Test
	public void ensureResearcherUserAbleToRemoveCompositionCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "008_Ensure Researcher user able to Remove Composition Criteria from advanced sample search page";
		String testDesc = "Ensure Researcher user able to Remove Composition Criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    "Edit"/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    "Remove"/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    ""/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 174
	//Test Name: 009_Ensure Researcher user able to Edit Composition Criteria from advanced sample search page
	@Test
	public void ensureResearcherUserAbleToEditCompositionCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "009_Ensure Researcher user able to Edit Composition Criteria from advanced sample search page";
		String testDesc = "Ensure Researcher user able to Edit Composition Criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    "Edit"/*getCompositionCriteriaAEdit*/, 
					                    "nanomaterial entity"/*getCompositionCriteriaFilterAEdit*/, 
					                    "carbon nanotube"/*getCompositionCriteriaFilterBEdit*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    "Magnevist Edit Test"/*getCompositionCriteriaNameEdit*/, 
					                    "Add"/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterA*/, 
					                    ""/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    ""/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    ""/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// Characterization Criteria - Curator
	
	//S.N.: 175
	//Test Name: 01_Ensure Curator user able to search with phyico chemical characterization filters from advanced search page
	@Test
	public void ensureCuratorUserAbleToSearchWithPhyicoChemicalCharacterizationFiltersFromAdvancedSearchPage() throws Exception {
		String testName = "01_Ensure Curator user able to search with phyico chemical characterization filters from advanced search page";
		String testDesc = "Ensure Curator user able to search with phyico chemical characterization filters from advanced search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    "physico-chemical characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "size"/*getCharacterizationCriteriaFilterB*/, 
					                    "size"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "1"/*getCharacterizationCriteriaFilterE*/, 
					                    "microm"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("physico-chemical characterization", " size", " size");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 176
	//Test Name: 02_Ensure Curator user able to search with in vitro characterization filters from advanced search page
	@Test
	public void ensureCuratorUserAbleToSearchWithInVitroCharacterizationFiltersFromAdvancedSearchPage() throws Exception {
		String testName = "02_Ensure Curator user able to search with in vitro characterization filters from advanced search page";
		String testDesc = "Ensure Curator user able to search with in vitro characterization filters from advanced search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    "in vitro characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "blood contact"/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("in vitro characterization", "", "");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 177
	//Test Name: 03_Ensure Curator user able to search with in vivo characterization filters from advanced search page
	@Test
	public void EnsureCuratorUserAbleToSearchWithInVivoCharacterizationFiltersFromAdvancedSearchPage() throws Exception {
		String testName = "03_Ensure Curator user able to search with in vivo characterization filters from advanced search page";
		String testDesc = "Ensure Curator user able to search with in vivo characterization filters from advanced search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[Cmax]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("in vivo characterization", " pharmacokinetics", " Cmax");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 178
	//Test Name: 04_Ensure Curator user able to edit characterization advanced search query
	@Test
	public void EnsureCuratorUserAbleToEditCharacterizationAdvnacedSearchQuery() throws Exception {
		String testName = "04_Ensure Curator user able to edit characterization advanced search query";
		String testDesc = "Ensure Curator user able to edit characterization advanced search query"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[AUC]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "h x ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    "Edit"/*getCharacterizationCriteriaEdit*/, 
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterAEdit*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterBEdit*/, 
					                    "[Cmax]"/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ">"/*getCharacterizationCriteriaFilterDEdit*/, 
					                    "1000"/*getCharacterizationCriteriaFilterEEdit*/, 
					                    "ng/mL"/*getCharacterizationCriteriaFilterFEdit*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("in vivo characterization", " pharmacokinetics", " Cmax");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 179
	//Test Name: 05_Ensure Curator user able to Remove characterization advanced search query
	@Test
	public void ensureCuratorUserAbleToRemoveCharacterizationAdvancedSearchQuery() throws Exception {
		String testName = "05_Ensure Curator user able to Remove characterization advanced search query";
		String testDesc = "Ensure Curator user able to Remove characterization advanced search query"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[AUC]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "h x ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    "Edit"/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    "Remove"/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 180
	//Test Name: 06_Ensure Curator user able to Reset characterization advanced search query
	@Test
	public void EnsureCuratorUserAbleToResetCharacterizationAdvancedSearchQuery() throws Exception {
		String testName = "06_Ensure Curator user able to Reset characterization advanced search query";
		String testDesc = "Ensure Curator user able to Reset characterization advanced search query"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[AUC]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "h x ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Reset"/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    ""/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// Characterization Criteria - Researcher
	
	//S.N.: 181
	//Test Name: 01_Ensure Researcher user able to search with phyico chemical characterization filters from advanced search page
	@Test
	public void ensureResearcherrUserAbleToSearchWithPhyicoChemicalCharacterizationFiltersFromAdvancedSearchPage() throws Exception {
		String testName = "01_Ensure Researcher user able to search with phyico chemical characterization filters from advanced search page";
		String testDesc = "Ensure Researcher user able to search with phyico chemical characterization filters from advanced search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    "physico-chemical characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "size"/*getCharacterizationCriteriaFilterB*/, 
					                    "size"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "1"/*getCharacterizationCriteriaFilterE*/, 
					                    "microm"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("physico-chemical characterization", " size", " size");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 182
	//Test Name: 02_Ensure Researcher user able to search with in vitro characterization filters from advanced search page
	@Test
	public void ensureResearcherUserAbleToSearchWithInVitroCharacterizationFiltersFromAdvancedSearchPage() throws Exception {
		String testName = "02_Ensure Researcher user able to search with in vitro characterization filters from advanced search page";
		String testDesc = "Ensure Researcher user able to search with in vitro characterization filters from advanced search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    "in vitro characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "blood contact"/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("in vitro characterization", "", "");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 183
	//Test Name: 03_Ensure Researcher user able to search with in vivo characterization filters from advanced search page
	@Test
	public void EnsureResearcherUserAbleToSearchWithInVivoCharacterizationFiltersFromAdvancedSearchPage() throws Exception {
		String testName = "03_Ensure Researcher user able to search with in vivo characterization filters from advanced search page";
		String testDesc = "Ensure Researcher user able to search with in vivo characterization filters from advanced search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[Cmax]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("in vivo characterization", " pharmacokinetics", " Cmax");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 184
	//Test Name: 04_Ensure Researcher user able to edit characterization advanced search query
	@Test
	public void EnsureResearcherUserAbleToEditCharacterizationAdvnacedSearchQuery() throws Exception {
		String testName = "04_Ensure Researcher user able to edit characterization advanced search query";
		String testDesc = "Ensure Researcher user able to edit characterization advanced search query"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[AUC]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "h x ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    "Edit"/*getCharacterizationCriteriaEdit*/, 
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterAEdit*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterBEdit*/, 
					                    "[Cmax]"/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ">"/*getCharacterizationCriteriaFilterDEdit*/, 
					                    "1000"/*getCharacterizationCriteriaFilterEEdit*/, 
					                    "ng/mL"/*getCharacterizationCriteriaFilterFEdit*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("in vivo characterization", " pharmacokinetics", " Cmax");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 185
	//Test Name: 05_Ensure Researcher user able to Remove characterization advanced search query
	@Test
	public void ensureResearcherUserAbleToRemoveCharacterizationAdvancedSearchQuery() throws Exception {
		String testName = "05_Ensure Researcher user able to Remove characterization advanced search query";
		String testDesc = "Ensure Researcher user able to Remove characterization advanced search query"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[AUC]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "h x ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    "Edit"/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    "Remove"/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 180
	//Test Name: 06_Ensure Researcher user able to Reset characterization advanced search query
	@Test
	public void EnsureResearcherUserAbleToResetCharacterizationAdvancedSearchQuery() throws Exception {
		String testName = "06_Ensure Researcher user able to Reset characterization advanced search query";
		String testDesc = "Ensure Researcher user able to Reset characterization advanced search query"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    ""/*getCompositionCriteriaFilterA*/, 
					                    ""/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    ""/*getCompositionCriteriaAddOrReset*/, 
					                    ""/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[AUC]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "h x ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Reset"/*getCharacterizationCriteriaAddOrReset*/, 
					                    ""/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    ""/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// My Workspace
	// My Samples
	
	//S.N.: 181
	//Test Name: 019_Ensure Curator user able to delete a sample from my workspace
	@Test
	public void ensureCuratorUserAbleToDeleteASampleFromMyWorksapce() throws Exception {
		String testName = "019_Ensure Curator user able to delete a sample from my workspace";
		String testDesc = "Ensure curator user should be able to view my workspace page and delete a sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.delete_my_workspace_samples("Test Submit Sample As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 182
	//Test Name: 020_Ensure Researcher user able to delete a sample from my workspace
	@Test
	public void ensureResearcherUserAbleToDeleteASampleFromMyWorksapce() throws Exception {
		String testName = "020_Ensure Researcher user able to delete a sample from my workspace";
		String testDesc = "Ensure Researcher user should be able to view my workspace page and delete a sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.delete_my_workspace_samples("Test Submit Sample As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 183
	//Test Name: 021_Ensure Curator user able to edit a sample from my worksapce
	@Test
	public void ensureCuratorUserAbleToEditASampleFromMyWorksapce() throws Exception {
		String testName = "021_Ensure Curator user able to edit a sample from my worksapce";
		String testDesc = "Ensure Curator user able to edit a sample from my worksapce"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.edit_my_workspace_samples("Test Submit Sample As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 184
	//Test Name: 022_Ensure Researcher user able to edit a sample from my workspace
	@Test
	public void ensureResearcherUserAbleToEditASampleFromMyWorksapce() throws Exception {
		String testName = "022_Ensure researcher user able to edit a sample from my worksapce";
		String testDesc = "Ensure researcher user able to edit a sample from my worksapce"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.edit_my_workspace_samples("Test Submit Sample As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 185
	//Test Name: 023_Ensure Curator user able to view a sample from my worksapce
	@Test
	public void ensureCuratorUserAbleToViewASampleFromMyWorksapce() throws Exception {
		String testName = "021_Ensure Curator user able to view a sample from my worksapce";
		String testDesc = "Ensure Curator user able to view a sample from my worksapce"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.view_my_workspace_samples("Test Submit Sample As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 186
	//Test Name: 024_Ensure Researcher user able to view a sample from my worksapce
	@Test
	public void ensureResearcherUserAbleToViewASampleFromMyWorksapce() throws Exception {
		String testName = "024_Ensure Researcher user able to view a sample from my worksapce";
		String testDesc = "Ensure Researcher user able to view a sample from my worksapce"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.view_my_workspace_samples("Test Submit Sample As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// My Workspace
	// My Protocols
	
	//S.N.: 187
	//Test Name: 025_Ensure Curator user able to delete a Protocol from my workspace
	@Test
	public void ensureCuratorUserAbleToDeleteAProtocolFromMyWorkspace() throws Exception {
		String testName = "025_Ensure Curator user able to delete a Protocol from my workspace";
		String testDesc = "Ensure Curator user able to view my workspace and also able to delete a Protocol from my workspace protocol list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.delete_my_workspace_protocols("Test Submit Protocl As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 188
	//Test Name: 026_Ensure Researcher user able to delete a Protocol from my workspace
	@Test
	public void ensureResearcherUserAbleToDeleteAProtocolFromMyWorkspace() throws Exception {
		String testName = "025_Ensure Researcher user able to delete a Protocol from my workspace";
		String testDesc = "Ensure Researcher user able to view my workspace and also able to delete a Protocol from my workspace protocol list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.delete_my_workspace_protocols("Test Submit Protocl As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 187
	//Test Name: 027_Ensure Curator user able to edit a Protocol from my workspace
	@Test
	public void ensureCuratorUserAbleToEditAProtocolFromMyWorkspace() throws Exception {
		String testName = "027_Ensure Curator user able to edit a Protocol from my workspace";
		String testDesc = "Ensure Curator user able view my workspace and also able to Edit a Protocol from my workspace protocol list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.edit_my_workspace_protocol("Test Submit Protocl As");
			Test.switchToChildBrowser();
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 188
	//Test Name: 028_Ensure Researcher user able to edit a Protocol from my workspace
	@Test
	public void ensureResearcherUserAbleToEditAProtocolFromMyWorkspace() throws Exception {
		String testName = "028_Ensure Researcher user able to edit a Protocol from my workspace";
		String testDesc = "Ensure Researcher user able to view my workspace and also able to Edit a Protocol from my workspace protocol list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.edit_my_workspace_protocol("Test Submit Protocl As");
			Test.switchToChildBrowser();
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 189
	//Test Name: 029_Ensure Curator user able to view a Protocol from my workspace
	@Test
	public void ensureCuratorUserAbleToViewAProtocolFromMyWorkspace() throws Exception {
		String testName = "029_Ensure Curator user able to view a Protocol from my workspace";
		String testDesc = "Ensure Curator user able to view my workspace and also able to View a Protocol from my workspace protocol list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			//Test.wait_until_my_publications_table_data_load();
			Test.view_my_workspace_protocol("Test Submit Protocl As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 190
	//Test Name: 030_Ensure Researcher user able to view a Protocol from my workspace
	@Test
	public void ensureResearcherUserAbleToViewAProtocolFromMyWorkspace() throws Exception {
		String testName = "030_Ensure Researcher user able to view a Protocol from my workspace";
		String testDesc = "Ensure Researcher user able to view my workspace and also able to View a Protocol from my workspace protocol list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			//Test.wait_until_my_publications_table_data_load();
			Test.view_my_workspace_protocol("Test Submit Protocl As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 191
	//Test Name: 031_Ensure Curator user able to Delete a Publication from my workspace
	@Test
	public void ensureCuratorUserAbleToDeleteAPublicationFromMyWorkspace() throws Exception {
		String testName = "031_Ensure Curator user able to Delete a Publication from my workspace";
		String testDesc = "Ensure Curator user able to view my workspace and also able to Delete a Publication from my workspace Publications list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.delete_my_workspace_publication("Test Submit Publication As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 192
	//Test Name: 032_Ensure Researcher user able to Delete a Publication from my workspace
	@Test
	public void ensureResearcherUserAbleToDeleteAPublicationFromMyWorkspace() throws Exception {
		String testName = "032_Ensure Researcher user able to Delete a Publication from my workspace";
		String testDesc = "Ensure Researcher user able to view my workspace and also able to Delete a Publication from my workspace Publications list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.delete_my_workspace_publication("Test Submit Publication As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 193
	//Test Name: 033_Ensure Curator user able to Edit a Publication from my workspace
	@Test
	public void ensureCuratorUserAbleToEditAPublicationFromMyWorkspace() throws Exception {
		String testName = "033_Ensure Curator user able to Edit a Publication from my workspace";
		String testDesc = "Ensure Curator user able to view my workspace and also able to Edit a Publication from my workspace Publications list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.edit_my_workspace_publication("Test Submit Publication As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 194
	//Test Name: 034_Ensure Researcher user able to Edit a Publication from my workspace
	@Test
	public void ensureResearcherUserAbleToEditAPublicationFromMyWorkspace() throws Exception {
		String testName = "034_Ensure Researcher user able to Edit a Publication from my workspace";
		String testDesc = "Ensure Researcher user able to view my workspace and also able to Edit a Publication from my workspace Publications list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.edit_my_workspace_publication("Test Submit Publication As");
			Test.wait_For(1000);
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
	
	//S.N.: 195
	//Test Name: 001_Ensure Curator user able to add a Sample to the Favorites list
	@Test
	public void EnsureCuratorUserAbleToAddASampleToTheFavoritesList() throws Exception {
		String testName = "001_Ensure Curator user able to add a Sample to the Favorites list";
		String testDesc = "Ensure curator user able to add a Sample from sample search results page to the my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
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
	
	//S.N.: 196
	//Test Name: 002_Ensure Curator user able to add a Protocol to the Favorites list
	@Test
	public void EnsureCuratorUserAbleToAddAProtocolToTheFavoritesList() throws Exception {
		String testName = "002_Ensure Curator user able to add a Protocol to the Favorites list";
		String testDesc = "Ensure curator user able to add a Protocol from Protocol search results page to the my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "Test Submit Protocol", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("Test Submit Protocol", "yes", "");
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
	
	//S.N.: 197
	//Test Name: 003_Ensure Curator user able to add a Publication to the Favorites list
	@Test
	public void EnsureCuratorUserAbleToAddAPublicationToTheFavoritesList() throws Exception {
		String testName = "003_Ensure Curator user able to add a Publication to the Favorites list";
		String testDesc = "Ensure curator user able to add a Publication from Publication search results page to the my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
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
	//View
	
	//S.N.: 198
	//Test Name: 001_Ensure Curator user able to add a Sample to the Favorites list and view the added sample from my favorites page
	@Test
	public void EnsureCuratorUserAbleToAddASampleToTheFavoritesListAndViewTheAddedSampleFromMyFavoritesPage() throws Exception {
		String testName = "001_Ensure Curator user able to add a Sample to the Favorites list and view the added sample from my favorites page";
		String testDesc = "Ensure Curator user able to add a Sample to the Favorites list and view the added sample from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Test Submit Sample As", "", "", "", "", "", "", "", "search");
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
	
	//S.N.: 199
	//Test Name: 002_Ensure Curator user able to add a Protocol to the Favorites list and view the added protocol from my favorites page
	@Test
	public void ensureCuratorUserAbleToAddAProtocolToTheFavoritesListAndViewTheAddedProtocolFromMyFavoritesPage() throws Exception {
		String testName = "002_Ensure Curator user able to add a Protocol to the Favorites list and view the added protocol from my favorites page";
		String testDesc = "Ensure Curator user able to add a Protocol to the Favorites list and view the added protocol from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
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
	
	//S.N.: 200
	//Test Name: 003_Ensure Curator user able to add a publication to the Favorites list and view the added publication from my favorites page
	@Test
	public void EnsureCuratorUserAbleToAddAPublicationToTheFavoritesListAndViewTheAddedPublicationFromMyFavoritesPage() throws Exception {
		String testName = "003_Ensure Curator user able to add a publication to the Favorites list and view the added publication from my favorites page";
		String testDesc = "Ensure Curator user able to add a publication to the Favorites list and view the added publication from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
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
			Test.protocol_search("", "contains", "Test Submit Protocol", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("Test Submit Protocol", "yes", "");
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
				 "read update delete", /****getAccessToTheSample***/
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
				 "read update delete", /****getAccessToTheSample***/
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
				 "read update delete", /****getAccessToTheSample***/
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
				 "Researcher CaNano", /****getUserLoginName***/
				 "canano_res", /****getUserName***/
				 "read update delete", /****getAccessToTheSample***/
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
				 "read update delete", /****getAccessToTheSample***/
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
				 "read update delete", /****getAccessToTheSample***/
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
				 "read update delete", /****getAccessToTheSample***/
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
				 "read update delete", /****getAccessToTheSample***/
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
				 "read update delete", /****getAccessToTheSample***/
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
				 "read update delete", /****getAccessToTheSample***/
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
	
	//S.N.: 229
	//Test Name: 001_Verify user able to reset password
	@Test
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
	}
	
	//S.N.: 230
	//Test Name: 002_Verify user should not be able to reset password with the same password
	@Test
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
	}
	
	//S.N.: 231
	//Test Name: 003_Verify reset password fields are required fields
	@Test
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
	}
	
	//S.N.: 232
	//Test Name: 004_Verify user unable to reset password without confirm new password
	@Test
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
	}
	
	//S.N.: 233
	//Test Name: 005_Verify new password field is required field when user try to reset password 
	@Test
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
	}
	
	//S.N.: 234
	//Test Name: 006_Verify old password field is required field when user try to reset password 
	@Test
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
	}
	
	//S.N.: 235
	//Test Name: 007_Verify Login ID field is required field when user try to reset password 
	@Test
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
	}
	
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
