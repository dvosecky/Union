describe('Testing homepage login', function() {
  
    beforeEach(function() {
      browser.get('http://18.220.118.195:8085/UnionFront/');
    });
  
    it('should have a title', function() {
      expect(browser.getTitle()).toEqual('Union');
    });
  });