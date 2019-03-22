import { AppPage } from './app.po';
import { browser, logging } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  // to display the title text
  it('should display the Title message', () => {
    page.navigateTo();
    expect(page.getTitleText()).toEqual('MASHUP');
  });


  // for the display of register button
  it('should display a register button', () => {
    page.navigateToRegister();
    expect(page.getRegisterButton());
  });

  // for the display of Login button
  it('should display a Login button', () => {
    page.navigateToLogin();
    expect(page.getLoginButton());
  });

  // to route to the Sign up page
  // it('should Route to  Register Sign up Page', () => {
  //   page.navigateTo();
  //   browser.pause();
  //   page.getRegisterButton().click();
  //   expect(page.getRegisterText()).toEqual('Sign Up');
  // });

  // to view cancel button
  // it('should display a Cancel button ', () => {
  //   page.navigateToLogin();
  //   expect(page.getCancelButton());
  // });

  // to route to the Login up page
  // it('should Route to  Login Page', () => {
  //   page.navigateTo();
  //   browser.pause();
  //   page.getLoginButton().click();
  //   expect(page.getLoginText()).toEqual('Login');
  // });


  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    }));
  });
});
