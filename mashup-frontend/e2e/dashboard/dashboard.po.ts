import { getTestBed } from '@angular/core/testing';
import { browser, by, element } from 'protractor';

export class DashboardPage {
  navigateTo() {
    return browser.get('/');
  }

  navigateToDashboard() {
    return browser.get('');
  }

}
