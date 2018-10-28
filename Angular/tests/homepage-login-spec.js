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

        expect(element(by.id('welcome')).getText()).toEqual('Welcome admin');
    });
  });