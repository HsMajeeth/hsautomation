package action_driver;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import action_Package.Action_Interface;
import baseClass.BaseClass;


public class Action_class extends BaseClass implements Action_Interface{

	@Override
	public void click(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();


	}

	@Override
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	@Override
	public boolean isDisplayed(WebDriver driver, WebElement ele) {

		boolean flag = false;

		try {
			// Check if the element is displayed
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("Element is Displayed");
			} else {
				System.out.println("Element is not Displayed");
			}
		} catch (Exception e) {
			// Handle exceptions like NoSuchElementException
			System.out.println("Element is not found: " + e.getMessage());
			flag = false;
		}

		return flag;

	}

	@Override
	public boolean type(WebElement ele, String text) {

		boolean flag = false;
		try {
			// Check if the element is displayed
			if (ele.isDisplayed()) {
				ele.clear(); // Clear existing text
				ele.sendKeys(text); // Type the desired text
				System.out.println("Typed successfully");
				flag = true; // Update flag to true for successful operation
			}
		} catch (Exception e) {
			// Handle any exceptions (e.g., NoSuchElementException)
			System.out.println("Location not found: " + e.getMessage());
			flag = false; // Ensure flag remains false in case of failure
		}
		return flag; // Return whether the operation was successful

	}



	@Override
	public boolean findElement(WebDriver driver, WebElement ele) {

		boolean flag = false;
		try {
			// Check if the element is displayed
			flag = ele.isDisplayed();
		} catch (Exception e) {
			// Handle exceptions, e.g., NoSuchElementException
			System.out.println("Exception occurred while locating the element: " + e.getMessage());
			flag = false;
		} finally {
			// Log the result
			System.out.println("The element is " + (flag ? "Displayed" : "Not Displayed"));
		}
		return flag; // Return the final status
	}



	@Override
	public boolean isSelected(WebDriver driver, WebElement ele) {

		boolean flag = false;

		try {
			// Check if element is displayed first
			if (ele.isDisplayed()) {
				// Check if element is selected
				flag = ele.isSelected();
			}
		} catch (Exception e) {
			// Log exception details
			System.out.println("Exception while checking element selection: " + e.getMessage());
			flag = false;
		} finally {
			// Print the result in a clean manner
			System.out.println("The element is " + (flag ? "Successfully Selected" : "Not Selected"));
		}

		return flag; // Return the result
	}



	@Override
	public boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean flag = false;

		try {
			// Check if the element is displayed and enabled
			if (ele.isDisplayed()) {
				flag = ele.isEnabled();
			}
		} catch (Exception e) {
			// Log the exception details
			System.out.println("Exception occurred while checking element status: " + e.getMessage());
			flag = false;
		} finally {
			// Print the result
			System.out.println("The element is " + (flag ? "Enabled" : "Not Enabled"));
		}

		return flag; // Return the final status
	}

	@Override
	public boolean selectBySendkeys(String value, WebElement ele) {
		
		    boolean flag = false;
		    try {
		        // Attempt to send the value to the element
		        ele.sendKeys(value);
		        flag = true;
		    } catch (Exception e) {
		        // Log the exception for debugging purposes
		        System.out.println("Exception occurred while sending keys: " + e.getMessage());
		        flag = false;
		    } finally {
		        // Log the status of the operation
		        System.out.println(flag ? "Selected successfully" : "Not selected");
		    }
		    return flag; // Return the final status
		}



	

	@Override
	public boolean selectByIndex(WebElement element, int index) {
		
		    boolean flag = false;

		    try {
		        // Create Select object for the dropdown
		        Select s = new Select(element);
		        
		        // Select option by index
		        s.selectByIndex(index);
		        
		        // Update flag to true if selection is successful
		        flag = true;
		    } catch (Exception e) {
		        // Handle exceptions and log the message
		        System.out.println("Exception occurred while selecting the index: " + e.getMessage());
		    } finally {
		        // Log the selection result
		        System.out.println(flag ? "Selected successfully" : "Not selected");
		    }

		    // Return the final status
		    return flag;
		}

	

	@Override
	public boolean selectByValue(WebElement element, String value) {
	    boolean flag = false;
	    try {
	        // Create Select object for the dropdown
	        Select s = new Select(element);
	        
	        // Select the option by value
	        s.selectByValue(value);
	        
	        // Mark flag as true if selection succeeds
	        flag = true;
	    } catch (Exception e) {
	        // Log exception details for debugging
	        System.out.println("Exception occurred while selecting by value: " + e.getMessage());
	        flag = false;
	    } finally {
	        // Print selection status
	        System.out.println(flag ? "Selected successfully" : "Not selected");
	    }

	    // Return the final status
	    return flag;
	}



	

	@Override
	public boolean selectByVisibleText(String visibleText, WebElement ele) {
	    boolean flag = false;
	    try {
	        // Create a Select object for the dropdown
	        Select s = new Select(ele);
	        
	        // Select the option by visible text
	        s.selectByVisibleText(visibleText);
	        flag = true; // Update flag to true upon success
	    } catch (Exception e) {
	        // Log the exception for debugging
	        System.out.println("Exception occurred while selecting by visible text: " + e.getMessage());
	        flag = false; // Ensure flag remains false in case of failure
	    } finally {
	        // Log whether the selection was successful
	        System.out.println(flag ? "Selected successfully" : "Not selected");
	    }

	    // Return the final status
	    return flag;
	}


	@Override
	public boolean mouseHoverByJavaScript(WebDriver driver, WebElement ele) {
	    boolean flag = false;
	    try {
	        // Casting WebDriver to JavascriptExecutor
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Executing JavaScript to hover over the element
	        String mouseOverScript = "var event = new MouseEvent('mouseover', {view: window, bubbles: true, cancelable: true});" +
	                                 "arguments[0].dispatchEvent(event);";
	        js.executeScript(mouseOverScript, ele);

	        flag = true; // If no exception occurs, set flag to true
	    } catch (Exception e) {
	        // Log the exception if any issues occur
	        System.out.println("Exception while performing mouse hover: " + e.getMessage());
	        flag = false; // Ensure flag remains false in case of failure
	    }
	    return flag; // Return the result
	}



	

	@Override
	public boolean JSClick(WebDriver driver, WebElement ele) {
	    boolean flag = false;

	    try {
	        // Cast WebDriver to JavascriptExecutor
	        JavascriptExecutor executor = (JavascriptExecutor) driver;
	        
	        // Execute JavaScript click action
	        executor.executeScript("arguments[0].click();", ele);
	        flag = true; // Mark flag as true on success
	    } catch (Exception e) {
	        // Log exception details for debugging
	        System.out.println("Exception occurred during JavaScript click: " + e.getMessage());
	    } finally {
	        // Log whether the click action was successful
	        System.out.println(flag ? "Click action is performed" : "Click action is not performed");
	    }

	    return flag; // Return the final status
	}

	


	@Override
	public boolean switchToFrameByIndex(WebDriver driver, int index) {
		
	    boolean flag = false;
	    try {
	        // Explicit wait to ensure the frame is available
	      // Timeout of 10 seconds
	    	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(4));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));

	        // Switch to the frame
	        driver.switchTo().frame(index);
	        flag = true;
	    } catch (NoSuchFrameException e) {
	        // Log an error if the frame is not found
	        System.out.println("No such frame found with index: " + index + ". Exception: " + e.getMessage());
	    } catch (Exception e) {
	        // Log any other exceptions
	        System.out.println("Exception occurred while switching to frame: " + index + ". Exception: " + e.getMessage());
	    } finally {
	        // Log the result
	        System.out.println(flag ? "Switched to frame " + index + " successfully." : "Unable to switch to frame " + index + ".");
	    }
	    return flag; // Return the result
	}

	

	@Override
	public boolean switchToFrameById(WebDriver driver, String idValue) {


		boolean flag = false;

	    try {
	        // Explicit wait with Duration to ensure the frame is available
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for 10 seconds
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idValue));

	        // Switch to the frame by ID or name
	        driver.switchTo().frame(idValue);
	        flag = true;
	    } catch (NoSuchFrameException e) {
	        // Log a specific exception for missing frames
	        System.out.println("No such frame found with ID: " + idValue + ". Exception: " + e.getMessage());
	    } catch (Exception e) {
	        // Log any other exceptions
	        System.out.println("Exception occurred while switching to frame with ID: " + idValue + ". Exception: " + e.getMessage());
	    } finally {
	        // Log whether the switch was successful
	        System.out.println(flag ? "Switched to frame with ID " + idValue + " successfully." : "Unable to switch to frame with ID " + idValue + ".");
	    }

	    return flag; // Return the final status
	}


	@Override
	public boolean switchToFrameByName(WebDriver driver, String nameValue) {

		boolean flag = false;

	    try {
	        // Explicit wait with Duration to ensure the frame is available
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10-second timeout
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameValue));

	        // Switch to the frame by name
	        driver.switchTo().frame(nameValue);
	        flag = true;
	    } catch (NoSuchFrameException e) {
	        // Log the specific exception if the frame is not found
	        System.out.println("No such frame found with name: " + nameValue + ". Exception: " + e.getMessage());
	    } catch (Exception e) {
	        // Log any other exceptions
	        System.out.println("Exception occurred while switching to frame with name: " + nameValue + ". Exception: " + e.getMessage());
	    } finally {
	        // Log the operation result
	        System.out.println(flag ? "Switched to frame with name \"" + nameValue + "\" successfully." : "Unable to switch to frame with name \"" + nameValue + "\".");
	    }

	    return flag; // Return the result
	}

	@Override
	public boolean switchToDefaultFrame(WebDriver driver) {
		 boolean flag = false;

		    try {
		        // Switch to the default content of the page
		        driver.switchTo().defaultContent();
		        flag = true;
		    } catch (Exception e) {
		        // Log any exception (No InterruptedException here since it's irrelevant)
		        System.out.println("Exception occurred while switching to default frame: " + e.getMessage());
		    } finally {
		        // Log the result
		        System.out.println(flag ? "Switched to the default frame successfully." : "Failed to switch to the default frame.");
		    }

		    return flag;
		}
	

	@Override
	public void mouseOverElement(WebDriver driver, WebElement element) {
		boolean flag = false;
	    try {
	        // Perform the mouse hover action using Actions class
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element).build().perform();
	        flag = true;
	    } catch (Exception e) {
	        // Log the exception for debugging purposes
	        System.out.println("Exception occurred while performing MouseOver: " + e.getMessage());
	    } finally {
	        // Log success or failure
	        System.out.println(flag ? "MouseOver action performed successfully." : "MouseOver action failed.");
	    }
	}

	

	@Override
	public boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
	    try {
	        // Scroll the element into view using JavaScript
	        JavascriptExecutor executor = (JavascriptExecutor) driver;
	        executor.executeScript("arguments[0].scrollIntoView(true);", ele);

	        // Perform the move-to-element action using Actions
	        Actions actions = new Actions(driver);
	        actions.moveToElement(ele).build().perform();

	        flag = true; // Mark as successful
	    } catch (Exception e) {
	        // Log the exception for debugging
	        System.out.println("Exception occurred while moving to the element: " + e.getMessage());
	    }
	    return flag; // Return the success status
	}

	@Override
	public boolean mouseover(WebDriver driver, WebElement ele) {

		boolean flag = false;
	    try {
	        // Perform the mouse hover action using the Actions class
	        Actions actions = new Actions(driver);
	        actions.moveToElement(ele).perform();
	        flag = true; // Set flag to true if action is successful
	    } catch (Exception e) {
	        // Log any exceptions for debugging
	        System.out.println("Exception occurred during mouseover action: " + e.getMessage());
	        flag = false; // Ensure flag remains false if an exception occurs
	    }
	    return flag; // Return the result of the mouseover operation
	}

	@Override
	public boolean draggable(WebDriver driver, WebElement source, int x, int y) {

		return false;
	}

	@Override
	public boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {

		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("DragAndDrop Action is performed");
			} else if(!flag) {
				System.out.println("DragAndDrop Action is not performed");
			}
		}

	}

	@Override
	public boolean slider(WebDriver driver, WebElement ele, int x, int y) {

		return false;
	}

	@Override
	public boolean rightclick(WebDriver driver, WebElement ele) {
		
		    boolean flag = false;
		    try {
		        // Perform right-click action using the Actions class
		        Actions act = new Actions(driver);
		        act.contextClick(ele).perform();
		        flag = true; // Mark as successful
		    } catch (Exception e) {
		        // Log the exception for debugging
		        System.out.println("Exception occurred during right-click: " + e.getMessage());
		        flag = false; // Ensure flag remains false in case of failure
		    } finally {
		        // Log whether the action was successful
		        System.out.println(flag ? "Action is performed successfully." : "Action is not performed.");
		    }
		    return flag; 
	}




	@Override
	public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
		boolean flag = false;

	    try {
	        // Retrieve all window handles
	        Set<String> windowHandles = driver.getWindowHandles();

	        // Convert the window handles set to an array
	        String[] handlesArray = windowHandles.toArray(new String[0]);

	        // Ensure the count is valid
	        if (count - 1 >= 0 && count - 1 < handlesArray.length) {
	            // Switch to the specified window by index
	            driver.switchTo().window(handlesArray[count - 1]);

	            // Check if the title matches the expected window title
	            if (driver.getTitle().contains(windowTitle)) {
	                flag = true;
	            } else {
	                flag = false;
	            }
	        } else {
	            System.out.println("Invalid window count: " + count);
	            flag = false;
	        }
	    } catch (Exception e) {
	        // Log the exception for debugging
	        System.out.println("Exception occurred while switching to the window: " + e.getMessage());
	        flag = false;
	    } finally {
	        // Log the result
	        System.out.println(flag ? "Navigated to the window with title successfully." : "The window with the specified title is not selected.");
	    }

	    return flag; // Return the result



	}

	@Override
	public boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;

	    try {
	        // Get the current window handle
	        String currentWindow = driver.getWindowHandle();

	        // Get all window handles
	        Set<String> windowHandles = driver.getWindowHandles();

	        // Loop through window handles to find the new window
	        for (String window : windowHandles) {
	            if (!window.equals(currentWindow)) {
	                driver.switchTo().window(window);
	                flag = true;
	                break;
	            }
	        }
	    } catch (Exception e) {
	        // Log the exception for debugging
	        System.out.println("Exception occurred while switching to the new window: " + e.getMessage());
	        flag = false;
	    } finally {
	        // Log the result
	        System.out.println(flag ? "Switched to the new window successfully." : "Failed to switch to the new window.");
	    }

	    return flag; // Return the result


	}

	@Override
	public boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;

	    try {
	        // Get all window handles
	        Set<String> windowHandles = driver.getWindowHandles();

	        // Switch to the first window in the set
	        String firstWindowHandle = windowHandles.iterator().next();
	        driver.switchTo().window(firstWindowHandle);

	        // Mark the operation as successful
	        flag = true;
	    } catch (Exception e) {
	        // Log the exception for debugging
	        System.out.println("Exception occurred while switching to the old window: " + e.getMessage());
	        flag = false; // Ensure flag remains false in case of failure
	    } finally {
	        // Log the result of the operation
	        System.out.println(flag ? "Focus navigated to the old window successfully." : "Failed to switch to the old window.");
	    }

	    return flag; // Return the result

	}

	@Override
	public int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
	    int columnCount = columns.size();

	    // Print the column count
	    System.out.println("Number of columns: " + columnCount);

	    // Print the text of each column separated by '|'
	    for (WebElement column : columns) {
	        System.out.print(column.getText() + " | ");
	    }
	    System.out.println(); // Newline after printing all columns

	    // Return the column count
	    return columnCount;
	}


	@Override
	public int getRowCount(WebElement table) {

		List<WebElement> rows = table.findElements(By.tagName("tr"));

	    // Return the total number of rows
	    return rows.size();
	}
	

	@Override
	public boolean Alert(WebDriver driver) {

		boolean presentFlag = false;

	    try {
	        // Check if an alert is present
	        Alert alert = driver.switchTo().alert();

	        // Accept the alert if it is present
	        alert.accept();
	        presentFlag = true; // Set flag to true if alert is handled
	    } catch (NoAlertPresentException ex) {
	        // Log when no alert is present
	        System.out.println("No alert is present: " + ex.getMessage());
	    } catch (Exception e) {
	        // Log any other exceptions
	        System.out.println("Exception occurred while handling the alert: " + e.getMessage());
	    } finally {
	        // Log whether the alert was handled
	        System.out.println(presentFlag ? "The alert was handled successfully." : "There was no alert to handle.");
	    }

	    return presentFlag; // Return the result of the alert handling
	}

	@Override
	public boolean launchUrl(WebDriver driver, String url) {
		{
		    boolean flag = false;

		    try {
		        // Launch the URL
		        driver.get(url);
		        flag = true; // Mark as successful
		    } catch (Exception e) {
		        // Log the exception for debugging
		        System.out.println("Exception occurred while launching the URL: " + e.getMessage());
		        flag = false; // Ensure the flag remains false in case of failure
		    } finally {
		        // Log the result
		        System.out.println(flag ? "Successfully launched the given URL." : "Failed to launch the given URL.");
		    }

		    return flag; // Return the status
		}
	}

	@Override
	public boolean isAlertPresent(WebDriver driver) {
		try {
	        // Attempt to switch to the alert
	        driver.switchTo().alert();
	        return true; // Return true if an alert is present
	    } catch (NoAlertPresentException e) {
	        // Return false if no alert is present
	        return false;
	    }
	}


	@Override
	public String getCurrentURL(WebDriver driver) {

		// Retrieve the current URL of the page
	    String currentURL = driver.getCurrentUrl();

	    // Log the URL
	    System.out.println("Current URL of the page is: \"" + currentURL + "\"");

	    // Return the URL
	    return currentURL;
	}
	

	@Override
	public String getTitle(WebDriver driver) {

		String title = driver.getTitle();
		System.out.println("Current Title of the page is: \"" + title + "\"");
		return title;

	}

	@Override
	public boolean click1(WebElement locator, String locatorName) {

		return false;
	}

	@Override
	public void fluentWait(WebDriver driver, WebElement element, int timeOut) {

		try {
	        // Initialize FluentWait with custom timeout and polling settings
	        Wait<WebDriver> wait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(timeOut)) // Set the maximum timeout
	                .pollingEvery(Duration.ofSeconds(2)) // Poll every 2 seconds
	                .ignoring(Exception.class); // Ignore exceptions like NoSuchElementException

	        // Wait until the element is visible
	        wait.until(ExpectedConditions.visibilityOf(element));

	        // Perform the click action on the element
	        element.click();
	        System.out.println("Element clicked successfully.");
	    } catch (Exception e) {
	        // Log any exceptions that occur
	        System.out.println("Exception occurred during fluent wait: " + e.getMessage());
	    }
	}

	@Override
	public void implicitWait(WebDriver driver, int timeOut) {

		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
		    System.out.println("Implicit wait set to " + timeOut + " seconds.");
		}

	

	@Override
	public void explicitWait(WebDriver driver, WebElement element, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@Override
	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));


	}





	@Override
	public String getCurrentTime() {

		String CurrentTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		return CurrentTime;
	}

	@Override
	public boolean clickAndHold(WebDriver driver, WebElement ele) {
	    boolean flag = false;
	    try {
	        // Perform the click-and-hold action
	        Actions actions = new Actions(driver);
	        actions.clickAndHold(ele).perform();
	        flag = true; // Mark the operation as successful
	        System.out.println("Action performed successfully.");
	    } catch (Exception e) {
	        // Log any exception
	        System.out.println("Exception occurred while performing the action: " + e.getMessage());
	        flag = false;
	    }
	    return flag; // Return the status of the operation
	}

	

	@Override
	public boolean doubleClick(WebDriver driver,WebElement ele) {
		boolean flag = false;
	    try {
	        // Perform double-click action on the given element
	        Actions actions = new Actions(driver);
	        actions.doubleClick(ele).perform();
	        flag = true; // Mark the operation as successful
	        System.out.println("Double-click action performed successfully.");
	    } catch (Exception e) {
	        // Log the exception for debugging
	        System.out.println("Exception occurred during double-click: " + e.getMessage());
	        flag = false; // Ensure flag remains false in case of failure
	    }
	    return flag; // Return the status of the operation
	}



	

	@Override
	public boolean release(WebDriver driver, WebElement ele){
		boolean flag = false;
	    try {
	        // Perform the release action using Actions class
	        Actions actions = new Actions(driver);
	        actions.release(ele).perform(); // Releases mouse button on the specified element
	        flag = true; // Mark the operation as successful
	        System.out.println("Release action performed successfully.");
	    } catch (Exception e) {
	        // Log any exception for debugging
	        System.out.println("Exception occurred during release action: " + e.getMessage());
	        flag = false;
	    }
	    return flag; // Return the status of the operation

		
	}

	@Override
	public boolean switchToNewTab(WebDriver driver, String newURL) {

		 boolean flag = false;

		    try {
		        // Open a new tab and switch to it
		        driver.switchTo().newWindow(WindowType.TAB);

		        // Navigate to the specified URL in the new tab
		        driver.get(newURL);
		        flag = true; // Mark as successful

		        // Log success message
		        System.out.println("Switched to the new tab and navigated to the URL: " + newURL);
		    } catch (Exception e) {
		        // Log exception message
		        System.out.println("Exception occurred while switching to a new tab: " + e.getMessage());
		        flag = false;
		    }
		    return flag; // Return the status of the operation
	}

	@Override
	public boolean switchToNewWindow(WebDriver driver, String newURL) {
		boolean flag = false;

	    try {
	        // Open a new browser window and switch to it
	        driver.switchTo().newWindow(WindowType.WINDOW);

	        // Navigate to the specified URL
	        driver.get(newURL);
	        flag = true; // Mark as successful
	        System.out.println("Switched to new window and navigated to URL: " + newURL);
	    } catch (Exception e) {
	        // Log any exceptions for debugging purposes
	        System.out.println("Exception occurred while switching to new window: " + e.getMessage());
	        flag = false; // Ensure the flag remains false in case of failure
	    }

	    return flag; // Return the status of the operation
	}


	@Override
	public void ScriptTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(timeOut));

	}

	@Override
	public File screenShot(WebDriver driver, String filename, WebElement ele) {

		String dateName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

	    // Capture screenshot of the WebElement
	    File src = ele.getScreenshotAs(OutputType.FILE);

	    // Define the destination file path
	    File dest = new File(System.getProperty("user.dir") + "\\Screenshots\\" + filename + "_" + dateName + ".png");

	    try {
	        // Copy the screenshot file to the destination
	        FileHandler.copy(src, dest);
	        System.out.println("Screenshot captured and saved at: " + dest.getAbsolutePath());
	    } catch (IOException e) {
	        // Log any IO exceptions
	        System.out.println("Failed to save the screenshot: " + e.getMessage());
	    }

	    return dest; // Return the destination file
	}

	

	@Override
	public boolean clear(WebElement ele) {

		boolean flag = false;

	    try {
	        // Attempt to clear the element
	        ele.clear();
	        flag = true;
	        System.out.println("Element is cleared.");
	    } catch (Exception e) {
	        // Log the exception for debugging purposes
	        System.out.println("Exception occurred while clearing the element: " + e.getMessage());
	    } finally {
	        // Log success or failure
	        if (!flag) {
	            System.out.println("Element is not found or could not be cleared.");
	        }
	    }

	    return flag; // Return the result of the operation
	}
	

	@Override
	public void SendKeys(WebElement ele,String Text) {
		try {
	        // Send keys to the WebElement
	        ele.sendKeys(Text);
	        System.out.println("Text \"" + Text + "\" entered successfully into the element.");
	    } catch (Exception e) {
	        // Log any exception for debugging
	        System.out.println("Failed to enter text into the element: " + e.getMessage());
	    }
	}


}
