package com.scripted.testscripts;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scripted.PDF.PDFReportListner;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

	@Listeners({ PDFReportListner.class })
	@Epic("Function Tests")
	@Feature("To Validate Data in a given excel")
	public class TC001PDFReport extends BaseTest {
		Generic g = new Generic();
		@Test(priority = 0, description = "Get the null values in the question text column")
		@Severity(SeverityLevel.CRITICAL)
		public void nullCheck() {
			g.blankCheck();
		}

		@Test(priority = 1, description = "Get the blank values in the question text column")
		@Severity(SeverityLevel.BLOCKER)

		public void blankCheck() {
			g.getExcelData();
		}
		
		@Test(priority = 2, description = "Assert the browser title")
		@Severity(SeverityLevel.BLOCKER)

		public void browserCheck() throws Exception{
			g.browserCheck();
		}
		@Test
		public void testCaseSkipException(){
				throw new SkipException("Skipping this exception");
			}
	}

	
