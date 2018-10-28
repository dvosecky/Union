var angularHomepage = require('./pages/homepage.js');
describe('Testing homepage login', function() {
    var usernameField = element(by.id('email'));
    var passwordField = element(by.id('password'));
    var loginButton = element(by.id('submit-login'));

    beforeEach(function() {
      browser.get('http://18.220.118.195:8085/UnionFront/');    
    });

    it('should login successfully', function() {
        usernameField.sendKeys('admin');
        passwordField.sendKeys('admin');
    
        loginButton.click();

        //Element exists on welcome-admin page, but not login page. If logged in
        //as an admin which 'd' is, should find this element. Otherwise, not.
        expect(element(by.id('welcome-admin')).getText()).toBeTruthy;
    });

    it('should login successfully using POM', function() {
      angularHomepage.get();
      angularHomepage.setName('admin');
      angularHomepage.setPass('admin');
      angularHomepage.submit();

      expect(element(by.id('welcome-admin')).getText()).toBeTruthy;
    });

    it('should login successfully using POM efficiently', function() {
      angularHomepage.adminLogin();

      expect(element(by.id('welcome-admin')).getText()).toBeTruthy;
    });
  });