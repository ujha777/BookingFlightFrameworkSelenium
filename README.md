	Enter destination city and travel dates:
		WebElement destination = driver.findElement(By.id("ss"));
		destination.sendKeys("New York");
		WebElement checkIn = driver.findElement(By.id("checkin"));
		checkIn.sendKeys("2024-10-20");
		WebElement checkOut = driver.findElement(By.id("checkout"));
		checkOut.sendKeys("2024-10-25");
		//Click on the Search button:
		WebElement searchButton = driver.findElement(By.id("search-button"));
		searchButton.click();
		//Choose a hotel from the search results:
		List<WebElement> searchResults = driver.findElements(By.cssSelector(".sr-hotel"));
		searchResults.get(0).click();
		//Click on the Book Now button:
		WebElement bookNowButton = driver.findElement(By.id("bui-hotel"));
		bookNowButton.click();
		//Enter guest details:
		WebElement guestName = driver.findElement(By.id("guestname"));
		guestName.sendKeys("John Doe");
		WebElement guestEmail = driver.findElement(By.id("guestemail"));
		guestEmail.sendKeys("john.doe@example.com");
		//Select room type:
		WebElement roomType = driver.findElement(By.id("room-type"));
		roomType.click();
		//Enter payment information:
		WebElement cardNumber = driver.findElement(By.id("card-number"));
		cardNumber.sendKeys("1234567890123456");
		WebElement cvv = driver.findElement(By.id("cvv"));
		cvv.sendKeys("123");
		WebElement expiryDate = driver.findElement(By.id("expiry-date"));
		expiryDate.sendKeys("10/2025");
		//Click on the Confirm Booking button:
		WebElement confirmButton = driver.findElement(By.id("confirm-button"));
		confirmButton.click();
