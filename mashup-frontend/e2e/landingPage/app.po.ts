import { getTestBed } from '@angular/core/testing';
import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('/') as Promise<any>;
  }
  navigateToRegister() {
    return browser.get('/register') as Promise<any>;
  }

  navigateToLogin() {
    return browser.get('/auth/login') as Promise<any>;
  }
  // navigateToFollowPage() {
  //   return browser.get('https://github.com/stackroute/boeing-wave3-syscop/tree/v1.0.2') as Promise<any>;
  // }


  getTitleText() {
    return element(by.css('app-root h1')).getText() as Promise<string>;
  }

  getRegisterText() {
    return element(by.css('app-signup h3')).getText() as Promise<string>;
  }

  getRegisterButton() {
    return element(by.buttonText('Next'));
  }

  getLoginButton() {
    return element(by.buttonText('Login'));
  }

  // getCancelButton() {
  //   return element(by.buttonText('Cancel'));
  // }

  getLoginText() {
    return element(by.css('app-login h4')).getText() as Promise<string>;
  }

  

  getFollowButton(){
    return element(by.buttonText('Follow'));
  }  

}
