var angularHomepage = require('./AngularHomepage');
describe('Testing homepage login', function() {
    var usernameField = element(by.id('email'));
    var passwordField = element(by.id('password'));
    var loginButton = element(by.id('submit-login'));

    beforeEach(function() {
      browser.get('http://18.220.118.195:8085/UnionFront/');    
    });

    it('should login successfully', function() {
        usernameField.sendKeys('d');
        passwordField.sendKeys('d');
    
        loginButton.click();

        //Element exists on welcome-admin page, but not login page. If logged in
        //as an admin which 'd' is, should find this element. Otherwise, not.
        expect(element(by.id('welcome-admin')).getText()).toBeTruthy;
    });

    it('should login successfully using POM', function() {
      angularHomepage.get();
      angularHomepage.setName('d');
      angularHomepage.setPass('d');
      angularHomepage.submit();

      expect(element(by.id('welcome-admin')).getText()).toBeTruthy;
    });
  });