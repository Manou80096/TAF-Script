package com.scripted.demodefs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;

import com.scripted.web.BrowserDriver;

public class Test {

	static WebDriver driver;
	public static void main(String[] args) {
		try {
			driver = BrowserDriver.funcGetWebdriver();
			BrowserDriver.launchWebURL("http://google.com");
			driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input[0]"));
		} catch (Exception e) {
			System.out.println(e);
			String exp = e.toString();
			String[] lines = exp.split("Session ID:");
			for (String s1 : lines) {
				System.out.println("-----------------------------------");
				System.out.println(s1);
				if (s1.contains("***")) {
					String[] split = s1.split("/*/*/* Element info:");
					String sessionId = split[0];
					System.out.println(sessionId.replace("***", ""));
					//createDriverFromSession(sessionId.replace("***", ""));
					
				}
			}
		}
	}

	public static RemoteWebDriver createDriverFromSession(final SessionId sessionId, URL command_executor){
	    CommandExecutor executor = new HttpCommandExecutor(command_executor) {

	    @Override
	    public Response execute(Command command) throws IOException {
	        Response response = null;
	        if (command.getName() == "newSession") {
	            response = new Response();
	            response.setSessionId(sessionId.toString());
	            response.setStatus(0);
	            response.setValue(Collections.<String, String>emptyMap());

	            try {
	                Field commandCodec = null;
	                commandCodec = this.getClass().getSuperclass().getDeclaredField("commandCodec");
	                commandCodec.setAccessible(true);
	                commandCodec.set(this, new W3CHttpCommandCodec());

	                Field responseCodec = null;
	                responseCodec = this.getClass().getSuperclass().getDeclaredField("responseCodec");
	                responseCodec.setAccessible(true);
	                responseCodec.set(this, new W3CHttpResponseCodec());
	            } catch (NoSuchFieldException e) {
	                e.printStackTrace();
	            } catch (IllegalAccessException e) {
	                e.printStackTrace();
	            }

	        } else {
	            response = super.execute(command);
	        }
	        return response;
	    }
	    };

	    return new RemoteWebDriver(executor, new DesiredCapabilities());
	}
	
	public static SessionId getSessionId(String str) {
		  return new SessionId(str);
		}
}


