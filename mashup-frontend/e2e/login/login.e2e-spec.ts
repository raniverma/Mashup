import { LoginPage } from './login.po';
import { browser, logging } from 'protractor';

describe('workspace-project LoginPage', () => {
  let page: LoginPage;

  beforeEach(() => {
    page = new LoginPage();

  });

  // for the display of Login button
  it('should display a Login button', () => {
    page.navigateToLogin();
    expect(page.getLoginButton());
  });


  // to view Sign Up button
  it('should display a SignUp button ', () => {
    page.navigateToLogin();
    expect(page.getSignUpButton());
  });

  // to check for the h4 text
  // it('should display the h4 text message', () => {
  //   page.navigateToLogin();
  //   expect(page.getLoginh4Text()).toEqual('Login');
  // });


  // it('should Route to home page on clicking signup', () => {
  //   page.navigateToLogin();
  //   page.getSignUpButton().click();
  //   browser.pause();
  //   // expect(page.getSyscopTitleText()).toEqual('SYSCOP');
  // });


  

  
  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    }));
  });
});
