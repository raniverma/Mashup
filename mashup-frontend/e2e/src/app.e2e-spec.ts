import { AppPage } from './app.po';
import { browser, by } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should go to Login page', () => {
    page.navigateTo();
    expect(browser.getTitle()).toEqual('MASHUP');
  });
  it('should redirected to /home route on opening the application', () => {
    browser.driver.manage().window().maximize();
    browser.driver.sleep(1000);
    expect(browser.getCurrentUrl()).toContain('/home');
  });
  // it('should redirected to /register route ', () => {
  //   browser.element(by.css('.Sign Up-button')).click();
  //   browser.driver.sleep(1000);
  //   expect(browser.getCurrentUrl()).toContain('/register');
  // });
  // it('should be able to register user', () => {
  //   browser.driver.sleep(1000);
  //   browser.element(by.id('firstName')).sendKeys('Super First User');
  //   browser.element(by.id('lastName')).sendKeys('Super Last User');
  //   browser.element(by.id('userId')).sendKeys('super@gmail.com');
  //   browser.element(by.id('password')).sendKeys('Super Userpass');
  //   browser.element(by.css('.register-user')).click();
  //   expect(browser.getCurrentUrl()).toContain('/auth/login');
  // });
  // it('should be able to login', () => {
  //   browser.driver.sleep(1000);
  //   browser.element(by.id('userId')).sendKeys('super@gmail.com');
  //   browser.element(by.id('password')).sendKeys('Super Userpass');
  //   browser.element(by.css('.login-user')).click();
  //   expect(browser.getCurrentUrl()).toContain('/topic');
  // });
  // it('should be able to add a topic', () => {
  //   browser.driver.sleep(1000);
  //   browser.element(by.css('.enter-topic')).sendKeys('Earth');
  //   browser.element(by.css('.add-description')).sendKeys('This topic discusses about earth');
  //   browser.element(by.css('.submit-button')).click();
  //   browser.driver.sleep(1000);
  //   browser.element(by.css('.view-topic-details')).click();
  //   expect(browser.getCurrentUrl()).toContain('/question');
  // });
  // it('should be able to add a question', () => {
  //   browser.driver.sleep(1000);
  //   browser.element(by.css('.question-input')).sendKeys('Why sky is blue?');
  //   browser.element(by.css('.submit-button')).click();
  //   browser.driver.sleep(1000);
  //   browser.element(by.css('.view-comments')).click();
  //   expect(browser.getCurrentUrl()).toContain('/comment');
  // });
  // it('should be able to add a comment', () => {
  //   browser.driver.sleep(1000);
  //   browser.element(by.css('.comment-input')).sendKeys('The sky appears blue due to dispersion effect');
  //   browser.element(by.css('.submit-button')).click();
  //   browser.driver.sleep(1000);
  // });
  // it('should be able to logout', () => {
  //   browser.element(by.css('.logout')).click();
  //   expect(browser.getCurrentUrl()).toContain('/login');
  // });

});
