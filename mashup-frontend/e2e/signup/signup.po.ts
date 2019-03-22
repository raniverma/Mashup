import { getTestBed } from '@angular/core/testing';
import { browser, by, element } from 'protractor';

export class SignupPage {
  navigateTo() {
    return browser.get('/');
  }

  navigateToLogin() {
    return browser.get('/auth/login');
  }

  navigateToSignup() {
    return browser.get('/register');
  }

  getLoginButton() {
    return element(by.buttonText('Login'));
  }

  getNextButton() {
    return element(by.buttonText('Next'));
  }

  // getSignuph3Text(){
  //   return element(by.css('app-signup h3')).getText() as Promise<string>;
  // }

   getSignUpButton() {
     return element(by.buttonText('Sign Up'));
   }

    getSyscopTitleText() {
    return element(by.css('app-landing h1')).getText();
  }

  getlandingPageText() {
    return element(by.css('app-landing h6')).getText();
  }

}
