import { DashboardPage } from './dashboard.po';
import { browser, logging } from 'protractor';

describe('workspace-project LoginPage', () => {
  let page: DashboardPage;

  beforeEach(() => {
    page = new DashboardPage();
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    }));
  });
});
