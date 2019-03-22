import { getTestBed } from '@angular/core/testing';
import { browser, by, element } from 'protractor';

export class LoginPage {
  navigateTo() {
    return browser.get('/');
  }

  navigateToLogin() {
    return browser.get('/login');
  }

  getLoginButton() {
    return element(by.buttonText('Login'));
  }

  getSignUpButton() {
    return element(by.buttonText('Sign Up'));
  }

  // getLoginh4Text() {
  //   return element(by.css('app-login h4')).getText() as Promise<string>;
  // }

  // getCancelButton(){
  //   return element(by.buttonText('Cancel'));
  // }

  //   getSyscopTitleText() {
  //   return element(by.css('app-landing h1')).getText() as Promise<string>;
  // }

  

 
}
