Feature: Validate BlankFactor navigation

  Scenario: Navigate and validate content on Retirement and Wealth page then print page url and page title
    Given Navigate to the page blankFactor
    #And BlankFactor page, Click the cookie policy Click on the button with the value ACCEPT OUR POLICY
    And BlankFactor page, hover text title with the value Industries and after click on the link with the value "Retirement and wealth"
    When BlankFactor page, verify on the page the value "AI & Machine learning" copy the internal text
    And BlankFactor page, click on "Let's get started"
    But BlankFactor page, get the page URL
    Then BlankFactor page, verify the page URL is correct "https://blankfactor.com/contact/"
