import { SignupPage } from './signup.po';
import { browser, logging } from 'protractor';

describe('workspace-project SignupPage', () => {
  let page: SignupPage;

  beforeEach(() => {
    page = new SignupPage();
  });

  // for the display of Login button
  it('should display a Signup button', () => {
    page.navigateToSignup();
    expect(page.getNextButton());
  });


  // to view cancel button
  it('should display a SignUp button ', () => {
    page.navigateToSignup();
    expect(page.getSignUpButton());
  });

  // to check for the h3 text
  // it('should display the h3 Sign Up text message', () => {
  //   page.navigateToSignup();
  //   expect(page.getSignuph3Text()).toEqual('Sign Up');
  // });


  // it('should Route to home page on clicking cancel', () => {
  //   page.navigateToSignup();
  //   page.getLoginButton().click();
  //   // browser.pause();
  //   // page.navigateTo();
  //   //expect(page.getlandingPageText()).toEqual('POWER YOUR METRICS WITH A LEADING OPEN SOURCE SOLUTION');
  // });


  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    }));
  });
});
